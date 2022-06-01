package Main;

import Entity.Entity;

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
    public int slotCol=0;
    public int slotRow=0;
    int counter=0;
    public Entity npc;
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
        //player State
        if(gp.gameState== gp.characterState){
            drawInventory();
        }
        //transitionState
        if(gp.gameState==gp.transitionState){
            drawTransition();
        }
        //buyingState
        if(gp.gameState== gp.buyingState){
            drawBuyingScreen();
        }
        if(gp.gameState==gp.messageState){
            drawMessage(message);
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
        Text= "PLAY";
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
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        x+=gp.tileSize;
        y+=gp.tileSize;
        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }

    }
    public void drawSubWindow(int x,int y, int width,int height){
        Color c=new Color(0,0,0,150);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public void drawPauseScreen() {
        drawSubWindow(120,40, 500, 500);
        this.g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        g2.setColor(Color.WHITE);
        String text = "PAUSED";
        int x = getXForCenteredText(text);
        int y = gp.tileSize*3;
        g2.drawString(text,x,y);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40F));
        String Text= "CONTINUE";
        x=getXForCenteredText(Text);
        y+=gp.tileSize*3.5;
        g2.drawString(Text, x, y);
        if(commandNum==0){
            g2.drawString(">", x-gp.tileSize,y);
        }
        Text= "BACK TO MENU";
        x=getXForCenteredText(Text);
        y+=gp.tileSize;
        g2.drawString(Text, x, y);
        if(commandNum==1){
            g2.drawString(">", x-gp.tileSize,y);
        }

    }

    public void drawInventory(){
        //slotRow=0;
        //slotCol=0;
        //Frame
        int frameX=gp.tileSize*10;
        int frameY=gp.tileSize;
        int frameWidth=gp.tileSize*6;
        int frameHeight=gp.tileSize*5;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        //Slot
        final int  slotStartX=frameX+20;
        final int slotStartY= frameY+20;
        int slotX=slotStartX;
        int slotY=slotStartY;

        //Draw player Inventory

        for(int i=0;i<gp.player.inventory.size();i++){
            g2.drawImage(gp.player.inventory.get(i).down1,slotX,slotY,null);
            slotX+=gp.tileSize;
            if(i==4 || i==9 || i==14 ){
                slotY+= gp.tileSize;
            }
        }
        //cursor
        int cursorX=slotStartX+(gp.tileSize*slotCol);
        int cursorY=slotStartY+(gp.tileSize*slotRow);
        int cursorWidth=gp.tileSize;
        int cursorHeight=gp.tileSize;
        g2.setColor(Color.WHITE);g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

        //description Frame
        int dframeX=frameX;
        int dframeY=frameY+frameHeight;
        int dframeWidth=frameWidth;
        int dframeHeight=gp.tileSize*3;
        drawSubWindow(dframeX,dframeY,dframeWidth,dframeHeight);

        int textX= dframeX+20;
        int textY = dframeY+gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(20F));
        int itemIndex=getItemIndexOnSlot();

        if(itemIndex<gp.player.inventory.size()){
            for(String line: gp.player.inventory.get(itemIndex).description.split("\n")){
                g2.drawString(line,textX,textY);
                textY+=30;
            }
        }
    }

    public int getItemIndexOnSlot(){
        int itemIndex= slotCol+ slotRow*5;
        return itemIndex;
    }
    public int getXForCenteredText(String text) {
        int length  = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

    public void drawTransition(){
        counter++;
        g2.setColor(new Color(0,0,0,counter*5));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);

        if(counter==50){
            counter=0;
            gp.gameState= gp.playState;
            gp.currentMap=gp.eHandler.tempMap;
            gp.player.worldX=gp.tileSize*gp.eHandler.tempCol;
            gp.player.worldY=gp.tileSize*gp.eHandler.tempRow;
            gp.eHandler.previousEventX=gp.player.worldX;
            gp.eHandler.previousEventY=gp.player.worldY;
        }
    }

    public void drawBuyingScreen(){

        gp.keyHandler.enterPressed=false;
        drawDialogueScreen();
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        String Text= "YES";
        int x= getXForCenteredText(Text);
        int y= gp.tileSize*3;
        x=getXForCenteredText(Text);
        g2.drawString(Text, x, y);
        if(commandNum==0){
            g2.drawString(">", x-gp.tileSize,y);
        }
        Text= "NO";
        x=getXForCenteredText(Text);
        y+=gp.tileSize;
        g2.drawString(Text, x, y);
        if(commandNum==1){
            g2.drawString(">", x-gp.tileSize,y);
        }

    }
    public void drawMessage(String message){
        int x=gp.tileSize*2;
        int y=gp.tileSize/2;
        int width=gp.screenWidth-(gp.tileSize*4);
        int height= gp.tileSize*4;
        drawSubWindow(x,y,width,height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        x+=gp.tileSize-20;
        y+=gp.tileSize;
        for(String line: message.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }
    }

    public void setMessage(String x){
        message=x;
    }
}
