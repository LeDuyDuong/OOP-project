package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Paper_B26 extends Entity {

    public OBJ_Paper_B26(GamePanel gp){
        super(gp);
        name = "Paper_B26";
        down1=setup("/objects/paper-B26");
        //collision = true;
        description= "You are the only ONE";
    }
}
