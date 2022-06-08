package object;

import Entity.Entity;
import Main.GamePanel;

import java.awt.*;

public class OBJ_Coin extends Entity {
    public OBJ_Coin(GamePanel gp){
        super(gp);
        name = "Coin";
        down1=setup("/objects/coin");
        //collision=false;
        description= "["+name+"]\n" + "USED TO BUY STUFF";
    }
}
