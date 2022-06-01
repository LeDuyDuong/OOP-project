package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Coffee_cup extends Entity {
    public OBJ_Coffee_cup(GamePanel gp){
        super(gp);
        name = "Cup of Coffee";
        down1=setup("/objects/coffee_cup");
        description= "["+name+"]\n" + "Dụ Bảo Vệ.";
        //collision=false;
    }
}
