package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Student_Desk_Right extends Entity {
    public OBJ_Student_Desk_Right(GamePanel gp){
        super(gp);
        name = "Student_Desk_Right";
        down1=setup("/objects/desk-right");
        collision = true;
    }
}
