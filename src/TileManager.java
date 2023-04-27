
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gamePanel){
	this.gamePanel = gamePanel;
	
	tile = new Tile[2];
	mapTileNum = new int[gamePanel.MAX_COL][gamePanel.MAX_ROW];

	getTileImage();
	loadMap("/maps/map.txt");
	
    }

    public void getTileImage(){
	
	try{
	    tile[0] = new Tile();
	    tile[0].image = ImageIO.read(getClass().getResourceAsStream("/spriteAndTiles/lavaTile.png"));
	    //tile[0].collision = true;
	    
	    tile[1] = new Tile();
	    tile[1].image = ImageIO.read(getClass().getResourceAsStream("/spriteAndTiles/floorTile.png"));
	    
	}catch(IOException e){
	    e.printStackTrace();
	}
    }
    public void loadMap(String mapFile){
	
	try{
	    InputStream is = getClass().getResourceAsStream(mapFile);
	    BufferedReader br = new BufferedReader(new InputStreamReader(is));
	    
	    int col = 0;
	    int row = 0;
	    
	    while(col < gamePanel.MAX_COL && row < gamePanel.MAX_ROW){
		
		String line = br.readLine();
		
		while(col < gamePanel.MAX_COL){
		    
		    String numbers[] = line.split(" ");
		    
		    int num = Integer.parseInt(numbers[col]);
		    
		    mapTileNum[col][row] = num;
		    col++;
		}
		if(col == gamePanel.MAX_COL){
		  col = 0;
		  row++;
		}
	    }
	    br.close();
	    
	}catch(Exception e){
	    
	}
	
    }
    public void draw(Graphics2D g2){
	
	int col = 0;
	int row = 0;
	int x = 0;
	int y = 0;

	while(col < gamePanel.MAX_COL && row < gamePanel.MAX_ROW){
	    
	    int tileNum = mapTileNum[col][row];
	    
	    g2.drawImage(tile[tileNum].image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
	    col++;
	    x += gamePanel.TILE_SIZE;

	    if(col == gamePanel.MAX_COL){
		col = 0;
		x = 0;
		row++;
		y += gamePanel.TILE_SIZE;
	    }
	}


    }    
}
