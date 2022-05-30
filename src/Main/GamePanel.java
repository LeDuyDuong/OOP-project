package Main;

import Entity.Entity;
import Entity.Player;
import Tiles.TilesManager;
import object.SuperObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public int gameState;
    public final int tittleState=0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState =3;

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize* scale;
    public final int maxScreenCol =16;
    public final int maxScreenRow=12;

    public final int screenWidth = tileSize * maxScreenCol; //768
    public final int screenHeight= tileSize * maxScreenRow; //576

    //World SETTINGS
    public final int maxWorldCol=36;
    public final int maxWorldRow=36;
    public final int maxMap = 20;
    public int currentMap = 0;

    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;

    //GAME STATE


    public EventHandler eHandler = new EventHandler(this);

    Sound sound = new Sound();            //SOUND
    public KeyHandler keyHandler = new KeyHandler(this); //KEY
    public UI ui = new UI(this); //UI
    Thread gameThread;

    public CollisionChecker cChecker = new CollisionChecker(this);

    int FPS = 60;
    TilesManager tilesM = new TilesManager(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this,keyHandler);

    //initialize 40 objects in same time
    public SuperObject obj[][] = new SuperObject[maxMap][40];

    //initialize 20 npc in same time
    public  Entity npc[][]=new Entity[maxMap][20];
    //Game State


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
        //playMusic(0);
    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        gameState = tittleState ;
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
        if (gameState == playState) {
            player.update();
        }
        //npc
        for(int i=0;i<npc.length;i++){
            if(npc[currentMap][i]!=null){
                npc[currentMap][i].update();
            }
        }
        if (gameState == pauseState) {
            //do notthing
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if(gameState== tittleState){
            ui.draw(g2);
        }else{
            //tile
            tilesM.draw(g2);

            //object
            for(int i =0 ; i < obj[1].length ; i++){
                if(obj[currentMap][i] != null){
                    obj[currentMap][i].draw(g2, this);
                }
            }
            //npc
            for(int i =0 ; i < npc[1].length ; i++){
                if(npc[currentMap][i] != null){
                    npc[currentMap][i].draw(g2);
                }
            }

            //player
            player.draw(g2);
            //UI
            ui.draw(g2);
        }



        if(keyHandler.showDebugText==true){
            g2.setFont(new Font("Arial",Font.PLAIN, 20));
            g2.setColor(Color.black);
            int x= 10; int y=400;
            int lineHeight= 20;
            g2.drawString("World X: "+ player.worldX,x,y);
            y+=lineHeight;
            g2.drawString("World Y: "+ player.worldY,x,y);
            y+=lineHeight;
            g2.drawString("Col: "+ (player.worldX+player.solidArea.x)/tileSize, x,y);
            y+=lineHeight;
            g2.drawString("Row: "+ (player.worldY+player.solidArea.y)/tileSize, x,y);

        }
        ui.draw(g2);
        g2.dispose();
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic() {
        sound.stop();
    }
    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }
}
