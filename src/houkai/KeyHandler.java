/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package houkai;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author AsuS
 */
public class KeyHandler implements KeyListener {
    
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    // Debug
    boolean checkDrawTime = false;
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //--> Untuk memeriksa tombol yang ditekan dan akan diperiksa
        int code = e.getKeyCode(); 
        
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_P){
            if (gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if (gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }
        
        // DEBUG
        if(code == KeyEvent.VK_T){ // ini berfunsgi untuk mengaktifkan atau mennonaktifkan
            if(checkDrawTime == false){
                checkDrawTime = true;
            }
            else if(checkDrawTime == true){
                 checkDrawTime = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //--> Untuk memeriksa tombol yang dilepas dan akan diubah jadi false
        int code = e.getKeyCode(); 
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
