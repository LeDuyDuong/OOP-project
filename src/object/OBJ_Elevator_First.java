package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_First extends Entity {
    public OBJ_Elevator_First(GamePanel gp){
        super(gp);
        name = "Elevator_First";
        down1=setup("/objects/first-floor");
        collision=false;
    }
}
