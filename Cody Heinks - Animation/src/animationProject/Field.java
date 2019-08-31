package animationProject;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Field extends JPanel{
	
	private static final long serialVersionUID = -3030379568821478211L;
	private boolean alive = true;
	
	private ArrayList<Player> allPlayers = new ArrayList<Player>();
	private ArrayList<Player> alivePlayers = new ArrayList<Player>();
	private int numPlayers;
	private Player currentPlayer;
	
	private int borderThickness = 8;
	
	//Bounds
	private int xUpper;
	private int xLower;
	private int yUpper;
	private int yLower;
	
	public Field(int width, int height){
		updateBounds(width, height);
		numPlayers = GameRunner.getNumPlayers();
	}
	
	public void addPlayer(Player newPlayer) {
		if(newPlayer.isAlive()) {
			alivePlayers.add(newPlayer);
			allPlayers.add(newPlayer);
		}else {
			allPlayers.add(numPlayers, newPlayer);
		}
	}
	
	public int getThick() {return borderThickness;}
	
	public int getXUpper() {return xUpper;}
	public int getXLower() {return xLower;}
	public int getYUpper() {return yUpper;}
	public int getYLower() {return yLower;}
	
	public void updateBounds(int newWidth, int newHeight) {
		xUpper = borderThickness; //Left
		xLower = newWidth - (borderThickness+6); //Right
		yUpper = borderThickness; //Top
		yLower = newHeight - (borderThickness+6 + 29);
//		yLower = newHeight - (borderThickness+6 + 23); //Bottom
	}
	
	public boolean isAlive() {return alive;}
	
	public void paintComponent(Graphics g) {
    	makeBorder(g);
        //Draw Players
        for(int i = allPlayers.size()-1; i >= 0; i--) {
        	currentPlayer = allPlayers.get(i);
        	if(currentPlayer.getShape() == "DOT") {
    	    	g.setColor(currentPlayer.getColor());
    	    	g.fillRect(currentPlayer.getX(), currentPlayer.getY(), 
    	    			currentPlayer.getWidth(), currentPlayer.getHeight());
            }
        }
    }
	private void makeBorder(Graphics g) {
		//White Border
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //Black Border
        g.setColor(Color.BLACK);
        g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
        
        //Inside Color
        g.setColor(Color.WHITE);
        g.fillRect(borderThickness, borderThickness, this.getWidth()-(borderThickness*2), this.getHeight()-(borderThickness*2));
	}
	
	public void checkCollisions() {
		for(int i = alivePlayers.size()-1; i >= 0; i--) {
			Player p1 = alivePlayers.get(i);
			for(int j = i-1; j >= 0; j--) {
				Player p2 = alivePlayers.get(j);
				if(p1.collidesWith(p2)) {
					p2.kill();
					alivePlayers.remove(i);
					alivePlayers.remove(j);
					j = -1;
					i--;
				}
			}
//			for(int j = 0; j < allPlayers.size(); j++) {
//				if(currentPlayer.collidesWith(allPlayers.get(j))) {
//					currentPlayer.kill();
//					allPlayers.set(allPlayers.indexOf(alivePlayers.get(i)), currentPlayer);
//					alivePlayers.remove(i);
//					j = allPlayers.size();
//				}
//			}
			
		}
		if(alivePlayers.size() <= 1) {alive = false;}
	}
}
