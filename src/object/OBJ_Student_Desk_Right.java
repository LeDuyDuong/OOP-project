package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Student_Desk_Right extends SuperObject{
    public OBJ_Student_Desk_Right(){
        name = "Student_Desk_Right";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/desk-right.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
