package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Student_Desk_Left extends SuperObject{
    public OBJ_Student_Desk_Left(){
        name = "Student_Desk_Left";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/desk-left.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
