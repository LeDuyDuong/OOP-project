package object;

import Entity.Entity;
import Main.GamePanel;

public class OBJ_Speed extends Entity {
    public OBJ_Speed(GamePanel gp) {
        super(gp);
        name = "Speed";
        setup("/objects/boots");
    }
}
