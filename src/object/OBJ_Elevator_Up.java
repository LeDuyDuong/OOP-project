package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_Up extends Entity {
    public OBJ_Elevator_Up(GamePanel gp){
        super(gp);
        name = "Elevator_Up";
        down1=setup("/objects/elevator-up");
    }
}
