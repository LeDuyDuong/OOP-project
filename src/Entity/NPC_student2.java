package Entity;

import Main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;

public class NPC_student2 extends Entity {
    public NPC_student2(GamePanel gp){
        super(gp);
        direction ="up";
        setImage();
        setDialogue();
}
    public void setDialogue(){
        dialogues[0]="Don't bother me.";
    }
    public void setImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student-clone2/Student_clone2.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void speak(){
        super.speak();
    }
}




