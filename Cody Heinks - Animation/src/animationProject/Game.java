package animationProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game {
	private int numPlayers;
	boolean playing = false;
	
	JFrame frame;
	Field mainField;
	ArrayList<Player> allPlayers;
	private int windowWidth = (int)(GameRunner.getScreenSize().getWidth());
	private int windowHeight = (int)(GameRunner.getScreenSize().getHeight());
	
	public Game(int pN) {
		numPlayers = pN;
		playing = true;
		allPlayers = new ArrayList<Player>();
        frame = new JFrame("My Animation");
        mainField = new Field(windowWidth, windowHeight);
        
        ArrayList<Color> colorsPicked = new ArrayList<Color>();
        colorsPicked.add(Color.WHITE);
        Color randColor = Color.WHITE;
        
        for(int i = 0; i < numPlayers; i++) {
        	while(colorsPicked.indexOf(randColor) >= 0) {randColor = GameRunner.randomColor();}
        	colorsPicked.add(randColor);
        	
        	Player newPlayer = new Player(i, GameRunner.randomLocation(getMin(), getMax()), 
        			GameRunner.randomSpeed(), GameRunner.randomSpeed(), "CIRCLE", 
        			GameRunner.randomSize(), randColor, true);
            allPlayers.add(0, newPlayer);
        }
        
        for(Player p : allPlayers) {
        	mainField.addPlayer(p);
        	p.setField(mainField);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, mainField);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocation(0, 0);
    }
	
	public boolean run() {
		move();
		try {
            Thread.sleep(1000);
        } catch (Exception exc) {}
		frame.dispose();
		return true;
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
	private int getMin() {return mainField.getThick();}
	
	private int getMax() {
		if(windowWidth > windowHeight) {
			return windowHeight - mainField.getThick();
		}else {
			return windowWidth - mainField.getThick();
		}
	}
}
