package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Paper extends Entity {
    public OBJ_Paper(GamePanel gp){
        super(gp);
        name = "Paper";
        down1=setup("/objects/paper");
        //collision = false;
    }
}
