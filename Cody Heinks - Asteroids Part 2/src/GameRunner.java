import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.*;

public class GameRunner {
	
	private boolean playing;
	
	private JFrame frame;
	private Rectangle rect;
	
	private Space space;
	
	private Player player1;

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
		space = new Space();
		frame.getContentPane().add(BorderLayout.CENTER, space);
	}
	private void makeLevel() {}
	private void makePlayer() {
		player1 = new Player(
				Manual.fakeMiddle(Manual.playerWidth, Manual.playerHeight, rect), 
				Manual.playerWidth, Manual.playerHeight);
		
		space.addPlayer(player1.getPoly());
	}
	
	private void play() {
		while(playing) {
			
			try { Thread.sleep(10); } catch (Exception exc) {}
			frame.repaint();
		}
	}

	public static void main(String[] args) {
		GameRunner run = new GameRunner();
		run.newGame();
	}

}
