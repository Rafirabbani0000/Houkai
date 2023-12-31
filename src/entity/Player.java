/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import houkai.GamePanel;             //--> Mengatur tampilan dan perilaku permainan.
import houkai.KeyHandler;            //--> Mengatur pemrosesan input tombol kunci dalam permainan.
import houkai.UtilityTool;
import java.awt.Graphics2D;          //--> Mengatur transformasi dan kualitas gambar.
import java.awt.Rectangle;
import java.awt.image.BufferedImage; //--> Untuk merepresentasikan gambar, dimodifikasi aplikasi Java, membaca, menulis, dan memanipulasi gambar.
import java.io.IOException;          //--> Untuk pengecualian yg dilemparkan ketika terjadi kesalahan atau gangguan dalam operasi input/output.
import javax.imageio.ImageIO;        //--> Untuk membaca gambar dari file atau menulis gambar ke file dalam aplikasi Java.

/**
 *
 * @author AsuS
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    
    //--> Untuk menempatkan karakter pemain ditengah layar dan mengikuti latar belakang saat bergerak
    public final int screenX;
    public final int screenY;
    
    // untuk menunjukkan berapa kunci yg dimiliki pemain saat ini
    // public int hasKey = 0;
    int standCounter = 0;

    //Constructor Player
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        //--> Untuk mengembalikan titik tengah layar
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        //--> Untuk membuat kotak kecil untuk player
        solidArea = new Rectangle(); 
        solidArea.x = 8;
        solidArea.y = 16;
        //--> Untuk merekam nilai default untuk mengubah nilai x/y
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValue();
        getPlayerImage();
    }
    
    //--> Untuk dijadikan posisi awal player
    public void setDefaultValue(){
        worldX = 520 * 3;
        worldY = 760 * 3;
        speed = 4;
        direction = "up";
    }
    
    //--> Untuk dijadikan sprite player saat bergerak
    public void getPlayerImage(){
      
        up1 = setup("nu_up_01");
        up2 = setup("nu_up_02");
        up3 = setup("nu_up_03");
        down1 = setup("nu_down_01");
        down2 = setup("nu_down_02");
        down3 = setup("nu_down_03");
        left1 = setup("nu_left_01");
        left2 = setup("nu_left_02");
        left3 = setup("nu_left_03");
        right1 = setup("right_01");
        right2 = setup("right_02");
        right3 = setup("right_03");
                   
    }
    
    public BufferedImage setup(String imageName){
        UtilityTool uTool = new UtilityTool ();
        BufferedImage image = null;
        
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName +".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
    public void update(){
        //--> Untuk pengecekan jika key ditekan akan diupdate
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed){
            //--> Untuk setiap penekanan key maka akan menambah / mengurang 4 pixel
            if(keyH.upPressed == true){
                direction = "up";
            }else if(keyH.downPressed == true){
                direction = "down";
            }else if(keyH.leftPressed == true){
                direction = "left";
            }else if(keyH.rightPressed == true){
                direction = "right";
            }

            //--> Untuk memeriksa / mengecek tabrakan pada ubin
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //--> Untuk memeriksa tabrakan pada objek
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
            
            //--> untuk pengecekan jika Collision == false maka player dapat gerak dan sebaliknya
            if(collisionOn == false){
                switch (direction) {
                case "up":
                    worldY -= speed; //key W
                    break;
                case "down":
                    worldY += speed; //key S
                    break;
                case "left":
                    worldX -= speed; //key A
                    break;
                case "right":
                    worldX += speed; //key D
                    break;
                }
            }
            spriteCounter++;
            
            //--> Untuk mengatur kecepatan sprite 
            if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    
    public void pickUpObject (int i){
        //--> Jika index bukan 999 maka kita telah menyentuh suatu object
        if(i!=999){ 
            
        }
    }
    
    //--> Untuk mencetak gambar sesuai dengan urutan sprite sesuai dengan key yang kita tekan
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        
        switch(direction){
        case "up": //key W
            if(spriteNum == 1){
                image = up1;
            }
            if(spriteNum == 2){
                image = up2;
            }
            if(spriteNum == 3){
                image = up3;
            }
            break;
        case "down": //Key S
            if(spriteNum == 1){
                image = down1;
            }
            if(spriteNum == 2){
                image = down2;
            }
            if(spriteNum == 3){
                image = down3;
            }
            break;
        case "left": //Key A
            if(spriteNum == 1){
                image = left1;
            }
            if(spriteNum == 2){
                image = left2;
            }
            if(spriteNum == 3){
                image = left3;
            }
            break;
        case "right": //Key D
            if(spriteNum == 1){
                image = right1;
            }
            if(spriteNum == 2){
                image = right2;
            }
            if(spriteNum == 3){
                image = right3;
            }
            break;
        }
        
        //--> Untuk mencetak gambar pada frame
        g2.drawImage(image, screenX, screenY,null);
    }
    
}
