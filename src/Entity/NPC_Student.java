package Entity;

import Main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;


public class NPC_Student extends Entity{
    public NPC_Student(GamePanel gp){
        super(gp);
        direction ="up";
        speed=2;
        setImage();

    }
    public void setImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Student-clone/Student_clone.png"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
