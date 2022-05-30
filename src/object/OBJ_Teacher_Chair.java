package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Teacher_Chair extends Entity {
    public OBJ_Teacher_Chair(GamePanel gp){
        super(gp);
        name = "Teacher_Chair";
        down1=setup("/objects/teacher-chair");
        collision = true;
    }
}
