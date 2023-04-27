
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class Player extends Entity{
    GamePanel gamePanel;
    InputDetection input;

    public Player (GamePanel gamePanel, InputDetection input){
	
	this.gamePanel = gamePanel;
	this.input = input;

	setDefaultValues();
    }
    public void setDefaultValues(){
	x = 100;
	y = 100;
	speed = 4;
    }
    public void update(){
	if(input.up){
	    y -= speed;//For whatever reason Y increases as you go down.
	}
	if(input.left){
	    x -= speed;//For whatever reason Y increases as you go down.
	}
	if(input.down){
	    y += speed;//For whatever reason Y increases as you go down.
	}
	if(input.right){
	    x += speed;//For whatever reason Y increases as you go down.
	}
    }
    public void draw(Graphics2D g2){
	g2.setColor(Color.white);

	g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);//Creates rectangle at (100, 100) that is TILE_SIZE square
    }
}
