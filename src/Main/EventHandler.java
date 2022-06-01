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
            //enter room
            if (hit(0,9, 7, "any") == true) {teleport(1,13,19); gp.playSE(1);}
            else if (hit(1,13,19,"any")==true) {teleport(0,9,7);gp.playSE(1);}

            /*else if (hit(0,25,7,"any")==true) {teleport(1,13,19); gp.playSE(1);}
            else if (hit(1,13,19,"any")==true) {teleport(0,25,7);gp.playSE(1);}

            else if (hit(0,11,24,"any")==true) {teleport(1,13,19); gp.playSE(1);}
            else if (hit(1,13,19,"any")==true) {teleport(0,11,24);gp.playSE(1);} */

            // thang máy góc trái dưới
            else if (hit(0,8,31,"right")==true) {teleport(2,8,31);}     // 1 - 2
            //else if (hit(0,8,32,"right")==true) {teleport(2,8,32);}
            else if (hit(2,8,31,"right")==true) {teleport(3,8,31);}     // 2 - 3
            else if (hit(2,8,32,"right")==true) {teleport(0,8,32);}     // 2 - 1
            else if (hit(3,8,32,"right")==true) {teleport(2,8,32);}     // 3 - 2

            // thang máy góc trái trên
            else if (hit(2,8,3,"right")==true) {teleport(3,8,3);}       // 2 - 3
            else if (hit(2,8,4,"right")==true) {teleport(0,8,4);}       // 2 - 1
            else if (hit(0,8,3,"right")==true) {teleport(2,8,3);}       // 1 - 2
            else if (hit(3,8,4,"right")==true) {teleport(2,8,4);}       // 3 - 2
            //else if (hit(0,8,4,"right")==true) {teleport(2,8,4);}
            // thang máy góc phải trên
            else if (hit(2,26,3,"left")==true) {teleport(3,26,3);} // 2 - 3
            else if (hit(2,26,4,"left")==true) {teleport(0,26,4);} // 2 - 1
            else if (hit(0,26,3,"left")==true) {teleport(2,26,3);} // 1 - 2
            else if (hit(3,26,4,"left")==true) {teleport(2,26,4);} // 3 - 2
            //else if (hit(0,26,4,"left")==true) {teleport(2,26,4);}
            // thang máy góc phải dưới
            else if (hit(2,26,31,"left")==true) {teleport(3,26,31);} // 2-3
            else if (hit(2,26,32,"left")==true) {teleport(0,26,32);} // 2-1
            else if (hit(0,26,31,"left")==true) {teleport(2,26,31);} // 1-2
            else if (hit(3,26,32,"left")==true) {teleport(2,26,32);} // 3-2
            //else if (hit(0,26,32,"left")==true) {teleport(2,26,32);}
            else if (hit(0,26,26,"any")==true){
                gp.ui.drawSubWindow(120,40, 500, 500);
            }


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
