import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameMaster{
	
	private boolean playing;
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private JFrame frame;
	private Maze maze;
	private Runner player1;

	public GameMaster() {
		initialize();
	}
	
	public void newGame() {
		playing = true;
		
		frame = new JFrame("Run!");
		
		makeField();
		makePlayer();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLocation(x, y);
        
		play();
	}
	
	private void initialize() {
		playing = false;
		
		x = Manual.windowX;
		y = Manual.windowY;
		
		width = Manual.windowWidth;
		height = Manual.windowHeight;
	}
	
	private void makeField() {
		maze = new Maze(width - Manual.bufferX, height - Manual.bufferY);
		frame.getContentPane().add(BorderLayout.CENTER, maze);
	}
	
	private void makePlayer() {
		player1 = new Runner(Color.BLUE, 50, 50, 18, 3); //******************************************************
		maze.addPlayer(player1);
		
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
	
	private void play() {
		while(playing) {
			player1.move();
			
			try {
	            Thread.sleep(10);
	        } catch (Exception exc) {}
			frame.repaint();
		}
	}

	public static void main(String[] args) {
		GameMaster gm = new GameMaster();
		gm.newGame();
	}

}
