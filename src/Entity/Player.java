package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    KeyHandler keyHandler;
    public final int screenX;
    public final int screenY;
    int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyHandler=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        direction = "down";

        solidArea = new Rectangle(8,16,32,32);
        //position of collision for object
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX= 3* gp.tileSize;
        worldY= 29* gp.tileSize;
        speed =4;
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/character and NPC/detective/detective_left_2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed==true || keyHandler.downPressed==true
                || keyHandler.leftPressed == true || keyHandler.rightPressed==true) {
            if(keyHandler.upPressed == true) {direction="up";}

            if(keyHandler.downPressed == true) {
                direction="down";
            }

            if(keyHandler.rightPressed == true) {
                direction="right";
            }

            if(keyHandler.leftPressed == true) {
                direction="left";
            }

            //Check TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //Check OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);


            // IF COLLISION IS FALSE, PLAYER CAN MOVE
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
    }

    public void pickUpObject(int i){
        if(i!=999){
            //gp.obj[i] = null;

            String objectName = gp.obj[i].name;

            switch (objectName){
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("Key:" + hasKey);
                    break;
                case "Door":
                    if(hasKey>0) {
                        gp.obj[i] = null;
                        hasKey--;
                    }
                    System.out.println("Key:" + hasKey);
                    break;
            }
        }
    }


    public void draw(Graphics2D g2) {
        BufferedImage image = null;
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
        int x=screenX;
        int y=screenY;
        if(screenX>worldX){
            x= worldX;
        }
        if(screenY>worldY){
            y=worldY;
        }
        int rightOffset=gp.screenWidth-screenX;
        if(rightOffset>gp.worldWidth-worldX){
            x= gp.screenWidth-(gp.worldWidth-worldX);
        }
        int bottomOffset=gp.screenHeight-screenY;
        if(bottomOffset>gp.worldHeight-worldY) {
            y = gp.screenHeight - (gp.worldWidth - worldY);
        }
        g2.drawImage(image,x,y,gp.tileSize, gp.tileSize,null,null);
    }
}

    

