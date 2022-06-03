package tile_interactive;

import Entity.Entity;
import Main.GamePanel;

public class InteractiveTile extends Entity {
    GamePanel gp;
    public boolean destructible =false;

    public InteractiveTile(GamePanel gp) {
        super(gp);
    }
    public void update() {

    }
}
