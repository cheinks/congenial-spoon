package animationProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game {
	private int numPlayers;
	boolean playing = false;
	private int winners = 0;
	
	JFrame frame;
	Field mainField;
	ArrayList<Player> allPlayers = new ArrayList<Player>();
	private int windowWidth = (int)(GameRunner.getScreenSize().getWidth());
	private int windowHeight = (int)(GameRunner.getScreenSize().getHeight());
	
	public Game() {
        frame = new JFrame("My Animation");
        mainField = new Field(windowWidth, windowHeight);
        frame.getContentPane().add(BorderLayout.CENTER, mainField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocation(0, 0);
    }

	public void run() {
		numPlayers = 7 - winners;
		playing = true;
        
		ArrayList<Color> colorsPicked = new ArrayList<Color>();
		if(allPlayers.size() > 0) {
			colorsPicked.add(allPlayers.get(0).getTrailColor());
		}
        colorsPicked.add(Color.WHITE);
        Color randColor = Color.WHITE;
        
        for(int i = 0; i < numPlayers; i++) {
        	while(colorsPicked.indexOf(randColor) >= 0) {randColor = GameRunner.randomColor();}
        	colorsPicked.add(randColor);
        	
        	Player newPlayer = new Player(i, GameRunner.randomLocation(getMin(), getMax()), 
        			GameRunner.randomSpeed(), GameRunner.randomSpeed(), GameRunner.randomShape(), 
        			GameRunner.randomSize(), randColor, true);
            allPlayers.add(0, newPlayer);
        }
        
        for(Player p : allPlayers) {
        	mainField.addPlayer(p);
        	p.setField(mainField);
        }
        
		move();
	}
	
	public void celebrate() {
		allPlayers.clear();
		ArrayList<Player> winners = mainField.getWinners();
		this.winners = winners.size();
		ArrayList<Player> fans = mainField.getFans(winners.get(0));
		mainField.resetGame();
		
		for(Player w: winners) {
			w.setWinID(-1);
			allPlayers.add(w);
		}
		for(Player f: fans) {
			f.setWinID(-1);
			mainField.addPlayer(f);
		}
	}

	private void move() {
	    while(playing) {
	    	for(int i = 0; i < allPlayers.size(); i++) {
	    		Player cp = allPlayers.get(i);
	    		if(cp.isAlive()) {
    			Player trail = new Player(cp.getID(), new int[] {cp.getX(), cp.getY()}, 0, 0, 
    					cp.getShape(), cp.getSize(), cp.getTrailColor(), false);
    			mainField.addPlayer(trail);
    			cp.moveSelf();
    			cp.checkBounds();
    			}
	    	}
	    	mainField.checkCollisions();
	        try {
	            Thread.sleep(10);
	        } catch (Exception exc) {}
	        frame.repaint();
	        playing = mainField.isAlive();
	    }
	}
	private int getMin() {return mainField.getThick() + 20;}
	
	private int getMax() {
		if(windowWidth > windowHeight) {
			return windowHeight - (mainField.getThick() + 20);
		}else {
			return windowWidth - (mainField.getThick() + 20);
		}
	}
}
