package animationProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Game {
	private int numPlayers;
	boolean playing = false;
	
	JFrame frame;
	Field mainField;
	ArrayList<Player> players;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int windowWidth = (int)(screenSize.getWidth()*0.75);
	private int windowHeight = (int)(screenSize.getHeight()*0.75);
	
	public Game(int pN){
//		windowWidth = 300;
//		windowHeight = 300;
		numPlayers = pN;
		if(numPlayers > 10) {numPlayers = 10;}
		playing = true;
		players = new ArrayList<Player>();
        frame = new JFrame("My Animation");
        mainField = new Field(windowWidth, windowHeight);
        
        for(int i = 0; i < numPlayers; i++) {
        	Player newPlayer = new Player(i, GameRunner.randomLocation(mainField.getThick(), 
        			getMax()), GameRunner.randomSpeed(), GameRunner.randomSpeed(), "DOT", 
        			GameRunner.randomSize(), GameRunner.randColor(), true);
            players.add(0, newPlayer);
        }
        
        for(Player p : players) {
        	mainField.addPlayer(p);
        	p.setField(mainField);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, mainField);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocation(375, 55);
//        frame.setAlwaysOnTop(true);
    }
	
	public boolean run() {
		move();
		try{
            Thread.sleep(1000);
        } catch (Exception exc){}
		frame.dispose();
		return true;
	}

	private void move() {
	    while(playing){
	    	for(int i = 0; i < players.size(); i++) {
	    		Player cp = players.get(i);
	    		if(cp.isAlive()) {
	    			Player trail = new Player(cp.getID(), new int[] {cp.getX(), cp.getY()}, 0, 0, 
	    					cp.getShape(), cp.getSize(), cp.getTrailColor(cp.getColor()), false);
	    			players.add(trail);
	    			mainField.addPlayer(trail);
	    			cp.moveSelf();
	    			cp.checkBounds();
	    		}
	    	mainField.checkCollisions();
	    	}
	        try{
	            Thread.sleep(10);
	        } catch (Exception exc){}
	        frame.repaint();
	        playing = mainField.isAlive();
	    }
	}
	
	private int getMax() {
		if(windowWidth > windowHeight) {
			return windowHeight;
		}else {
			return windowWidth;
		}
	}
}
