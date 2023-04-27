
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

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

	solidArea = new Rectangle();
	solidArea.x = 8;
	solidArea.y = 8;
	solidArea.width = 60;
	solidArea.height = 60;

	setDefaultValues();
	getPlayerImage();
    }
    public void setDefaultValues(){
	x = 0;
	y = 0;
	speed = 4;
    }
    public void getPlayerImage(){
	try{

	   sprite = ImageIO.read(getClass().getResourceAsStream("/spriteAndTiles/playerV2.png")); 

	}catch(IOException e){
	   e.printStackTrace(); 
	}
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

	collisionOn = false;
	gamePanel.collisionCheck.checkTile(this);
    }
    public void draw(Graphics2D g2){
	//g2.setColor(Color.white);

	//g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);//Creates rectangle at (100, 100) that is TILE_SIZE square

	BufferedImage image = sprite;

	g2.drawImage(image, x, y , gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);

    }
}
