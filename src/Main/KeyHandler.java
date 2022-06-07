package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import Entity.Entity;
import object.*;

import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;




public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed,enterPressed;
    boolean showDebugText= false;
    GamePanel gp;
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //tittle State
        if(gp.gameState== gp.tittleState){
            if(code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=2;
                }
            }
            if(code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState= gp.playState;
                    gp.playMusic(0);
                }
                if(gp.ui.commandNum==1){

                }
                if(gp.ui.commandNum==2){
                    System.exit(0);
                }
            }
        }
        //play state
        else if(gp.gameState==gp.playState){
            if(code == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if(code == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            if(code == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if(code == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
            }
            if(code==KeyEvent.VK_E){
                gp.gameState= gp.characterState;
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed=true;
            }

            //DEBUG T với K
            if(code == KeyEvent.VK_T){
                if(showDebugText== true){
                    showDebugText= false;
                } else if (showDebugText==false) {
                    showDebugText=true;
                }
            }
        }
            //Pause State
        else if(gp.gameState==gp.pauseState){
                if(code == KeyEvent.VK_UP) {
                    gp.ui.commandNum--;
                    if(gp.ui.commandNum<0){
                        gp.ui.commandNum=1;
                    }
                }
                if(code == KeyEvent.VK_DOWN) {
                    gp.ui.commandNum++;
                    if(gp.ui.commandNum>1){
                        gp.ui.commandNum=0;
                    }
                }
                if(code==KeyEvent.VK_ENTER){
                    if(gp.ui.commandNum==0){
                        gp.gameState= gp.playState;
                        //gp.playMusic(0);
                    }
                    if(gp.ui.commandNum==1){
                        gp.gameState=gp.tittleState;
                        gp.sound.stop();
                        gp.ui.commandNum=0;
                    }
                }
        }
            //Dialogue State
        else if(gp.gameState==gp.dialogueState){
            if(code==KeyEvent.VK_ENTER){
                gp.gameState=gp.playState;
            }
        }
            //Character State
        else if(gp.gameState==gp.characterState){
            if(code== KeyEvent.VK_E){
                gp.gameState= gp.playState;
            }
            if(code==KeyEvent.VK_UP){
                if(gp.ui.slotRow!=0){
                    gp.ui.slotRow--;
                }

            }
            if(code==KeyEvent.VK_DOWN){
                if(gp.ui.slotRow!=3){
                    gp.ui.slotRow++;
                }
            }
            if(code==KeyEvent.VK_LEFT){
                if(gp.ui.slotCol!=0){
                    gp.ui.slotCol--;
                }
            }
            if(code==KeyEvent.VK_RIGHT){
                if(gp.ui.slotCol!=4){
                    gp.ui.slotCol++;
                }
            }
            //buying State
        } else if (gp.gameState==gp.buyingState) {
            if(code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }
            if(code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState=gp.messageState;
                    if(gp.player.hasCoin>0){
                        gp.ui.setMessage("BOUGHT 1 CUP OF COFFEE, CHECK YOUR INVENTORY");
                        gp.player.inventory.add(new OBJ_Coffee_cup(gp));
                        gp.player.hasCoin--;
                        gp.player.hasCoffe++;
                        for(Entity ent : gp.player.inventory){
                            if(ent instanceof OBJ_Coin){
                                gp.player.inventory.remove(ent);
                                break;
                            }
                        }

                    }else if(gp.player.hasCoin==0){
                        gp.ui.setMessage("NOT ENOUGH COIN");
                    }
                }
                if(gp.ui.commandNum==1){
                    gp.gameState=gp.playState;
                    //gp.sound.stop();
                    gp.ui.commandNum=0;
                }
            }
        }
        //SECU TAlking
        else if (gp.gameState==gp.talkingToSecuState) {
            if(code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }
            if(code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState=gp.messageState;
                    if(gp.player.hasCoffe>0){
                        gp.player.hasCoffe--;
                        gp.ui.setMessage("Ok, you are now free to enter");
                        try {
                            gp.npc[2][0].up1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].up2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].down1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].down2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].left1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].left2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].right1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                            gp.npc[2][0].right2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
                        } catch(IOException exception) {
                            exception.printStackTrace();
                        }
                        gp.npc[2][0].actionCounter++;
                        //gp.gameState= gp.transitionState;
                        gp.npc[2][0].direction="down";
                        gp.npc[2][0].worldX = gp.tileSize * 22;
                        gp.npc[2][0].worldY = gp.tileSize * 25;
                        for(Entity ent : gp.player.inventory){
                            if(ent instanceof OBJ_Coffee_cup){
                                gp.player.inventory.remove(ent);
                                break;
                            }
                        }

                    }else if(gp.player.hasCoffe==0){
                        gp.ui.setMessage("Hmmmmm\n" +
                                "Do my request first!");
                    }
                }
                if(gp.ui.commandNum==1){
                    gp.ui.setMessage("I'm still waiting");
                    gp.gameState= gp.messageState;
                    gp.ui.commandNum=0;
                }
            }
        }
    //talking to trader
        else if (gp.gameState==gp.tradingState) {
            if(code == KeyEvent.VK_UP) {
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=1;
                }
            }
            if(code == KeyEvent.VK_DOWN) {
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState=gp.messageState;
                    if(gp.player.hasLoli>0){
                        gp.player.hasLoli--;
                        gp.gameState=gp.dialogueState;
                        //gp.ui.setMessage("Good job! Here're the stuffs i promised");
                        gp.ui.setMessage("YOU GET :\n1 KEY\n1 NOTE \nCHECK YOUR INVENTORY");

//                        try {
//                            gp.npc[2][0].up1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].up2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].down1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].down2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].left1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].left2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].right1 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                            gp.npc[2][0].right2 = ImageIO.read(getClass().getResourceAsStream("/Student/security_with_coffee.png"));
//                        } catch(IOException exception) {
//                            exception.printStackTrace();
//                        }
                        gp.npc[0][3].actionCounter++;
//                        //gp.gameState= gp.transitionState;
//                        gp.npc[2][0].direction="down";
//                        gp.npc[2][0].worldX = gp.tileSize * 22;
//                        gp.npc[2][0].worldY = gp.tileSize * 25;
                        gp.player.inventory.add(new OBJ_Key(gp));
                        gp.player.inventory.add(new OBJ_Paper(gp));
                        for(Entity ent : gp.player.inventory){
                            if(ent instanceof OBJ_Paper && ent.description==""){
                                ent.description="-...  ...--  --...";
                                break;
                            }
                        }
                        for(Entity ent : gp.player.inventory){
                            if(ent instanceof OBJ_Lolipop){
                                gp.player.hasLoli++;
                                gp.player.inventory.remove(ent);
                                break;
                            }
                        }
                    //gp.ui.currentDialogue="YOU GET :\n1 KEY\n1 NOTE \nCHECK YOUR INVENTORY" ;
                    //gp.gameState=gp.dialogueState;
                    }else if(gp.player.hasCoffe==0){
                        gp.ui.setMessage("Stop joking man. or else I'll make you my LOLI\n (͡° ͜ʖ ͡°)");
                    }
                }
                if(gp.ui.commandNum==1){
                    gp.ui.setMessage("Hurry up bro");
                    gp.gameState= gp.messageState;
                    gp.ui.commandNum=0;
                }
            }
        }
        //Message State
        else if (gp.gameState==gp.messageState) {
            if(code==KeyEvent.VK_ENTER){
                gp.gameState= gp.playState;
            }
        }


        if (code == KeyEvent.VK_R) {
            switch (gp.currentMap) {
                case 0: gp.tilesM.loadMap("/maps/1st_floor_map.txt",0); break;
                case 1: gp.tilesM.loadMap("/maps/room_A2-4_note.txt",1); break;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
    }
}
