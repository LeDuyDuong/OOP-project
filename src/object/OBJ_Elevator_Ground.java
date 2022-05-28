package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_Ground extends SuperObject{
    public OBJ_Elevator_Ground(){
        name = "Elevator_Ground";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/ground.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
