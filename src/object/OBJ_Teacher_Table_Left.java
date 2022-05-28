package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Teacher_Table_Left extends SuperObject{
    public OBJ_Teacher_Table_Left(){
        name = "Teacher_Table_Left";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/teacher-table-left.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
