package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Student_Desk_Middle extends Entity {
    public OBJ_Student_Desk_Middle(GamePanel gp){
        super(gp);
        name = "Student_Desk_Middle";
        down1=setup("/objects/desk-middle");
        collision = true;
    }
}