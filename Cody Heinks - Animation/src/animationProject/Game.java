package animationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game {
	
	boolean playing = false;
	
	JFrame frame;
	Field mainField;
	ArrayList<Player> players = new ArrayList<Player>();
	
	private int windowWidth = 300;
	private int windowHeight = 300;
	
	public Game(){
		playing = true;
        frame = new JFrame("Test");
        mainField = new Field(windowWidth, windowHeight);
        
        Player player1 = new Player(50, 50, 1, 1, "DOT", true);
        players.add(player1);
        
        for(Player p : players) {
        	mainField.addPlayer(p);
        	p.setField(mainField);
        }
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentListener(new FrameListener());
        
        frame.getContentPane().add(BorderLayout.CENTER, mainField);

        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocation(375, 55);
        move();
    }

	private void move() {
	    while(playing){
	    	for(int i = 0; i < players.size(); i++) {
	    		Player cp = players.get(i);
	    		if(cp.isAlive()) {
	    			Player trail = new Player(cp.getX(), cp.getY(), 1, 1, cp.getShape(), false);
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
}
