package Tiles;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TilesManager {
    GamePanel gp;
    public Tile[] map;
    public int[][][] mapTileNum;

    public Tile[] getMap() {
        return map;
    }

    public int[][][] getMapTileNum() {
        return mapTileNum;
    }

    public TilesManager(GamePanel gp){
        this.gp= gp;
        map = new Tile[200];
        mapTileNum= new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/1st_floor_map.txt",0);

        loadMap("/maps/room_A2-4_note.txt",1);

        loadMap("/maps/2nd_floor_map.txt",2);
        loadMap("/maps/3rd_floor_map.txt",3);
        loadMap("/maps/elevator_left_1.txt",4);
        loadMap("/maps/room_B3-7_note.txt",5);
        loadMap("/maps/room_A3-3-4_note.txt",6);
        loadMap("/maps/room_B2-6_note.txt",7);
        loadMap("/maps/room_B2-6_note_a.txt",8);
        loadMap("/maps/room_B2-6_note_b.txt",9);
        loadMap("/maps/lose.txt",10);
        loadMap("/maps/win.txt",11);
    }
    public void getTileImage(){
            setUpMap(0,"/tiles/others/path.png", false);
            setUpMap(1,"/tiles/others/wall_up.png", true);
            setUpMap(2,"/tiles/garden/soil_path.png", false);
            setUpMap(3,"/tiles/others/blank.png", true);
            setUpMap(4,"/tiles/others/blank2.png",true);
            setUpMap(5,"/tiles/others/wall_right.png",true);
            setUpMap(6,"/tiles/others/door.png",true);
            setUpMap(7,"/tiles/others/midtile0.png",false);
            setUpMap(8,"/tiles/others/midtile1.png",false);
            setUpMap(9,"/tiles/others/midtile2.png",false);
            setUpMap(10,"/tiles/others/midtile3.png",false);
            setUpMap(11,"/tiles/others/midtile5.png",false);
            setUpMap(12,"/tiles/others/midtile6.png",false);
            setUpMap(13,"/tiles/others/midtile7.png",false);
            setUpMap(14,"/tiles/others/midtile8.png",false);
            setUpMap(15,"/tiles/others/blank2-1.png",true);
            setUpMap(16,"/tiles/others/blank2-2.png",true);
            setUpMap(17,"/tiles/garden/grass.png",false );
            setUpMap(18,"/tiles/garden/chair_left.png",true);
            setUpMap(19,"/tiles/garden/chair_right.png",true );
            setUpMap(20,"/tiles/garden/chair_b_1.png",true);
            setUpMap(21,"/tiles/garden/chair_b_2.png",true);

            //ROOF
            setUpMap(22,"/tiles/roof and borders/roof.png",true);
            setUpMap(23,"/tiles/roof and borders/roof_with_border_UP.png",true);
            setUpMap(24,"/tiles/roof and borders/roof_with_border_DOWN.png",true);
            setUpMap(25,"/tiles/roof and borders/roof_with_border_RIGHT.png",true);
            setUpMap(26,"/tiles/roof and borders/roof_with_border_LEFT.png",true);

            //27 28 29 30 corner borders
            setUpMap(27,"/tiles/roof and borders/roof_corner_down_left.png",true);
            setUpMap(28,"/tiles/roof and borders/roof_corner_down_right.png",true);
            setUpMap(29,"/tiles/roof and borders/roof_corner_up_left.png",true);
            setUpMap(30,"/tiles/roof and borders/roof_corner_up_right.png",true);

            //garden STAIRs
            setUpMap(31,"/tiles/garden/stair_left_1.png",false);
            setUpMap(32,"/tiles/garden/stair_left_2.png",false);
            setUpMap(33,"/tiles/garden/stair_right_1.png",false);
            setUpMap(34,"/tiles/garden/stair_right_2.png",false);
            setUpMap(35, "/tiles/garden/something_UP.png",true);
            setUpMap(36,"/tiles/garden/something_DOWN.png",true);

            //ROOF DOT
            setUpMap(37,"/tiles/roof and borders/roof_dot_1.png",true);
            setUpMap(38,"/tiles/roof and borders/roof_dot_2.png",true);
            setUpMap(39,"/tiles/roof and borders/roof_dot_3.png",true);
            setUpMap(40,"/tiles/roof and borders/roof_dot_4.png",true);

            // gate and stairs
            setUpMap(41, "/tiles/gate/gate_stair_1.png",false);
            //
            //setUpMap(42, "/objects/vending_machine_1.png",true);
            setUpMap(43, "/tiles/others/vending_machine_2.png",true);

            setUpMap(44, "/tiles/gate/gate_stair_2.png",false);
            setUpMap(45, "/tiles/gate/gate_stair_3.png",false);
            setUpMap(46, "/tiles/gate/gate_stair_4.png",false);
            //ELEVATOR
            setUpMap(47, "/tiles/class-decoration/board-border-up-E.png",true);
            setUpMap(48, "/tiles/class-decoration/board-border-up-N.png",true);
            setUpMap(49, "/tiles/class-decoration/board-border-up-S.png",true);
            setUpMap(50, "/tiles/class-decoration/board-border-down-E.png",true);
            setUpMap(51, "/tiles/class-decoration/board-border-down-N.png",true);
            setUpMap(52, "/tiles/class-decoration/board-border-down-S.png",true);
            setUpMap(53, "/tiles/class-decoration/compass.png",true);

            setUpMap(54, "/tiles/elevator/elevator_roof_5.png",true);
            setUpMap(55, "/tiles/elevator/elevator_wall_1.png",true);

            setUpMap(56, "/tiles/elevator/elevator_up.png",false);
            setUpMap(57, "/tiles/elevator/elevator_down.png",false);

            setUpMap(58, "/tiles/gate/barrier.png",true);
            setUpMap(59, "/tiles/gate/barrier_1.png",true);
            setUpMap(60, "/tiles/gate/barrier_2.png",true);
            setUpMap(61, "/tiles/gate/barrier_3.png",true);

            // Room1 decoration
            setUpMap(62, "/tiles/class-decoration/desk-left.png",true);
            setUpMap(63, "/tiles/class-decoration/desk-middle.png",true);
            setUpMap(64, "/tiles/class-decoration/desk-right.png",true);
            setUpMap(65, "/tiles/class-decoration/student-chair.png",true);
            setUpMap(66, "/tiles/class-decoration/teacher-table-left.png",true);
            setUpMap(67, "/tiles/class-decoration/teacher-table-right.png",true);
            setUpMap(68, "/tiles/class-decoration/teacher-chair.png",true);

            //board
            setUpMap(69, "/tiles/class-decoration/board-border-left-up.png",true);
            setUpMap(70, "/tiles/class-decoration/board-border-left-down.png",true);
            setUpMap(71, "/tiles/class-decoration/board-border-right-up.png",true);
            setUpMap(72, "/tiles/class-decoration/board-border-right-down.png",true);
            setUpMap(73, "/tiles/class-decoration/board-border-up.png",true);
            setUpMap(74, "/tiles/class-decoration/board-border-down.png",true);

            //room labels
            setUpMap(75, "/tiles/room_labels/first_floor/A1-1.png",true);
            setUpMap(76, "/tiles/room_labels/first_floor/A1-2.png",true);
            setUpMap(77, "/tiles/room_labels/first_floor/A1-3.png",true);
            setUpMap(78, "/tiles/room_labels/first_floor/A1-4.png",true);
            setUpMap(79, "/tiles/room_labels/first_floor/B1-5.png",true);
            setUpMap(80, "/tiles/room_labels/first_floor/B1-6.png",true);

            setUpMap(81, "/tiles/room_labels/second_floor/A2-1.png",true);
            setUpMap(82, "/tiles/room_labels/second_floor/A2-2.png",true);
            setUpMap(83, "/tiles/room_labels/second_floor/A2-3.png",true);
            setUpMap(84, "/tiles/room_labels/second_floor/A2-4.png",true);
            setUpMap(85, "/tiles/room_labels/second_floor/B2-5.png",true);
            setUpMap(86, "/tiles/room_labels/second_floor/B2-6.png",true);
            setUpMap(87, "/tiles/room_labels/second_floor/B2-7.png",true);
            setUpMap(88, "/tiles/room_labels/second_floor/B2-8.png",true);

            setUpMap(89, "/tiles/room_labels/third_floor/A3-1.png",true);
            setUpMap(90, "/tiles/room_labels/third_floor/A3-2.png",true);
            setUpMap(91, "/tiles/room_labels/third_floor/A3-3.png",true);
            setUpMap(92, "/tiles/room_labels/third_floor/A3-4.png",true);
            setUpMap(93, "/tiles/room_labels/third_floor/B3-5.png",true);
            setUpMap(94, "/tiles/room_labels/third_floor/B3-6.png",true);
            setUpMap(95, "/tiles/room_labels/third_floor/B3-7.png",true);
            setUpMap(96, "/tiles/room_labels/third_floor/B3-8.png",true);

            setUpMap(97, "/tiles/others/room_floor.png",false);
        //setUpMap(98, "/tiles/others/room_floor_collision.png",true);
            setUpMap(98, "/tiles/others/room_floor.png",true);

        setUpMap(99, "/tiles/gates/OR-2input.png",false);
        setUpMap(100, "/tiles/gates/NOT.png",false);
        setUpMap(101, "/tiles/gates/straight_line.png",false);
        setUpMap(102, "/tiles/gates/left_straight_line.png",false);
        setUpMap(103, "/tiles/gates/right_straight_line.png",false);
        setUpMap(104, "/tiles/gates/1.png",false);
        setUpMap(105, "/tiles/gates/2.png",false);
        setUpMap(106, "/tiles/gates/3.png",false);
        setUpMap(107, "/tiles/gates/4.png",false);

        setUpMap(108, "/tiles/gates/A.png",false);
        setUpMap(109, "/tiles/gates/B.png",false);
        setUpMap(110, "/tiles/gates/C.png",false);


        setUpMap(111, "/tiles/gates/AND-3input.png",false);
        setUpMap(112, "/tiles/gates/horizontal_line.png",false);
        setUpMap(113, "/tiles/gates/NAND-2input.png",false);
        setUpMap(114, "/tiles/gates/NOR-2input.png",false);
        setUpMap(115, "/tiles/gates/big_L.png",false);
        setUpMap(116, "/tiles/gates/big_L.png",false);
        setUpMap(117, "/tiles/gates/L_I.png",false);
        setUpMap(118, "/tiles/gates/=.png",false);
        setUpMap(119, "/tiles/gates/LL.png",false);
        setUpMap(120, "/tiles/gates/exit.png",false);

        setUpMap(121, "/tiles/gates/OR-4input.png",false);
        setUpMap(122, "/tiles/gates/4-line.png",false);
        setUpMap(123, "/tiles/gates/right.png",false);
        setUpMap(124, "/tiles/gates/left.png",false);
        setUpMap(125, "/tiles/gates/hor.png",false);
        setUpMap(126, "/tiles/gates/hor2.png",false);
        setUpMap(127, "/tiles/gates/NAND-3in.png",false);

        setUpMap(128, "/tiles/gates/3A.png",false);
        setUpMap(129, "/tiles/gates/3B.png",false);
        setUpMap(130, "/tiles/gates/3C.png",false);
        setUpMap(131, "/tiles/gates/3D.png",false);
        setUpMap(132, "/tiles/gates/3E.png",false);

        setUpMap(133, "/tiles/gates/linee.png",false);

        setUpMap(134, "/tiles/gates/3.5.png",false);
        setUpMap(135, "/tiles/gates/3line.png",false);
        setUpMap(136, "/tiles/gates/2-l.png",false);
        setUpMap(137, "/tiles/gates/137.png",false);
        setUpMap(138, "/tiles/gates/138.png",false);
        setUpMap(139, "/tiles/gates/139.png",false);
        setUpMap(140, "/tiles/gates/140.png",false);
        setUpMap(141, "/tiles/gates/141.png",false);
        setUpMap(142, "/tiles/gates/142.png",false);
        setUpMap(143, "/tiles/gates/D.png",false);
        setUpMap(144, "/tiles/gates/144.png",false);
        setUpMap(145, "/tiles/gates/145.png",false);
        setUpMap(146, "/tiles/gates/E.png",false);
        setUpMap(147, "/tiles/gates/output1.png",false);
    }

    public void setUpMap(int index, String imagePath, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            map[index] = new Tile();
            map[index].image = ImageIO.read(getClass().getResourceAsStream(imagePath));
            map[index].image = uTool.scaleImage(map[index].image,gp.tileSize, gp.tileSize);
            map[index].collision = collision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String path, int map){
        try{
            InputStream is=  getClass().getResourceAsStream(path);
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row =0;
            while(col<gp.maxWorldCol && row<gp.maxWorldRow){
                String line = br.readLine();
                while(col< gp.maxWorldCol){
                    String number[]   = line.split(" ");
                    int num =Integer.parseInt(number[col]);
                    mapTileNum[map][col][row]= num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e){
        }
    }

    public void draw(Graphics2D g2){
         int worldCol=0;
         int worldRow=0;

         while(worldCol<gp.maxWorldCol &&  worldRow<gp.maxWorldRow){
             int tileNum= mapTileNum[gp.currentMap][worldCol][worldRow];
             int worldX= worldCol*gp.tileSize;
             int worldY= worldRow*gp.tileSize;
             int screenX= worldX- gp.player.worldX+gp.player.screenX;
             int screenY= worldY- gp.player.worldY+gp.player.screenY ;

             //Stop moving camera at the edge
             if(gp.player.screenX>gp.player.worldX){
                 screenX=worldX;
             }
             if(gp.player.screenY>gp.player.worldY){
                 screenY=worldY;
             }
             int     rightOffset=gp.screenWidth-gp.player.screenX;
             if(rightOffset>gp.worldWidth-gp.player.worldX){
                 screenX= gp.screenWidth-(gp.worldWidth-worldX);
             }
             int bottomOffset=gp.screenHeight-gp.player.screenY;
             if(bottomOffset> gp.worldHeight-gp.player.worldY){
                 screenY= gp.screenHeight-(gp.worldWidth-worldY);
             }

             if(        worldX+gp.tileSize>gp.player.worldX-gp.player.screenX
                     && worldX-gp.tileSize<gp.player.worldX+gp.player.screenX
                     && worldY+gp.tileSize>gp.player.worldY-gp.player.screenY
                     && worldY-gp.tileSize<gp.player.worldY+gp.player.screenY){
                 g2.drawImage(map[tileNum].image, screenX, screenY,null);
             }else if(gp.player.screenX>gp.player.worldX ||
                    gp.player.screenY>gp.player.worldY||
                    rightOffset>gp.worldWidth-gp.player.worldX||
                    bottomOffset>gp.worldHeight-gp.player.worldY){
                    g2.drawImage(map[tileNum].image, screenX, screenY,null);
             }

             worldCol++;
             if(worldCol== gp.maxWorldCol){
                 worldCol=0;
                 worldRow++;
             }

         }
    }
}
