package animationProject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Field extends JPanel {
	
	private static final long serialVersionUID = -3030379568821478211L;
	private boolean alive = true;
	
	private ArrayList<Player> deadPlayers = new ArrayList<Player>();
	private ArrayList<Player> alivePlayers = new ArrayList<Player>();
	
	private int borderThickness = 8;
	
	//Bounds
	private int xUpper;
	private int xLower;
	private int yUpper;
	private int yLower;
	
	public Field(int width, int height) {updateBounds(width, height);}
	
	public void addPlayer(Player newPlayer) {
		if(newPlayer.isAlive()) {
			alivePlayers.add(newPlayer);
		} else {
			deadPlayers.add(newPlayer);
		}
	}
	
	public int getThick() {return borderThickness;}
	
	public int getXUpper() {return xUpper;}
	public int getXLower() {return xLower;}
	public int getYUpper() {return yUpper;}
	public int getYLower() {return yLower;}
	
	public boolean isAlive() {return alive;}
	
	public void updateBounds(int newWidth, int newHeight) {
		xUpper = borderThickness; //Left
		xLower = newWidth - (borderThickness+6); //Right
		yUpper = borderThickness; //Top
		yLower = newHeight - (borderThickness+6 + 29);
//		yLower = newHeight - (borderThickness+6 + 23); //Bottom
	}
	
	public void paintComponent(Graphics g) {
    	makeBorder(g);
        //Draw Players
    	for(int i = 0; i < deadPlayers.size(); i++) {
    		Player t = deadPlayers.get(i);
    		if(t.getShape() == "DOT") {
    			g.setColor(t.getTrailColor());
    			g.fillRect(t.getX(), t.getY(), t.getWidth(), t.getHeight());
    		}
    	}
    	for(int j = 0; j < alivePlayers.size(); j++) {
    		Player p = alivePlayers.get(j);
    		if(p.getShape() == "DOT") {
    			g.setColor(p.getHeadColor());
    			g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
    		}
    	}
    }
	private void makeBorder(Graphics g) {
		//White Border
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //Black Border
        g.setColor(Color.BLACK);
        g.fillRect(3, 3, this.getWidth() - 6, this.getHeight() - 6);
        
        //Inside Color
        g.setColor(Color.WHITE);
        g.fillRect(borderThickness, borderThickness, this.getWidth()-(borderThickness * 2), 
        		this.getHeight() - (borderThickness * 2));
	}
	
	public void checkCollisions() {
		for(int i = alivePlayers.size()-  1; i >= 0; i--) {
			Player p1 = alivePlayers.get(i);
			for(int j = i-  1; j >= 0; j--) {
				Player p2 = alivePlayers.get(j);
				if(p1.collidesWith(p2)) {
					p1.kill();
					p2.kill();
					alivePlayers.remove(i);
					alivePlayers.remove(j);
					deadPlayers.add(p1);
					deadPlayers.add(p2);
					j = -1;
					i--;
				}
			}
		}
		if(alivePlayers.size() <= 1) {alive = false;}
	}
}
