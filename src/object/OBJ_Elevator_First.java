package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Elevator_First extends SuperObject{
    public OBJ_Elevator_First(){
        name = "Elevator_First";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/first-floor.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
