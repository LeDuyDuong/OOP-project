package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class NPC_Trader extends Entity {
    public NPC_Trader(GamePanel gp){
        super(gp);
        name = "Trader";
        setImage();
        setDialogue();
        direction ="down";
        // down1=setup("/objects/vending_machine_1");
        solidArea = new Rectangle();
        solidArea.x= 0;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=46;
        solidArea.height=16;
        collision=true;
    }

    public void setImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));;
            left2 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Student/toc_hong.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setDialogue(){
        dialogues[0]="Aaaah!So, you are the detective guy." + "\nAlright, get me a LOLIpop in room B2.6 \nand I get you some hints.";
        dialogues[1]="You got that Juicy LOLIpop yet man ?";
        dialogues[2]="You got what you want yo!\nI'm, having fun with my LOLIpop\nStay away!";
    }

    public void speak(){
        if(actionCounter ==0){
            gp.ui.currentDialogue=dialogues[actionCounter];
            gp.gameState=gp.messageState;
            gp.ui.drawMessage(gp.ui.currentDialogue);
            actionCounter++;
            System.out.println(actionCounter);
        } else if (actionCounter ==1) {
            gp.ui.currentDialogue=dialogues[actionCounter];
            gp.gameState=gp.tradingState;
            //actionCounter++;
        } else if (actionCounter ==2) {
            gp.ui.currentDialogue=dialogues[actionCounter];
            gp.gameState=gp.dialogueState;
        }
    }
}

