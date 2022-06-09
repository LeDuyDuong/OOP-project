package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import Main.UtilityTool;
import object.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity{
    KeyHandler keyHandler;
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    public int hasCoin = 0;
    public int hasLoli = 0;
    public int hasBag = 0;
    public int hasCoffe = 0;
    public int hasOwl = 0;
    public ArrayList<Entity> inventory= new ArrayList<>(20);
    public final int inventorySize=20;
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp=gp;
        this.keyHandler=keyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        //direction = "down";

        solidArea = new Rectangle(8,16,32,32);
        //position of collision for object
        solidArea.x=8;
        solidArea.y=16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImage();
        setItems();
    }

    public void setDefaultValues() {
        worldX= 3* gp.tileSize;
        worldY= 29* gp.tileSize;
        speed =4;
    }
    public void getPlayerImage() {
            up1 = setUpPlayer("/character and NPC/detective/detective_up_1.png");
            up2 = setUpPlayer("/character and NPC/detective/detective_up_2.png");
            down1 = setUpPlayer("/character and NPC/detective/detective_down_1.png");
            down2 = setUpPlayer("/character and NPC/detective/detective_down_2.png");
            right1 = setUpPlayer("/character and NPC/detective/detective_right_1.png");
            right2 = setUpPlayer("/character and NPC/detective/detective_right_2.png");
            left1 = setUpPlayer("/character and NPC/detective/detective_left_1.png");
            left2 = setUpPlayer("/character and NPC/detective/detective_left_2.png");
    }
    public BufferedImage setUpPlayer(String imageName) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imageName));
            image = uTool.scaleImage(image, gp.tileSize,gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void setItems(){

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
            // Check NPC collision
            int npcIndex =gp.cChecker.checkEntity(this,gp.npc);

            interactNPC(npcIndex);

            //CHECK EVENT
            gp.eHandler.checkEvent();

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

            String objectName = gp.obj[gp.currentMap][i].name;

            switch (objectName){
//                case "Door":
//                    if(hasKey>0) {
//                        gp.obj[gp.currentMap][i] = null;
//                        hasKey--;
//                    }
                    //System.out.println("Key:" + hasKey);
                    //break;
                //case "Cup of Coffee":
//                    gp.obj[gp.currentMap][i] = null;
//                    inventory.add(new OBJ_Coffee_cup(gp));
//                    break;
                case "Coin":
                    Entity c = new OBJ_Coin(gp);
                    inventory.add(c);
                    hasCoin++;
                    gp.ui.setMessage("YOU FOUND A COIN");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    /*
                    inventory.add(new OBJ_Paper_B26(gp));
                    gp.ui.setMessage("YOU FOUND A HINT PAPER");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                    */
                    break;
                case "Key":
                    gp.obj[gp.currentMap][i] = null;
                    hasKey++;
                    System.out.println("Key:" + hasKey);
                    inventory.add(new OBJ_Key(gp));
                    break;
                case "Paper":
                    Entity a= new OBJ_Paper(gp);
                    a.description=gp.obj[gp.currentMap][i].description;
                    inventory.add(a);
                    gp.obj[gp.currentMap][i] = null;
                    gp.ui.setMessage("YOU FOUND A PIECE OF PAPER");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                case "Paper_Yellow":
                    Entity b= new OBJ_Paper_Yellow(gp);
                    b.description=gp.obj[gp.currentMap][i].description;
                    inventory.add(b);
                    gp.ui.setMessage("YOU FOUND A PIECE OF PAPER");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                case "Lolipop":
                    inventory.add(new OBJ_Lolipop(gp));
                    gp.obj[gp.currentMap][i] = null;
                    hasLoli++;
                    gp.ui.setMessage("YOU A LOLIpop");
                    gp.gameState= gp.messageState;
                    break;
                case "Paper_B26":
                    inventory.add(new OBJ_Paper_B26(gp));
                    gp.ui.setMessage("YOU FOUND A HINT PAPER");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                case "Owl":
                    hasOwl++;
                    inventory.add(new OBJ_Owl(gp));
                    gp.obj[gp.currentMap][i] = null;
                    gp.ui.setMessage("YOU FOUND A LITTLE OWL");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                case "Backpack":
                    hasBag++;
                    inventory.add(new OBJ_Backpack(gp));
                    gp.obj[gp.currentMap][i] = null;
                    gp.ui.setMessage("YOU FOUND AMBER'S BACKPACK!");
                    gp.gameState= gp.messageState;
                    gp.obj[gp.currentMap][i] = null;
                    break;
                case "Informer":
                    gp.obj[gp.currentMap][i] = null;
                    gp.ui.setMessage("There is a girl crying over there.Maybe I can help her,\n cause I'm something of a detective myself");
                    gp.gameState= gp.messageState;
                    break;
            }
        }
    }
    public void interactNPC(int i){
        if(i!=999){
            if(gp.keyHandler.enterPressed==true){
            gp.gameState=gp.dialogueState;
            gp.npc[gp.currentMap][i].speak();}
        }
        gp.keyHandler.enterPressed=false;
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
        g2.drawImage(image,x,y,null);
    }
}

    

