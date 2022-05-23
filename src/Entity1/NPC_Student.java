package Entity;

import Main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;


public class NPC_Student extends Entity{
    public NPC_Student(GamePanel gp){
        super(gp);

        direction ="down";
        speed=2;
        setImage();

    }
    public void setImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/student1/NPC_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/student1/NPC_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/student1/Npc_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/student1/Npc_down2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/student1/NPC_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/student1/NPC_right2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/student1/NPC_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/student1/NPC_left2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
