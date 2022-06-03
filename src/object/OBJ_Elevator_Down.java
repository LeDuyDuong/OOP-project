package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_Down extends Entity {
    public OBJ_Elevator_Down(GamePanel gp){
        super(gp);
        name = "Elevator_Down";
        down1=setup("/objects/elevator-down");
        collision=false;
    }
}
