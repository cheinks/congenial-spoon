package animationProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
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
	
	public int getThick() {return borderThickness;}
	
	public int getXUpper() {return xUpper;}
	public int getXLower() {return xLower;}
	public int getYUpper() {return yUpper;}
	public int getYLower() {return yLower;}
	
	public boolean isAlive() {return alive;}
	public ArrayList<Player> getWinners(){
		ArrayList<Player> winners = alivePlayers;
		Player player = winners.get(0);
		int winID = player.getID();
		for(Player t: deadPlayers) {
			if(t.getID() == winID) {
				winners.add(t);
			}
		}
		return winners;
	}
	
	public void addPlayer(Player newPlayer) {
		if(newPlayer.isAlive()) {
			alivePlayers.add(newPlayer);
		} else {
			deadPlayers.add(newPlayer);
		}
	}
	
	public void updateBounds(int newWidth, int newHeight) {
		xUpper = borderThickness; //Left
		xLower = newWidth - (borderThickness+6); //Right
		yUpper = borderThickness; //Top
//		yLower = newHeight - (borderThickness+6 + 29);
		yLower = newHeight - (borderThickness+6 + 23); //Bottom
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
		if(alivePlayers.size() <= 2) {alive = false;}
	}
	
	public void paintComponent(Graphics g) {
    	drawBorder(g);
        //Draw Players
    	for(int i = 0; i < deadPlayers.size(); i++) {
    		Player t = deadPlayers.get(i);
    		drawPlayer(g, t.getX(), t.getY(), t.getWidth(), t.getHeight(), 
    				t.getShape(), t.getTrailColor(), false);
    	}
    	for(int j = 0; j < alivePlayers.size(); j++) {
    		Player p = alivePlayers.get(j);
    		drawPlayer(g, p.getX(), p.getY(), p.getWidth(), p.getHeight(), 
    				p.getShape(), p.getHeadColor(), true);
    	}
    }
	
	private void drawBorder(Graphics g) {
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
	
	private void drawPlayer(Graphics g, int x, int y, int width, int height, 
			String shape, Color color, boolean alive) {
		g.setColor(color);
		if(shape == "DOT") {
			g.fillRect(x, y, width, height);
		}
		
		else if(shape == "CIRCLE") {
			if(alive) {
				g.fillOval(x, y, width, height);
			}else {
				g.drawOval(x, y, width, height);
			}
		}
		
		else if(shape == "4STAR") {
			g.fillPolygon(fourPointedStar(x, y, width, height));
		}
		
		else if(shape.indexOf("GEOM") >= 0) {
			g.fillPolygon(geometric(shape, x, y, width, height));
		}
		
		else if(shape == "WIEBE") {
			g.setFont(new Font("Courier", Font.ITALIC, height));
			if(alive) {
				g.drawString("Wiebe", x, y + height - 2);
			}
			else {
				g.setColor(Color.WHITE);
				g.fillRect(x, y, width, height);
			}
		}
		
		else if(shape == "DIEGO") {
			g.fill3DRect(x, y, width, height, true);
		}
	}
	private Polygon fourPointedStar(int x, int y, int width, int height) {
		int[] xCoords = new int[] {x + width, x + (int)((6 * width) / 10), x + (int)(width / 2), 
				x + (int)((4 * width) / 10), x, x + (int)((4 * width) / 10), x + (int)(width / 2), 
				x + (int)((6 * width) / 10)};
		int[] yCoords = new int[] {y + (int)(height / 2), y + (int)((4 * height) / 10), y, 
				y + (int)((4 * height) / 10), y + (int)(height / 2), y + (int)((6 * height) / 10), 
				y + height, y + (int)((6 * height) / 10)};
		return new Polygon(xCoords, yCoords, 8);
	}
	private Polygon geometric(String version, int x, int y, int width, int height) {
		int[] xCoords = new int[0];
		int[] yCoords = new int[0];
		int points = 0;
		if(version == "GEOM1") {
			xCoords = new int[] {x, x + width, x + (int)(width / 3), x + width, x};
			yCoords = new int[] {y, y, y + (int)(width / 2), y + height, y + height};
			points = 5;
		}
		return new Polygon(xCoords, yCoords, points);
	}
	
	public void resetGame() {
		alive = true;
		alivePlayers.clear();
		deadPlayers.clear();
	}
}
