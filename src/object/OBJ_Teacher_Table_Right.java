package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Teacher_Table_Right extends Entity {
    public OBJ_Teacher_Table_Right(GamePanel gp){
        super(gp);
        name = "Teacher_Table_Right";
        down1=setup("/objects/teacher-table-right");
        collision = true;
    }
}
