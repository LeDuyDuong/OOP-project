package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Paper_Yellow extends Entity {
    public OBJ_Paper_Yellow(GamePanel gp){
        super(gp);
        name = "Paper_Yellow";
        down1=setup("/objects/paper-yellow");
        //collision = true;
        description= "1010 0010 0100";
    }
}
