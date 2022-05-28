package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_Down extends SuperObject{
    public OBJ_Elevator_Down(){
        name = "Elevator_Down";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/elevator-down.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
