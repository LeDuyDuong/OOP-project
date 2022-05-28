package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Student_Chair extends SuperObject{
    public OBJ_Student_Chair(){
        name = "Student_Desk_Chair";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/student-chair.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
