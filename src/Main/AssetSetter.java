package Main;

import Entity.NPC_Student;
import Entity.NPC_student1;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp= gp;
    }

    //set position of object
    public void setObject(){
        //key 1
        int mapNum = 0;
        gp.obj[mapNum][0] = new OBJ_Key();
        gp.obj[mapNum][0].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 26 * gp.tileSize;

        //key 2
        gp.obj[mapNum][1] = new OBJ_Key();
        gp.obj[mapNum][1].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 7 * gp.tileSize;

        //door 3
        gp.obj[mapNum][2] = new OBJ_Door();
        gp.obj[mapNum][2].worldX = 13 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 7 * gp.tileSize;

        //chest 4
        gp.obj[mapNum][3] = new OBJ_Chest();
        gp.obj[mapNum][3].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 17 * gp.tileSize;

    }
    public void setNPC(){
        int mapNum = 0;
        gp.npc[mapNum][0]=new NPC_Student(gp);
        gp.npc[mapNum][0].worldX= gp.tileSize*30;
        gp.npc[mapNum][0].worldY= gp.tileSize*15;

        //NPC_1
        gp.npc[mapNum][1]=new NPC_student1(gp);
        gp.npc[mapNum][1].worldX= gp.tileSize*2;
        gp.npc[mapNum][1].worldY= gp.tileSize*15;
    }
}
