package Main;

import java.awt.*;

public class EventHandler {

    GamePanel gp;
    EventRectangle eventRect[][][];
    //int eventRectDefaultX, eventRectDefaultY;
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    int tempMap, tempCol, tempRow;

    public EventHandler(GamePanel gp) {
        this.gp=gp;

        eventRect = new EventRectangle[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        int map = 0;
        int col = 0;
        int row = 0;
        while (map<gp.maxMap && col< gp.maxWorldCol && row<gp.maxWorldRow) {
            eventRect[map][col][row] = new EventRectangle();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxWorldCol) {
                col = 0;
                row++;
                if(row == gp.maxWorldRow) {
                    row = 0;
                    map++;
                }
            }
        }
    }

    public void checkEvent() {
        //check if the player is one tile away from the event rectangle
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if (distance > gp.tileSize) {
            canTouchEvent = true;
        }

        if (canTouchEvent == true) {
            //enter room 2.4
            if (hit(2,23, (25), "up") == true) {teleport(1,13,19); gp.playSE(1);}
            else if (hit(1,13,19,"any")==true) {teleport(2,23,25);gp.playSE(1);}

            //enter room B3.7
            if (hit(3,15, 8, "up") == true) {
                if(gp.player.hasKey==1){
                    teleport(5,13,22); gp.playSE(1);
                } else if (gp.player.hasKey==0) {
                    gp.ui.setMessage("Door is locked, Find a key to open it");

                    gp.gameState= gp.messageState;
                }
            }
            else if (hit(5,13,22,"any")==true) {teleport(3,15,8);gp.playSE(1);}
            else if (hit(5,6,5,"any")==true) {teleport(3,15,8);gp.playSE(1);}

            //enter room A3.3-4
            if (hit(3,21, (25), "up") == true) {
                if (gp.player.hasOwl==1) {
                    teleport(6,13,19); gp.playSE(1);
                } else if (gp.player.hasOwl==0) {
                    gp.ui.setMessage("Door is locked, Find a SPECIAL KEY to open it" + "\nWatch Harry Potter and The Philosopher's Stone!");
                    gp.gameState= gp.messageState;
                }
            }

            else if (hit(6,13,19,"any")==true) {teleport(3,21,25);gp.playSE(1);}

            //enter room B2.6
            if (hit(2,19, 8, "up") == true) {teleport(7,13,19); gp.playSE(1);}
            else if (hit(7,13,19,"any")==true) {teleport(2,19,8);gp.playSE(1);}

//            if (hit(0,11, 24, "up") == true) {teleport(5,13,22); gp.playSE(1);}
//            else if (hit(5,13,22,"any")==true) {teleport(0,11,24);gp.playSE(1);}
            /*else if (hit(0,25,7,"any")==true) {teleport(1,13,19); gp.playSE(1);}
            else if (hit(1,13,19,"any")==true) {teleport(0,25,7);gp.playSE(1);}

            else if (hit(0,11,24,"any")==true) {teleport(1,13,19); gp.playSE(1);}
            else if (hit(1,13,19,"any")==true) {teleport(0,11,24);gp.playSE(1);} */

            // thang máy góc trái dưới
            else if (hit(0,8,31,"right")==true) {teleport(2,8,31); gp.playSE(2);}     // 1 - 2
            //else if (hit(0,8,32,"right")==true) {teleport(2,8,32);}
            else if (hit(2,8,31,"right")==true) {teleport(3,8,31);gp.playSE(2);}     // 2 - 3
            else if (hit(2,8,32,"right")==true) {teleport(0,8,32);gp.playSE(2);}     // 2 - 1
            else if (hit(3,8,32,"right")==true) {teleport(2,8,32);gp.playSE(2);}     // 3 - 2

            // thang máy góc trái trên
            else if (hit(2,8,3,"right")==true) {teleport(3,8,3);gp.playSE(2);}       // 2 - 3
            else if (hit(2,8,4,"right")==true) {teleport(0,8,4);gp.playSE(2);}       // 2 - 1
            else if (hit(0,8,3,"right")==true) {teleport(2,8,3);gp.playSE(2);}       // 1 - 2
            else if (hit(3,8,4,"right")==true) {teleport(2,8,4);gp.playSE(2);}       // 3 - 2
            //else if (hit(0,8,4,"right")==true) {teleport(2,8,4);}
            // thang máy góc phải trên
            else if (hit(2,26,3,"left")==true) {teleport(3,26,3);gp.playSE(2);} // 2 - 3
            else if (hit(2,26,4,"left")==true) {teleport(0,26,4);gp.playSE(2);} // 2 - 1
            else if (hit(0,26,3,"left")==true) {teleport(2,26,3);gp.playSE(2);} // 1 - 2
            else if (hit(3,26,4,"left")==true) {teleport(2,26,4);gp.playSE(2);} // 3 - 2
            //else if (hit(0,26,4,"left")==true) {teleport(2,26,4);}
            // thang máy góc phải dưới
            else if (hit(2,26,31,"left")==true) {teleport(3,26,31);gp.playSE(2);} // 2-3
            else if (hit(2,26,32,"left")==true) {teleport(0,26,32);gp.playSE(2);} // 2-1
            else if (hit(0,26,31,"left")==true) {teleport(2,26,31);gp.playSE(2);} // 1-2
            else if (hit(3,26,32,"left")==true) {teleport(2,26,32);gp.playSE(2);} // 3-2
            //else if (hit(0,26,32,"left")==true) {teleport(2,26,32);}

            //phòng đầu 2 gates:
            else if (hit(7,14,14,"any")==true) {teleport(8,13,19);} // chọn B đúng
            else if (hit(7,12,14,"any")==true) {teleport(10,13,19);} // chọn A sai

            //phòng hai 3 gates
            else if (hit(8,13,19,"any")==true) {teleport(7,13,19);} // quay lại phòng 2 gates
            else if (hit(8,14,14,"any")==true) {teleport(9,13,19);} // chọn C đúng
            else if (hit(8,12,14,"any")==true) {teleport(10,13,19);} // chọn B sai
            else if (hit(8,10,14,"any")==true) {teleport(10,13,19);} // chọn A sai

            //phòng ba 5 gates:
            else if (hit(9,13,19,"any")==true) {teleport(8,13,19);} // quay lại phòng 3 gates
            else if (hit(9,12,15,"any")==true) {teleport(11,13,19);} // chọn C đúng
            else if (hit(9,13,15,"any")==true) {teleport(10,13,19);} // chọn D sai
            else if (hit(9,10,15,"any")==true) {teleport(10,13,19);} // chọn B sai
            else if (hit(9,9,15,"any")==true) {teleport(10,13,19);} // chọn A sai
            else if (hit(9,17,15,"any")==true) {teleport(10,13,19);} // chọn E sai
            //lose b2.6
            else if (hit(10,13,17,"any")==true) {teleport(7,13,19);}
            //Win b2.6
            else if (hit(11,13,17,"any")==true) {teleport(2,19,8);}




        }
    }

    public void teleport(int map, int col, int row) {
        gp.gameState= gp.transitionState;
        tempMap = map;
        tempCol=col;
        tempRow=row;
        canTouchEvent = false;
    }

    public boolean hit (int map, int col, int row, String reqDirection) {
        boolean hit = false;
        if (map == gp.currentMap) {

            gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
            gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
            eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;

            if (gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false) {
                if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                    hit = true;
                    previousEventX = gp.player.worldX;
                    previousEventY = gp.player.worldY;
                }
            }
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }
        return hit;
    }
}
