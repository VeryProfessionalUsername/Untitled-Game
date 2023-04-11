
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Alex
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	// TODO code application logic here
	JFrame window = new JFrame();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setTitle("Generic Dungeon Game!");

	GamePanel gamePanel = new GamePanel();
	window.add(gamePanel);
	
	window.pack();//Sizes window to fit gamePanel

	window.setLocationRelativeTo(null);
	window.setVisible(true);
    }
    
}
