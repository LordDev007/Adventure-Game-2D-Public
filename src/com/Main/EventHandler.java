package com.Main;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect [][][];

    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    int tempMap, tempCol, tempRow;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        int map = 0;
        int col = 0;
        int row = 0;
        while (map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow){

            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;

                if(row == gp.maxWorldRow){
                    row = 0;
                    map++;
                }
            }
        }
    }
    public void checkEvent(){
        //CHECK IF THE CHARACTER IS MORE THAN 1 TILE AWAY FROM THE LAST EVENT
        int xDistance = (int) Math.abs(gp.player.worldX - previousEventX);
        int yDistance = (int) Math.abs(gp.player.worldY - previousEventY);
        int Distance = Math.max(xDistance, yDistance);

        if (Distance > gp.tileSize){
            canTouchEvent = true;
        }

        if (canTouchEvent == true){
            if(hit(0, 27, 16, "right") == true){damagePit(gp.dialogueState);}
            else if(hit(0, 23, 12, "up") == true){healingPool(gp.dialogueState);}
            else if(hit(0,10, 39, "any") == true){teleport(1, 12, 13);}
            else if(hit(1,12, 13, "any") == true){teleport(0, 10, 39);}
            }
        }
    public boolean hit(int map, int col, int row, String reqDirection){
        boolean hit = false;

        if(map == gp.currentMap){
            gp.player.solidArea.x = (int) (gp.player.worldX + gp.player.solidArea.x);
            gp.player.solidArea.y = (int) (gp.player.worldY + gp.player.solidArea.y);
            eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
            eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;

            if(gp.player.solidArea.intersects(eventRect[map][col][row]) && eventRect[map][col][row].eventDone == false){
                if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                    hit = true;

                    previousEventX = (int) gp.player.worldX;
                    previousEventY = (int) gp.player.worldY;
                }
            }
            gp.player.solidArea.x = gp.player.solidAreaDefaultX;
            gp.player.solidArea.y = gp.player.solidAreaDefaultY;
            eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
            eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        }

        return hit;
    }

    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.playSoundEffect(6);
        gp.ui.currentDialogue = "You fall into a pit!";
        gp.player.life -= 1;
        canTouchEvent = false;
    }
    public void healingPool(int gameState){
        if (gp.keyH.enterPressed == true){
            gp.gameState = gameState;
            gp.playSoundEffect(2);
            gp.ui.currentDialogue = "You just drink the water.\n Your HP and Mana has been recovered!";
            gp.player.life = gp.player.maxLife;
            gp.player.mana = gp.player.maxMana;
            gp.aSetter.setMonster();
        }
    }
    public void teleport(int map, int col, int row){

        gp.gameState = gp.transitionState;
        tempMap = map;
        tempCol = col;
        tempRow = row;
        canTouchEvent = false;
        gp.playSoundEffect(13);
    }
}
