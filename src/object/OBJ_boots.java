/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import houkai.GamePanel;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author AsuS
 */
public class OBJ_boots extends superObject {
    
    GamePanel gp;
    public OBJ_boots(GamePanel gp){ 
        this.gp = gp;
        
        name = "boots";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tiles/food.png")); // untuk memuat gambar
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
