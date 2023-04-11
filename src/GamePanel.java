
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; //size of game tiles
    final int scale = 4; //Factor to scale up tiles. On 1080p 16x16 looks small

    final int tileSize = originalTileSize * scale; //Tile size scaled up
    final int maxCol = 16; // Columns and rows of tiles making up game
    final int maxRow = 12; //4:3 resolution
    final int screenWidth = tileSize * maxCol; //Window width in pixels
    final int screenHeight = tileSize * maxRow; //Window height in pixels.

    Thread gameThread;

    public GamePanel() {
	this.setPreferredSize(new Dimension(screenWidth, screenHeight));
	this.setBackground(Color.black);
	this.setDoubleBuffered(true);
    }

    public void startGameThread() {
	gameThread = new Thread(this);
	gameThread.start();
    }

    @Override
    public void run() {//When an object implementing runnable creates a thread. causes run method to be called in that thread.
	while (gameThread != null) {
	    update();//Call update method to update character position

	    repaint();
	}
    }
    
    public void update(){
    
    }
    
    public void paintComponent(Graphics g){
    
	super.paintComponent(g);

	Graphics2D g2 = (Graphics2D)g; //Graphics2D has extra functionality
    }
}
