package Main;

import Entity.*;
import object.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp= gp;
    }

    //set position of object
    public void setObject(){
        // Room B2.6
        /* Map 1 */

        //key 1
        int mapNum = 0;
        gp.obj[0][0] = new OBJ_Coin(gp);
        gp.obj[0][0].worldX = 16 * gp.tileSize;
        gp.obj[0][0].worldY = 17 * gp.tileSize;

        gp.obj[mapNum][2] = new OBJ_Informer(gp);
        gp.obj[mapNum][2].worldX = 3 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 29 * gp.tileSize;
        /*
        gp.obj[mapNum][0] = new OBJ_Key(gp);
        gp.obj[mapNum][0].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 26 * gp.tileSize;
        //key 2
//        gp.obj[mapNum][1] = new OBJ_Key(gp);
//        gp.obj[mapNum][1].worldX = 16 * gp.tileSize;
//        gp.obj[mapNum][1].worldY = 7 * gp.tileSize;
        //door 3
//        gp.obj[mapNum][2] = new OBJ_Door(gp);
//        gp.obj[mapNum][2].worldX = 13 * gp.tileSize;
//        gp.obj[mapNum][2].worldY = 7 * gp.tileSize;
        //chest 4
        
        //Vending machine
//        gp.obj[mapNum][4] = new OBJ_Vending_Machine(gp);
//        gp.obj[mapNum][4].worldX = 25 * gp.tileSize;
//        gp.obj[mapNum][4].worldY = 25 * gp.tileSize;

        //Paper
        gp.obj[mapNum][5] = new OBJ_Paper_Yellow(gp);
        gp.obj[mapNum][5].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 17 * gp.tileSize;

        //Elevator
        /*gp.obj[mapNum][4] = new OBJ_Elevator_Up(gp);
        gp.obj[mapNum][4].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][4].worldY = 31 * gp.tileSize;

        gp.obj[mapNum][5] = new OBJ_Elevator_First(gp);
        gp.obj[mapNum][5].worldX = 8 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 32 * gp.tileSize;*/
      
        gp.obj[mapNum][5] = new OBJ_Paper_Yellow(gp);
        gp.obj[mapNum][5].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 17 * gp.tileSize;

        /* Room 1 */
        //Desk 1
//        gp.obj[1][0] = new OBJ_Student_Desk_Left(gp);
//        gp.obj[1][0].worldX = 10 * gp.tileSize;
//        gp.obj[1][0].worldY = 10 * gp.tileSize;
//
//        gp.obj[1][1] = new OBJ_Student_Desk_Middle(gp);
//        gp.obj[1][1].worldX = 11 * gp.tileSize;
//        gp.obj[1][1].worldY = 10 * gp.tileSize;
//
//        gp.obj[1][2] = new OBJ_Student_Desk_Right(gp);
//        gp.obj[1][2].worldX = 12 * gp.tileSize;
//        gp.obj[1][2].worldY = 10 * gp.tileSize;
//
//        //Desk 2
//        gp.obj[1][3] = new OBJ_Student_Desk_Left(gp);
//        gp.obj[1][3].worldX = 14 * gp.tileSize;
//        gp.obj[1][3].worldY = 10 * gp.tileSize;
//
//        gp.obj[1][4] = new OBJ_Student_Desk_Middle(gp);
//        gp.obj[1][4].worldX = 15 * gp.tileSize;
//        gp.obj[1][4].worldY = 10 * gp.tileSize;
//
//        gp.obj[1][5] = new OBJ_Student_Desk_Right(gp);
//        gp.obj[1][5].worldX = 16 * gp.tileSize;
//        gp.obj[1][5].worldY = 10 * gp.tileSize;
//
//        //Desk 3
//        gp.obj[1][6] = new OBJ_Student_Desk_Left(gp);
//        gp.obj[1][6].worldX = 10 * gp.tileSize;
//        gp.obj[1][6].worldY = 12 * gp.tileSize;
//
//        gp.obj[1][7] = new OBJ_Student_Desk_Middle(gp);
//        gp.obj[1][7].worldX = 11 * gp.tileSize;
//        gp.obj[1][7].worldY = 12 * gp.tileSize;
//
//        gp.obj[1][8] = new OBJ_Student_Desk_Right(gp);
//        gp.obj[1][8].worldX = 12 * gp.tileSize;
//        gp.obj[1][8].worldY = 12 * gp.tileSize;
//
//        //Desk 4
//        gp.obj[1][9] = new OBJ_Student_Desk_Left(gp);
//        gp.obj[1][9].worldX = 14 * gp.tileSize;
//        gp.obj[1][9].worldY = 12 * gp.tileSize;
//
//        gp.obj[1][10] = new OBJ_Student_Desk_Middle(gp);
//        gp.obj[1][10].worldX = 15 * gp.tileSize;
//        gp.obj[1][10].worldY = 12 * gp.tileSize;
//
//        gp.obj[1][11] = new OBJ_Student_Desk_Right(gp);
//        gp.obj[1][11].worldX = 16 * gp.tileSize;
//        gp.obj[1][11].worldY = 12 * gp.tileSize;
//
//        //Desk 5
//        gp.obj[1][12] = new OBJ_Student_Desk_Left(gp);
//        gp.obj[1][12].worldX = 10 * gp.tileSize;
//        gp.obj[1][12].worldY = 14 * gp.tileSize;
//
//        gp.obj[1][13] = new OBJ_Student_Desk_Middle(gp);
//        gp.obj[1][13].worldX = 11 * gp.tileSize;
//        gp.obj[1][13].worldY = 14 * gp.tileSize;
//
//        gp.obj[1][14] = new OBJ_Student_Desk_Right(gp);
//        gp.obj[1][14].worldX = 12 * gp.tileSize;
//        gp.obj[1][14].worldY = 14 * gp.tileSize;
//
//        //Desk 6
//        gp.obj[1][15] = new OBJ_Student_Desk_Left(gp);
//        gp.obj[1][15].worldX = 14 * gp.tileSize;
//        gp.obj[1][15].worldY = 14 * gp.tileSize;
//
//        gp.obj[1][16] = new OBJ_Student_Desk_Middle(gp);
//        gp.obj[1][16].worldX = 15 * gp.tileSize;
//        gp.obj[1][16].worldY = 14 * gp.tileSize;
//
//        gp.obj[1][17] = new OBJ_Student_Desk_Right(gp);
//        gp.obj[1][17].worldX = 16 * gp.tileSize;
//        gp.obj[1][17].worldY = 14 * gp.tileSize;
//
//        //Chair for desk 1
//        gp.obj[1][18] = new OBJ_Student_Chair(gp);
//        gp.obj[1][18].worldX = 10 * gp.tileSize;
//        gp.obj[1][18].worldY = 11 * gp.tileSize;
//
//        gp.obj[1][19] = new OBJ_Student_Chair(gp);
//        gp.obj[1][19].worldX = 11 * gp.tileSize;
//        gp.obj[1][19].worldY = 11 * gp.tileSize;
//
//        gp.obj[1][20] = new OBJ_Student_Chair(gp);
//        gp.obj[1][20].worldX = 12 * gp.tileSize;
//        gp.obj[1][20].worldY = 11 * gp.tileSize;
//
//        //Chair for desk 2
//        gp.obj[1][21] = new OBJ_Student_Chair(gp);
//        gp.obj[1][21].worldX = 14 * gp.tileSize;
//        gp.obj[1][21].worldY = 11 * gp.tileSize;
//
//        gp.obj[1][22] = new OBJ_Student_Chair(gp);
//        gp.obj[1][22].worldX = 15 * gp.tileSize;
//        gp.obj[1][22].worldY = 11 * gp.tileSize;
//
//        gp.obj[1][23] = new OBJ_Student_Chair(gp);
//        gp.obj[1][23].worldX = 16 * gp.tileSize;
//        gp.obj[1][23].worldY = 11 * gp.tileSize;
//
//        //Chair for desk 3
//        gp.obj[1][24] = new OBJ_Student_Chair(gp);
//        gp.obj[1][24].worldX = 10 * gp.tileSize;
//        gp.obj[1][24].worldY = 13 * gp.tileSize;
//
//        gp.obj[1][25] = new OBJ_Student_Chair(gp);
//        gp.obj[1][25].worldX = 11 * gp.tileSize;
//        gp.obj[1][25].worldY = 13 * gp.tileSize;
//
//        gp.obj[1][26] = new OBJ_Student_Chair(gp);
//        gp.obj[1][26].worldX = 12 * gp.tileSize;
//        gp.obj[1][26].worldY = 13 * gp.tileSize;
//
//        //Chair for desk 4
//        gp.obj[1][27] = new OBJ_Student_Chair(gp);
//        gp.obj[1][27].worldX = 14 * gp.tileSize;
//        gp.obj[1][27].worldY = 13 * gp.tileSize;
//
//        gp.obj[1][28] = new OBJ_Student_Chair(gp);
//        gp.obj[1][28].worldX = 15 * gp.tileSize;
//        gp.obj[1][28].worldY = 13 * gp.tileSize;
//
//        gp.obj[1][29] = new OBJ_Student_Chair(gp);
//        gp.obj[1][29].worldX = 16 * gp.tileSize;
//        gp.obj[1][29].worldY = 13 * gp.tileSize;
//
//        //Chair for desk 5
//        gp.obj[1][30] = new OBJ_Student_Chair(gp);
//        gp.obj[1][30].worldX = 10 * gp.tileSize;
//        gp.obj[1][30].worldY = 15 * gp.tileSize;
//
//        gp.obj[1][31] = new OBJ_Student_Chair(gp);
//        gp.obj[1][31].worldX = 11 * gp.tileSize;
//        gp.obj[1][31].worldY = 15 * gp.tileSize;
//
//        gp.obj[1][32] = new OBJ_Student_Chair(gp);
//        gp.obj[1][32].worldX = 12 * gp.tileSize;
//        gp.obj[1][32].worldY = 15 * gp.tileSize;
//
//        //Chair for desk 6
//        gp.obj[1][33] = new OBJ_Student_Chair(gp);
//        gp.obj[1][33].worldX = 14 * gp.tileSize;
//        gp.obj[1][33].worldY = 15 * gp.tileSize;
//
//        gp.obj[1][34] = new OBJ_Student_Chair(gp);
//        gp.obj[1][34].worldX = 15 * gp.tileSize;
//        gp.obj[1][34].worldY = 15 * gp.tileSize;
//
//        gp.obj[1][35] = new OBJ_Student_Chair(gp);
//        gp.obj[1][35].worldX = 16 * gp.tileSize;
//        gp.obj[1][35].worldY = 15 * gp.tileSize;
//
//        //Teacher table
//        gp.obj[1][36] = new OBJ_Teacher_Table_Left(gp);
//        gp.obj[1][36].worldX = 16 * gp.tileSize;
//        gp.obj[1][36].worldY = 7 * gp.tileSize;
//
//        gp.obj[1][37] = new OBJ_Teacher_Table_Right(gp);
//        gp.obj[1][37].worldX = 17 * gp.tileSize;
//        gp.obj[1][37].worldY = 7 * gp.tileSize;
//
//        gp.obj[1][38] = new OBJ_Teacher_Chair(gp);
//        gp.obj[1][38].worldX = 17 * gp.tileSize;
//        gp.obj[1][38].worldY = 8 * gp.tileSize;

        //paper
        gp.obj[1][0] = new OBJ_Paper(gp);
        gp.obj[1][0].setDescription("roses are heads\n" +
                "violet are shoes\n" +
                "his skin is black\n" +
                "and his shirt is blue");
        gp.obj[1][0].worldX = 13 * gp.tileSize;
        gp.obj[1][0].worldY = 8 * gp.tileSize;

        /* Map 2 */

        //Elevator
        /*gp.obj[2][0] = new OBJ_Elevator_Down(gp);
        gp.obj[2][0].worldX = 8 * gp.tileSize;
        gp.obj[2][0].worldY = 31 * gp.tileSize;

        gp.obj[2][1] = new OBJ_Elevator_Ground(gp);
        gp.obj[2][1].worldX = 8 * gp.tileSize;
        gp.obj[2][1].worldY = 32 * gp.tileSize;*/


        /* Room 307*/
        gp.obj[5][0]= new OBJ_Owl(gp);
        gp.obj[5][0].worldX = 13 * gp.tileSize;
        gp.obj[5][0].worldY = 5 * gp.tileSize;

        gp.obj[5][1] = new OBJ_Elevator_Down(gp);
        gp.obj[5][1].worldX = 6 * gp.tileSize;
        gp.obj[5][1].worldY = 5 * gp.tileSize;

        /* Room 206*/
        gp.obj[7][0]= new OBJ_Paper_B26(gp);
        gp.obj[7][0].worldX = 12 * gp.tileSize;
        gp.obj[7][0].worldY = 16 * gp.tileSize;

        /* Room A303.5*/
        gp.obj[11][0]= new OBJ_Lolipop(gp);
        gp.obj[11][0].worldX= gp.tileSize*13;
        gp.obj[11][0].worldY = gp.tileSize * 18;

        gp.obj[6][0]= new OBJ_Backpack(gp);
        gp.obj[6][0].worldX= gp.tileSize*13;
        gp.obj[6][0].worldY = gp.tileSize * 8;
    }
    public void setNPC() {
        int mapNum = 0;
        gp.npc[mapNum][0] = new NPC_Student(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize * 30;
        gp.npc[mapNum][0].worldY = gp.tileSize * 15;

        //NPC_1
        gp.npc[mapNum][1] = new NPC_student1(gp);
        gp.npc[mapNum][1].worldX = gp.tileSize * 7;
        gp.npc[mapNum][1].worldY = gp.tileSize * 7;

        //NPC_2
        gp.npc[mapNum][2] = new NPC_student2(gp);
        gp.npc[mapNum][2].worldX = gp.tileSize * 14;
        gp.npc[mapNum][2].worldY = gp.tileSize * 16;
        //NPC_Amber
        gp.npc[mapNum][3] = new NPC_Amber(gp);
        gp.npc[mapNum][3].worldX = gp.tileSize * 2;
        gp.npc[mapNum][3].worldY = gp.tileSize * 25;

        //semi-NPC vending machine
        gp.npc[mapNum][4] = new OBJ_Vending_Machine(gp);
        gp.npc[mapNum][4].worldX = gp.tileSize * 25;
        gp.npc[mapNum][4].worldY = gp.tileSize * 25;
        // NPC-3
        mapNum=2;

//        gp.npc[mapNum][5] = new NPC_student3(gp);
//        gp.npc[mapNum][5].worldX = gp.tileSize * 2;
//        gp.npc[mapNum][5].worldY = gp.tileSize * 20;
        gp.npc[mapNum][0] = new NPC_Secu(gp);
        gp.npc[mapNum][0].worldX = gp.tileSize * 23;
        gp.npc[mapNum][0].worldY = gp.tileSize * 25;

        gp.npc[3][0] = new NPC_Trader(gp);
        gp.npc[3][0].worldX = gp.tileSize * 10;
        gp.npc[3][0].worldY = gp.tileSize * 25;


    }
}
