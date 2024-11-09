/**
 * 
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * Creates the frame of the snake game
 */
public class SnakeFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1889370235596006626L;

	SnakeFrame(){
		
		SnakePanel panel = new SnakePanel();
		
		this.add(panel);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		

        // Add key listener to the frame
        addKeyListener(new KeyAdapter() {
            //@Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    restartGame();
                }
            }
        });
    }

    private void restartGame() {
        // Restart the game
        ((SnakePanel) getContentPane().getComponent(0)).startGame();
    }

	

}
