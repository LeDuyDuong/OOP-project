package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Owl extends Entity {
    public OBJ_Owl(GamePanel gp){
        super(gp);
        name = "Owl";
        down1=setup("/objects/owl");
        //collision = false;
        description= "Use me as a key to a wall. A.3. 3.5";
    }
}
