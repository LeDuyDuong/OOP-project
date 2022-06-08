package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class NPC_Secu extends Entity {
    public NPC_Secu(GamePanel gp){
        super(gp);
        name = "Security";
        setImage();
        setDialogue();
        direction ="up";
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
            up1 = ImageIO.read(getClass().getResourceAsStream("/Student/security.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Student/security.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/NPC-security/havecoffe.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/NPC-security/havecoffe.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Student/security.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Student/security.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Student/security.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Student/security.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setDialogue(){
        dialogues[0]="Want to get in this room ?" +
                "\nFine! but you must have something in exchange.\n" +
                "I'm feeling a bit sleepy\n" +
                "Can you buy me a cup of coffee ?";
        dialogues[1]="You have my coffee yet ?";
        dialogues[2]="Keep up the good work";
    }

    public void speak(){
        if(actionCounter ==0){
            gp.ui.currentDialogue=dialogues[actionCounter];
            gp.gameState=gp.messageState;
            gp.ui.drawMessage(gp.ui.currentDialogue);
            actionCounter++;
            //System.out.println(actionCounter);
        } else if (actionCounter ==1) {
            gp.ui.currentDialogue=dialogues[actionCounter];
            gp.gameState=gp.talkingToSecuState;
            //actionCounter++;
        } else if (actionCounter ==2) {
            gp.ui.currentDialogue=dialogues[actionCounter];
            gp.gameState=gp.dialogueState;
        }
    }
}

