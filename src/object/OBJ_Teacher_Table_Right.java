package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Teacher_Table_Right extends SuperObject{
    public OBJ_Teacher_Table_Right(){
        name = "Teacher_Table_Right";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/teacher-table-right.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
