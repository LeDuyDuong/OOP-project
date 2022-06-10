package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class OBJ_Vending_Machine extends Entity {
    public OBJ_Vending_Machine(GamePanel gp){
        super(gp);
        name = "Vending_Machine";
        setImage();
        setDialogue();
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
            up1 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/objects/vending_machine_1.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void setDialogue(){
        dialogues[0]="USE 1 COIN TO BUY 1 CUP OF COFFEE ?";
    }
    public void speak(){
        super.speak();
        gp.gameState= gp.buyingState;
    }
}
