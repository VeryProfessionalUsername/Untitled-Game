
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int ORIGINAL_TILE_SIZE = 16; //size of game tiles
    final int SCALE = 4; //Factor to scale up tiles. On 1080p 16x16 looks small

    final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; //Tile size scaled up
    final int MAX_COL = 16; // Columns and rows of tiles making up game
    final int MAX_ROW = 12; //4:3 resolution
    final int SCREEN_WIDTH = TILE_SIZE * MAX_COL; //Window width in pixels
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_ROW; //Window height in pixels.

    InputDetection input = new InputDetection();//Creates new input detection created in InputDetection.java
    Thread gameThread;

    public GamePanel() {
	this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	this.setBackground(Color.black);
	this.setDoubleBuffered(true);//Makes game look smoother. Enabled by default
	this.addKeyListener(input);//Panel can now accept keyboard input
	this.setFocusable(true);//Panel can be focused (clicked on) to recieve input
    }

    public void startGameThread() {
	gameThread = new Thread(this);
	gameThread.start();
    }

    @Override
    public void run() {//When an object implementing runnable creates a thread. causes run method to be called in that thread.
	while (gameThread != null) {
	    update();//Call update method to update character position

	    repaint();//Call to redraw the screen with updated positions.
	}
    }
    
    public void update(){
    
    }
    
    public void paintComponent(Graphics g){
    
	super.paintComponent(g);

	Graphics g2 = (Graphics2D)g;//Graphics2D similar to Graphics + extra functionality

	g2.setColor(Color.white);

	g2.fillRect(100, 100, TILE_SIZE, TILE_SIZE);//Creates rectangle at (100, 100) that is TILE_SIZE square

	g2.dispose();
    }
}
