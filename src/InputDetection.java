import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class InputDetection implements KeyListener{//Purpose of this class is to get input from keyboard.

    public boolean up, down, left, right;
    
    @Override
    public void keyTyped(KeyEvent e){//Not needed for game
    }

    @Override
    public void keyPressed(KeyEvent e){//Does stuff when a key is pressed
	int code = e.getKeyCode();//Gets code for key pressed on keyboard.

	if(code == KeyEvent.VK_W){//Decides what to do when W key is pressed
	    up = true;
	}
	if(code == KeyEvent.VK_A){
	    left = true;
	}
	if(code == KeyEvent.VK_S){
	    down = true;
	}
	if(code == KeyEvent.VK_D){
	    right = true;
	}
    }

    @Override
    public void keyReleased(KeyEvent e){//Does stuff when key is released
	int code = e.getKeyCode();//Gets code for key released on keyboard.

	if(code == KeyEvent.VK_W){//Decides what to do when W key is released
	    up = false;
	}
	if(code == KeyEvent.VK_A){
	    left = false;
	}
	if(code == KeyEvent.VK_S){
	    down = false;
	}
	if(code == KeyEvent.VK_D){
	    right = false;
	}
    }
}
