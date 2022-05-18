package Main;

import Entity.Player;
import Tiles.TilesManager;
import object.SuperObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize* scale;
    public final int maxScreenCol =16;
    public final int maxScreenRow=12;

    public final int screenWidth = tileSize * maxScreenCol; //768
    public final int screenHeight= tileSize * maxScreenRow; //576

    //World SETTINGS
    public final int maxWorldCol=35;
    public final int maxWorldRow=35;

    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);

    int FPS = 60;
    TilesManager tilesM = new TilesManager(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,keyHandler);

    //initialize 10 objects in same time
    public SuperObject obj[] = new SuperObject[10];



    //initial position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY );

        this.setDoubleBuffered(true); //for rendering

        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta>=1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        //tile
        tilesM.draw(g2);

        //object
        for(int i =0 ; i < obj.length ; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        //player
        player.draw(g2);
        if(keyHandler.showDebugText==true){
            g2.setFont(new Font("Arial",Font.PLAIN, 20));
            g2.setColor(Color.white);
            int x= 10; int y=400;
            int lineHeight= 20;

        }
        g2.dispose();
    }
}
