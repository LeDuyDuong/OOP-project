package Entity;

import Main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;


public class NPC_Student extends Entity{
    public NPC_Student(GamePanel gp){
        super(gp);
        direction ="down";
        speed=2;
        setImage();
        solidArea = new Rectangle();
        solidArea.x= 8;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=32;
        solidArea.height=32;

    }
    public void setImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Student/NPC_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Student/NPC_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Student/Npc_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Student/Npc_down2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Student/NPC_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Student/NPC_right2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Student/NPC_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Student/NPC_left2.png"));


        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setAction(){
        actionLockCounter++;
       if(actionLockCounter==200){
       Random random = new Random();
        int i= random.nextInt(100)+1;// pick a number for running
       if(i<=25){
            direction="up";
       }
        if(i>25 && i<+50){
            direction="down";
       }
        if(i>50 && i<=75) {
           direction="left";
        }
       if(i>75 && i<=100) {
           direction="right";
       }
       actionLockCounter=0;
       }
        }

    }


