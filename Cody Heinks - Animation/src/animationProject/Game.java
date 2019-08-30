package animationProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Game {
	
	boolean playing = false;
	
	JFrame frame;
	Field mainField;
	ArrayList<Player> players = new ArrayList<Player>();
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int windowWidth = (int)(screenSize.getWidth()/2);
	private int windowHeight = (int)(screenSize.getHeight()/2);
	
	public Game(){
		playing = true;
        frame = new JFrame("My Animation");
        mainField = new Field(windowWidth, windowHeight);
        
        for(int i = 0; i < 2; i++) {
        	Player newPlayer = new Player(i, GameRunner.randomLocation(mainField.getThick(), getMax()), 
        			GameRunner.randomSpeed(), GameRunner.randomSpeed(), "DOT", GameRunner.randomSize(), 
        			GameRunner.randColor(), true);
            players.add(0, newPlayer);
        }
        
        for(Player p : players) {
        	mainField.addPlayer(p);
        	p.setField(mainField);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentListener(new FrameListener());
        
        frame.getContentPane().add(BorderLayout.CENTER, mainField);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocation(375, 55);
        move();
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
	    	}
	        try{
	            Thread.sleep(10);
	        } catch (Exception exc){}
	        frame.repaint();
	    }
	}
	
	private class FrameListener implements ComponentListener{
		public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        public void componentResized(ComponentEvent e) {
        	windowWidth = frame.getWidth();
        	windowHeight = frame.getHeight();
        	mainField.updateBounds(windowWidth, windowHeight);
        }
        public void componentShown(ComponentEvent e) {}
	}
	
	private int getMax() {
		if(windowWidth > windowHeight) {
			return windowHeight;
		}else {
			return windowWidth;
		}
	}
}
