package Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
public class NPC_Amber extends Entity {
        public NPC_Amber(GamePanel gp){
            super(gp);
            direction ="up";
            setImage();
            setDialogue();

        }
        public void setDialogue(){
            dialogues[0]="Duong da ia tren giuong tui";


        }
        public void setImage() {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Amber Heard/Amber.png"));


            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        public void speak(){
            super.speak();
        }
    }

