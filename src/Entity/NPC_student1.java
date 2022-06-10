package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class NPC_student1 extends Entity {
    public NPC_student1(GamePanel gp){
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
        dialogues[0]="Dm Hu Hiep va Khoa vo";
        dialogues[1]="Vinh Dep Trai";

    }
    public void setImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void speak(){
        super.speak();
    }
}
