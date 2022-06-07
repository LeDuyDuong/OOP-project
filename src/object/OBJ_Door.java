package object;

import Entity.Entity;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class OBJ_Door extends Entity {
    public OBJ_Door(GamePanel gp){
        super(gp);
        solidArea = new Rectangle();
        solidArea.x= 8;
        solidArea.y=16;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.width=32;
        solidArea.height=32;
        name = "Door";
        down1=setup("/tiles/door");
        collision = true;
    }
}
