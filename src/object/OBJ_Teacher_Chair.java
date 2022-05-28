package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Teacher_Chair extends SuperObject {
    public OBJ_Teacher_Chair(){
        name = "Teacher_Chair";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/teacher-chair.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
