package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class UI {
    Graphics2D g2;
    GamePanel gp;
    Font arial_40;
    public boolean messageOn = false;
    public String message =  "";
    public String currentDialogue="";
    public int commandNum= 0;
    public UI (GamePanel gp) {
        this.gp = gp;
        arial_40 =  new Font("Arial", Font.PLAIN, 40);
    }
    public void showMessage(String text) {
        message = text;
        messageOn=true;
    }

    public void draw(Graphics2D g2) {
        this.g2=g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        //tittle State
        if(gp.gameState==gp.tittleState){
            drawTittleScreen();
        }
        //play state
        if (gp.gameState==gp.playState) {

        }
        //Pause state
        if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
        // dialogue state
        if(gp.gameState==gp.dialogueState) {
            drawDialogueScreen();

        }
    }
    public void drawTittleScreen(){
        g2.setColor(Color.black);

        //g2.drawImage(img,0,0,gp.screenWidth, gp.screenHeight, null);
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        //Tittle name

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 69F));
        String Text= "IU DETECTIVE";
        int x= getXForCenteredText(Text);
        int y= gp.tileSize*3;
        g2.setColor(Color.gray);
        g2.drawString(Text, x+3,y+3);
        g2.setColor(Color.WHITE);
        g2.drawString(Text, x,y);


        //DECTECTIVE
        x=gp.screenWidth/2 -(gp.tileSize/2)-20;
        y+=gp.tileSize*2;
        g2.drawImage(gp.player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        Text= "START";
        x=getXForCenteredText(Text);
        y+=gp.tileSize*3.5;
        g2.drawString(Text, x, y);
        if(commandNum==0){
            g2.drawString(">", x-gp.tileSize,y);
        }
        Text= "ABOUT";
        x=getXForCenteredText(Text);
        y+=gp.tileSize;
        g2.drawString(Text, x, y);
        if(commandNum==1){
            g2.drawString(">", x-gp.tileSize,y);
        }
        Text= "QUIT";
        x=getXForCenteredText(Text);
        y+=gp.tileSize;
        g2.drawString(Text, x, y);
        if(commandNum==2){
            g2.drawString(">", x-gp.tileSize,y);
        }
    }
    public void drawDialogueScreen(){
        //Window
        int x=gp.tileSize*2;
        int y=gp.tileSize/2;
        int width=gp.screenWidth-(gp.tileSize*4);
        int height= gp.tileSize*4;
        drawSubWindow(x,y,width,height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
        x+=gp.tileSize;
        y+=gp.tileSize;
        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }

    }
    public void drawSubWindow(int x,int y, int width,int height){
        Color c=new Color(0,0,0,200);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public void drawPauseScreen() {
        this.g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        int y = gp.screenHeight/2;
        g2.drawString(text,x,y);
    }

    public int getXForCenteredText(String text) {
        int length  = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
