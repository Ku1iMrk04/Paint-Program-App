/**
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Random;

import javax.swing.JPanel;

/**
 * creates the snake panel and its action.
 */
public class SnakePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8659867825757861720L;
	/**
	 * 
	 */
	static final int SCREEN_WIDTH = 600;
	/**
	 * 
	 */
	static final int SCREEN_HEIGHT = 600;
	/**
	 * 
	 */
	static final int UNIT_SIZE = 25;
	/**
	 * 
	 */
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	/**
	 * 
	 */
	static final int DELAY = 75;
	/**
	 * 
	 */
	final int x[] = new int[GAME_UNITS];
	/**
	 * 
	 */
	final int y[] = new int[GAME_UNITS];
	/**
	 * 
	 */
	int bodyParts = 6;
	/**
	 * 
	 */
	int applesEaten;
	/**
	 * 
	 */
	int appleX;
	/**
	 * 
	 */
	int appleY;
	/**
	 * 
	 */
	char direction = 'R';
	/**
	 * 
	 */
	boolean running = false;
	/**
	 * 
	 */
	Timer timer;
	/**
	 * 
	 */
	Random random;
	/**
	 * 
	 */
	boolean gameOver;
	
	/**
	 * Constructor
	 */
	SnakePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.GREEN);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
		//gameOver = false;
		
		// Make sure the panel is focusable and request focus
	    setFocusable(true);
	    requestFocusInWindow();
		
	}
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
		gameOver = false;
		
	}
	public void paintComponent(final Graphics theG) {
		super.paintComponent(theG);
		draw(theG);
		
	}
	public void draw(final Graphics theG) {
		
		if(running) {
//			for(int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
//				theG.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//				theG.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//			}
			theG.setColor(Color.RED);
			theG.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
			//draw the snake
			for(int i = 0; i < bodyParts; i++) {
				if(i == 0) {
					theG.setColor(Color.BLUE);
					theG.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					theG.setColor(Color.BLUE);
					theG.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			theG.setColor(Color.BLACK);
			theG.setFont(new Font("Times new roman", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(theG.getFont());
			theG.drawString("Score:" + applesEaten, 
					(SCREEN_WIDTH - metrics.stringWidth("Score:" + applesEaten)) / 2, 
					theG.getFont().getSize());
		}
		else {
			gameOver(theG);
		}
	}
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
		
	}
	public void move() {
		
		for(int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	public void checkApple() {
		
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesEaten++;
			newApple();
		}
		
	}
	public void checkCollisions() {
		// checks if head collides with body
		for(int i = bodyParts; i > 0; i--) {
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		// check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		// check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		// check to see if head touches top border
		if(y[0] < 0) {
			running = false;
		}
		// check to see if head touches bottom border
		if(y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(final Graphics theG) {
		// score 
		theG.setColor(Color.BLACK);
		theG.setFont(new Font("Times new roman", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(theG.getFont());
		theG.drawString("Score:" + applesEaten, 
				(SCREEN_WIDTH - metrics1.stringWidth("Score:" + applesEaten)) / 2, 
				theG.getFont().getSize());
		// set up game over text
		theG.setColor(Color.BLACK);
		theG.setFont(new Font("Times new roman", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(theG.getFont());
		theG.drawString("Game Over!", 
				(SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, 
				SCREEN_HEIGHT / 2);
		
		// Prompt to restart game
        theG.setColor(Color.BLACK);
        theG.setFont(new Font("Times new roman", Font.BOLD, 30));
        FontMetrics metrics3 = getFontMetrics(theG.getFont());
        theG.drawString("Press 'R' to Restart",
                (SCREEN_WIDTH - metrics3.stringWidth("Press 'R' to Restart")) / 2,
                (SCREEN_HEIGHT / 2) + 100);
        
        // set game over
        gameOver = true;
		
	}

	@Override
	public void actionPerformed(final ActionEvent theE) {
		// TODO Auto-generated method stub
		 if (!gameOver) {
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
		 }
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(final KeyEvent theE) {
			
			if (!gameOver) {
			switch(theE.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			case KeyEvent.VK_SPACE: // Restart the game
                if (!running) {
                    startGame();
                }
                break;
			}
			
			
		} else {
			
				System.out.println("Game over");                
				if (theE.getKeyCode() == KeyEvent.VK_SPACE) {
                    startGame();
                    
                }
         }
		}
	}
}

