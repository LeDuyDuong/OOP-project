package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;


public class OBJ_Student_Desk_Left extends Entity {
    public OBJ_Student_Desk_Left(GamePanel gp){
        super(gp);
        name = "Student_Desk_Left";
        down1=setup("/objects/desk-left");
        collision = true;
    }


}

