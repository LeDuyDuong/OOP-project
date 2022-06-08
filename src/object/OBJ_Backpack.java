package object;

import Entity.Entity;
import Main.GamePanel;
public class OBJ_Backpack extends Entity{
    public  OBJ_Backpack(GamePanel gp) {
        super(gp);
        name = "Backpack";
        down1 = setup("/objects/backpack");
        description = "This is Amber's backpack.\nCareful with those things\ninside!";
    }
}
