package object;

import Entity.Entity;
import Main.GamePanel;

import java.awt.*;

public class OBJ_Lolipop extends Entity {
    public OBJ_Lolipop(GamePanel gp){
        super(gp);
        name = "Lolipop";
        down1=setup("/objects/lolipop");
        description= "["+name+"]\n" + "Sweet treat for the trader";
        //collision=false;
    }
}
