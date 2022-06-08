package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Informer extends Entity {
    public OBJ_Informer(GamePanel gp){
        super(gp);
        name = "Informer";
        down1=setup("/objects/informing_obj");
        //collision = false;
    }
}
