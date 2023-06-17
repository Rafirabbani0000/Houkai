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
<<<<<<< Updated upstream:src/items/Door.java
public class Door extends Items {

    public Door(int worldX, int worldY) {
        super(worldX, worldY);
=======
public class OBJ_door extends superObject {
      public OBJ_door(){
>>>>>>> Stashed changes:src/object/OBJ_door.java
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/door.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
        super.worldX = worldX;
        super.worldY = worldY;
    }
}