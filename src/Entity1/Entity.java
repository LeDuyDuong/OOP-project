package Entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;

    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, right1, right2, left1,left2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum=1;

    public Rectangle solidArea=new Rectangle(0,0,48,48);
    //collision for object
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn= false;
    public Entity(GamePanel gp){
        this.gp=gp;
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX= worldX- gp.player.worldX+gp.player.screenX;
        int screenY= worldY- gp.player.worldY+gp.player.screenY;
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



}
