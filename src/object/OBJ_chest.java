/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author TOSHIBA
 */
<<<<<<< Updated upstream:src/items/Chest.java
public class Chest extends Items {

    public Chest(int worldX, int worldY) {
        super(worldX, worldY);
=======
public class OBJ_chest extends superObject {
      public OBJ_chest(){
>>>>>>> Stashed changes:src/object/OBJ_chest.java
        name = "chest";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/chest_1.png"));                   
        }catch(IOException e){
            e.printStackTrace();
        }
<<<<<<< Updated upstream:src/items/Chest.java
        super.worldX = worldX;
        super.worldY = worldY;
=======
        collision = true;
>>>>>>> Stashed changes:src/object/OBJ_chest.java
    }
}