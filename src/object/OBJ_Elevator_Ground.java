package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_Ground extends Entity {
    public OBJ_Elevator_Ground(GamePanel gp){
        super(gp);
        name = "Elevator_Ground";
        down1=setup("/objects/ground");
        collision=false;
    }
}
