package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Student_Desk_Middle extends SuperObject{
    public OBJ_Student_Desk_Middle(){
        name = "Student_Desk_Middle";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/desk-middle.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
