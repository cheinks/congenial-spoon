import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class GameRunner {
	
	private boolean playing;
	
	private JFrame frame;
	private Rectangle rect;
	
	private Space mainSpace;
	private Rectangle level; //the current total level space
	private ArrayList<Asteroid> asteroids;
	private Player player1;
	private HUD mainHUD;

	public GameRunner() {
		initializeGame();
	}
	
	private void newGame() {
		frame = new JFrame();
		
		makeField();
		makeLevel();
		makePlayer();
		
		finalizeGame();
		
		play();
	}
	
	private void initializeGame() {
		playing = false;
		rect = new Rectangle(0, 0, Manual.screenWidth, Manual.screenHeight);
		asteroids = new ArrayList<Asteroid>();
	}
	private void finalizeGame() {
        frame.setLocation(rect.x, rect.y);
        frame.setSize(rect.width, rect.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
		playing = true;
	}
	
	private void makeField() {
		level = new Rectangle(0, 0, 5000, 5000);
//		level = rect;
		mainSpace = new Space(level, rect);
		frame.add(mainSpace);
	}
	private void makeLevel() {
		mainSpace.addStar(Manual.starArray(level, Manual.maxStarFreq));
		
		Polygon ap = Manual.newAsteroid(60, 80);
		Asteroid temp = new Asteroid(new Point(500, 300), ap.getBounds(), ap);
		mainSpace.addAsteroid(temp);
		asteroids.add(temp);
	}
	private void makePlayer() {
		player1 = new Player(
				Manual.fakeMiddle(Manual.playerWidth, Manual.playerHeight, level), /*center of the level for now*/
				Manual.playerWidth, Manual.playerHeight, 0);
		mainSpace.addPlayer(player1);
		
		//gives the user control over player1
		frame.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				player1.action(true, e.getKeyCode());
			}
			public void keyReleased(KeyEvent e) {
				player1.action(false, e.getKeyCode());
			}
			public void keyTyped(KeyEvent e) {}
		});
	}
	private void makeHUD() {
		mainHUD = new HUD();
		mainHUD.incomTrans("Hello world!");
	}
	
	private void play() {
		while(playing) {
			player1.move();
			for(Asteroid a : asteroids) {a.move();}
			
			try { Thread.sleep(Manual.delay); } catch (Exception exc) {}
			frame.repaint();
		}
	}

	public static void main(String[] args) {
		GameRunner run = new GameRunner();
		run.newGame();
	}

}
