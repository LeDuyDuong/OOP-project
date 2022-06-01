package object;

import Entity.Entity;
import Main.GamePanel;

import java.awt.*;


public class OBJ_Vending_Machine extends Entity {
    public OBJ_Vending_Machine(GamePanel gp){
        super(gp);
        name = "Vending_Machine";
        down1=setup("/objects/vending_machine_1");
        solidArea = new Rectangle();
        solidArea.x= 0;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=46;
        solidArea.height=16;
        collision=true;
    }

    public void announce(){

    }
}
