package Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
public class NPC_Amber extends Entity {
        public NPC_Amber(GamePanel gp){
            super(gp);
            direction ="up";
            setImage();
            setDialogue();
            solidArea = new Rectangle();
            solidArea.x= 8;
            solidArea.y=16;
            solidAreaDefaultX=solidArea.x;
            solidAreaDefaultY=solidArea.y;
            solidArea.width=32;
            solidArea.height=32;

        }
        public void setDialogue(){
            dialogues[0]="Duong da ia tren giuong tui";


        }
        public void setImage() {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/down1.png"));


            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        public void speak(){
            super.speak();
        }
    }

