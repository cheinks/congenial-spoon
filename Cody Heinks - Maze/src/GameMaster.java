import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;

import javax.swing.JFrame;

/* This class controls the all elements of 
 * the game in its instantiation. 
 * */

public class GameMaster {
	
	private boolean playing;
	
	//values of the window "rectangle"
	private int x;
	private int y;
	private int width;
	private int height;
	
	private JFrame frame; //the main window
	private Maze maze;
	//private ArrayList<Sprite> allSprites;
	private Runner mainRunner;
	
	private ArrayList<Wall> test2;

	public GameMaster() {
		initializeGame();
	}
	
	public void newGame() {
		playing = true;
		
		frame = new JFrame("Run!");
		
		makeField();
		makeLevel();
		makeRunner();
		
		finalizeGame();
        
		play();
	}
	
	private void initializeGame() {
		playing = false;
		
		x = Manual.windowX;
		y = Manual.windowY;
		
		width = Manual.windowWidth;
		height = Manual.windowHeight;
	}
	private void finalizeGame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLocation(x, y);
	}
	
	//Creates the main GUI and adds it to the game window
	private void makeField() {
		maze = new Maze(width - Manual.bufferX, height - Manual.bufferY);
		frame.getContentPane().add(BorderLayout.CENTER, maze);
	}
	
	private void makeLevel() {
		test2 = new ArrayList<Wall>();
		
		Wall temp = new Wall(Color.GREEN, 100, 100, 100);
		test2.add(temp);
		maze.addSprite(temp);
	}
	
	//Creates the main player sprite
	private void makeRunner() {
		mainRunner = new Runner(Color.BLUE, Manual.start.x, Manual.start.y, Manual.playerSize, Manual.playerSpeed, test2);
		maze.addSprite(mainRunner); //so it can be drawn
		
		//gives the user control over the runner sprite
		frame.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				mainRunner.action(true, e.getKeyCode());
			}
			public void keyReleased(KeyEvent e) {
				mainRunner.action(false, e.getKeyCode());
			}
			public void keyTyped(KeyEvent e) {}
		});
	}
	
	//The main game loop
	private void play() {
		while(playing) {
			mainRunner.move();
			
			try { Thread.sleep(10); } catch (Exception exc) {}
			frame.repaint();
		}
	}

	//called to start the game
	public static void main(String[] args) {
		GameMaster gm = new GameMaster();
		gm.newGame();
	}

}
