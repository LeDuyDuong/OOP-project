package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Student_Chair extends Entity {
    public OBJ_Student_Chair(GamePanel gp){
        super(gp);
        name = "Student_Desk_Chair";
        down1=setup("/objects/student-chair");
        collision = true;
    }
}
