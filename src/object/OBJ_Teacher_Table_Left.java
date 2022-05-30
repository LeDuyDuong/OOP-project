package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Teacher_Table_Left extends Entity {
    public OBJ_Teacher_Table_Left(GamePanel gp){
        super(gp);
        name = "Teacher_Table_Left";
        down1=setup("/objects/teacher-table-left");
        collision = true;
    }
}
