package Entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {
    public BufferedImage img, img1, img2;
    public String name;
    public boolean collision = false;
    GamePanel gp;

    public int worldX, worldY;
    public int speed;
    public int actionCounter =0;

    public BufferedImage up1, up2, down1, down2, right1, right2, left1,left2;
    public String direction= "down";

    public int spriteCounter = 0;
    public int spriteNum=1;

    public Rectangle solidArea=new Rectangle(0,0,48,48);
    //collision for object
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn= false;
    public int actionLockCounter =0;
    public String description="";
    String dialogues[]=new String[20];
    int dialogueIndex=0;
    public Entity(GamePanel gp){
        this.gp=gp;
    }
    public void setAction(){}
    public void speak(){
        if(dialogues[dialogueIndex+1]==null){
            dialogueIndex=0;
        }
        gp.ui.currentDialogue=dialogues[dialogueIndex];
        dialogueIndex++;
        switch(gp.player.direction){
            case"up":
                direction="down";
                break;
            case"down":
                direction="up";
                break;
            case"left":
                direction="right";
                break;
            case"right":
                direction="left";
                break;
        }

    }
    public void update(){
        setAction();
        collisionOn=false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkPlayer(this);

        if (collisionOn == false) {
            switch(direction) {
                case "up":
                    worldY-=speed;
                    break;
                case "down":
                    worldY+=speed;
                    break;
                case "right":
                    worldX+=speed;
                    break;
                case "left":
                    worldX-=speed;
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX= worldX- gp.player.worldX+gp.player.screenX;
        int screenY= worldY- gp.player.worldY+gp.player.screenY ;
        if(gp.player.screenX>gp.player.worldX){
            screenX=worldX;
        }
        if(gp.player.screenY>gp.player.worldY){
            screenY=worldY;
        }
        int     rightOffset=gp.screenWidth-gp.player.screenX;
        if(rightOffset>gp.worldWidth-gp.player.worldX){
            screenX= gp.screenWidth-(gp.worldWidth-worldX);
        }
        int bottomOffset=gp.screenHeight-gp.player.screenY;
        if(bottomOffset> gp.worldHeight-gp.player.worldY){
            screenY= gp.screenHeight-(gp.worldWidth-worldY);
        }
        if(        worldX+gp.tileSize>gp.player.worldX-gp.player.screenX
                && worldX-gp.tileSize<gp.player.worldX+gp.player.screenX
                && worldY+gp.tileSize>gp.player.worldY-gp.player.screenY
                && worldY-gp.tileSize<gp.player.worldY+gp.player.screenY){
            switch(direction) {
                case "up":
                    if (spriteNum==1) {
                        image = up1;
                    }
                    if(spriteNum==2) {
                        image =up2;
                    }
                    break;

                case "down":
                    if (spriteNum==1) {
                        image = down1;
                    }
                    if(spriteNum==2) {
                        image =down2;
                    }
                    break;

                case "right":
                    if (spriteNum==1) {
                        image = right1;
                    }
                    if(spriteNum==2) {
                        image =right2;
                    }
                    break;
                case "left":
                    if (spriteNum==1) {
                        image = left1;
                    }
                    if(spriteNum==2) {
                        image =left2;
                    }
                    break;
            }

            g2.drawImage(image, screenX, screenY,gp.tileSize, gp.tileSize,null);
        }else if(gp.player.screenX>gp.player.worldX ||
                gp.player.screenY>gp.player.worldY||
                rightOffset>gp.worldWidth-gp.player.worldX||
                bottomOffset>gp.worldHeight-gp.player.worldY){
            switch(direction) {
                case "up":
                    if (spriteNum==1) {
                        image = up1;
                    }
                    if(spriteNum==2) {
                        image =up2;
                    }
                    break;

                case "down":
                    if (spriteNum==1) {
                        image = down1;
                    }
                    if(spriteNum==2) {
                        image =down2;
                    }
                    break;

                case "right":
                    if (spriteNum==1) {
                        image = right1;
                    }
                    if(spriteNum==2) {
                        image =right2;
                    }
                    break;
                case "left":
                    if (spriteNum==1) {
                        image = left1;
                    }
                    if(spriteNum==2) {
                        image =left2;
                    }
                    break;
            }

            g2.drawImage(image, screenX, screenY,gp.tileSize, gp.tileSize,null);
        }

    }

    public BufferedImage setup(String imagepath){
        UtilityTool uTool= new UtilityTool();
        BufferedImage img= null;
        try{
            img= ImageIO.read(getClass().getResourceAsStream(imagepath+".png"));
            img= uTool.scaleImage(img, gp.tileSize,gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
        return img;
    }



}
