/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package houkai;

import entity.Entity;

/**
 *
 * @author AsuS
 */
public class CollisionChecker {
    GamePanel gp;
    
    //--> Constructor untuk memeriksa tabrakan
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    
    //--> Untuk pengecekan ubin
    public void checkTile(Entity entity){
        //--> Untuk pengecekan berdasarkan koordinat Solid Area (daerah yg padat player)
<<<<<<< Updated upstream
        int entityLeftWorldX = entity.getEntityLeftWorldX(); //kiriX = 8
        int entityRightWorldX = entity.getEntityRightWorldX(); //kananX = 16
        int entityTopWorldY = entity.getEntityTopWorldY(); //atasY = 32
        int entityBottomWorldY = entity.getEntityBottomWorldY(); //bawahY = 32

=======
        int entityLeftWorldX = entity.worldX + entity.solidArea.x; //kiriX = 8
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width; //kananX = 16
        int entityTopWorldY = entity.worldY + entity.solidArea.y; //atasY = 32
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height; //bawahY = 32
        
>>>>>>> Stashed changes
        //--> Untuk mencari Nomor Col dan Row didapatkan dari koordinat diatas 
        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        //--> Untuk memeriksa arah entity mau kemana
        switch(entity.direction){
        case "up":
            entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            
            //--> Untuk pengecekan jika ada salah 1 atau keduanya benar, pemain menabrak petak padat sehingga tidak dapat bergerak ke arah ini
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
            
        case "down":
            entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "left":
            entityLeftCol = (entityLeftWorldX + entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        case "right":
            entityRightCol = (entityRightWorldX - entity.speed)/gp.tileSize;
            tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
            tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                entity.collisionOn = true;
            }
            break;
        }
    }
<<<<<<< Updated upstream

    public int checkObject(Entity entity, boolean isPlayer) {
=======
        
    public int checkObject(Entity entity, boolean player){
>>>>>>> Stashed changes
        int index = 999;
        
        for (int i=0; i<gp.obj.length; i++){
            if (gp.obj[i] != null){
                //--> Untuk mendapatkan entity petaknya padat
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                //--> Untuk mendapatkan object petaknya padat
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

<<<<<<< Updated upstream
        for (Items item : gamePanel.items) {
            if (item != null) {
                // untuk mendapatkan entity petaknya padat
                entity.getSolidArea().x = entity.getWorldX() + entity.getSolidArea().x;
                entity.getSolidArea().y = entity.getWorldY() + entity.getSolidArea().y;
                // untuk mendapatkan object petaknya padat
                item.getSolidArea().x = item.getWorldX() + item.getSolidArea().x;
                item.getSolidArea().y = item.getWorldY() + item.getSolidArea().y;
                switch (entity.getDirection()) {
                    case "up" -> {
                        entity.getSolidArea().y = entity.getSolidArea().y - entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            // untuk memberi tanda jika entity tabrakan
                            if (item.isCollision() == true) {
                                entity.setCollisionOn(true);
                            }
                            if (isPlayer == true) {
                                index = 1;
                            }
                        }
                    }
                    case "down" -> {
                        entity.getSolidArea().y = entity.getSolidArea().y + entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if (item.isCollision() == true) {
                                entity.setCollisionOn(true);
                            }
                            if (isPlayer == true) {
                                index = 1;
                            }
                        }
                    }
                    case "left" -> {
                        entity.getSolidArea().x = entity.getSolidArea().x - entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if (item.isCollision() == true) {
                                entity.setCollisionOn(true);
                            }
                            if (isPlayer == true) {
                                index = 1;
                            }
                        }
                    }
                    case "right" -> {
                        entity.getSolidArea().x = entity.getSolidArea().x + entity.getSpeed();
                        if (entity.getSolidArea().intersects(item.getSolidArea())) {
                            if (item.isCollision() == true) {
                                entity.setCollisionOn(true);
                            }
                            if (isPlayer == true) {
                                index = 1;
=======
                //--> Untuk menentukan arah entity
                switch (entity.direction){ 
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        //--> Untuk memberi tanda jika entity tabrakan
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                         if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                         if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                         if (entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if (gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if (player == true){
                                index = i;
>>>>>>> Stashed changes
                            }
                        }
                        break;
                }
<<<<<<< Updated upstream
                // untuk menentukan arah entity / entitas
                entity.resetSolidArea();
                item.resetSolidArea();
=======
                
                //--> Untuk mengatur ulang solidArea entity dan object
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
>>>>>>> Stashed changes
            }
        }
        return index;
    }
}
