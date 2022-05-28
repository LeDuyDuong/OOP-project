package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_Up extends SuperObject{
    public OBJ_Elevator_Up(){
        name = "Elevator_Up";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/elevator-up.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
