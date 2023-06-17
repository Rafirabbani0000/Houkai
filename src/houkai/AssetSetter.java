/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package houkai;

<<<<<<< Updated upstream
import entity.Enemy;
import items.Chest; // ini untuk item chest
import items.Door; // ini untuk item door
import items.Key; // ini untuk item key
=======
import object.OBJ_boots;
import object.OBJ_chest;
import object.OBJ_door; 
import object.OBJ_key; 
>>>>>>> Stashed changes

/**
 *
 * @author TOSHIBA
 */
public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
<<<<<<< Updated upstream

    public void setItems() {

        // kalau array diatur 10 maka item yg bisa ditampilkan bisa sampai 10, kalau terlalu banyak membuat game lambat
//        gamePanel.items[0] = new Key();
//        gamePanel.items[0].worldX = 520 * 3;
//        gamePanel.items[0].worldY = 720 * 3; // item ke 1
        
        gamePanel.items.add(new Key(593 * 3, 735 * 3)); // item ke 1
        
//        gamePanel.items[2] = new Door();
//        gamePanel.items[2].worldX = 43 * gamePanel.tileSize;
//        gamePanel.items[2].worldY = 9 * gamePanel.tileSize; // item ke 3
//        
//        gamePanel.items[3] = new Door();
//        gamePanel.items[3].worldX = 2 * gamePanel.tileSize;
//        gamePanel.items[3].worldY = 22 * gamePanel.tileSize; // item ke 4
//        
//        gamePanel.items[4] = new Chest();
//        gamePanel.items[4].worldX = 33 * gamePanel.tileSize;
//        gamePanel.items[4].worldY = 9 * gamePanel.tileSize; // item ke 5
//        
//        gamePanel.items[5] = new Chest();
//        gamePanel.items[5].worldX = 28 * gamePanel.tileSize;
//        gamePanel.items[5].worldY = 4 * gamePanel.tileSize; // item ke 6    
    }
    
    public void setEnemies() {
        gamePanel.enemies.add(new Enemy(520 * 3, 720 * 3));
=======
    
    public void setObject(){
        //===== Keys =====
        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 37 * gp.tileSize;
        gp.obj[0].worldY = 46 * gp.tileSize; 
        
        gp.obj[1] = new OBJ_key();
        gp.obj[1].worldX = 37 * gp.tileSize;
        gp.obj[1].worldY = 46 * gp.tileSize; 
        
        gp.obj[2] = new OBJ_key();
        gp.obj[2].worldX = 37 * gp.tileSize;
        gp.obj[2].worldY = 46 * gp.tileSize; 
        
        gp.obj[3] = new OBJ_key();
        gp.obj[3].worldX = 37 * gp.tileSize;
        gp.obj[3].worldY = 46 * gp.tileSize; 
        
        //===== Doors =====
        gp.obj[4] = new OBJ_door();
        gp.obj[4].worldX = 5 * gp.tileSize;
        gp.obj[4].worldY = 6 * gp.tileSize;
        
        gp.obj[5] = new OBJ_door();
        gp.obj[5].worldX = 32 * gp.tileSize;
        gp.obj[5].worldY = 30 * gp.tileSize;
        
        //===== chest =====
        gp.obj[6] = new OBJ_chest();
        gp.obj[6].worldX = 5 * gp.tileSize;
        gp.obj[6].worldY = 3 * gp.tileSize;  
        
        gp.obj[7] = new OBJ_chest();
        gp.obj[7].worldX = 32 * gp.tileSize;
        gp.obj[7].worldY = 27 * gp.tileSize;  
    
        //===== Boots =====
        gp.obj[8] = new OBJ_boots();
        gp.obj[8].worldX = 38 * gp.tileSize;
        gp.obj[8].worldY = 40 * gp.tileSize;
>>>>>>> Stashed changes
    }
}
