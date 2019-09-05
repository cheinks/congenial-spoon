package animationProject;

import java.awt.Color;
import java.awt.Rectangle;

public class Player {
	
// --- Class Variables ---
	
	private Field currentField;
	private int playerID;
	
	private int xCoord;
	private int yCoord;
	private int xVel;
	private int yVel; //(-) velocity is up, (+) velocity is down
	
	private String shape;
	private Color headColor;
	private Color trailColor;
	private int size;
	private int width;
	private int height;
	
	private boolean alive;

// --- Constructor ---
	
	public Player(int playerID, int[] startCoords, int xVel, int yVel, 
			String shape, int size, Color color, boolean alive) {
		this.playerID = playerID;
		
		xCoord = startCoords[0];
		yCoord = startCoords[1];
		this.xVel = xVel;
		this.yVel = yVel;
		
		this.shape = shape;
		this.size = size;
		width = this.size;
		height = this.size;
		if(this.shape == "WIEBE") {width *= 3;}
		
		trailColor = color;
		headColor = GameRunner.makeHeadColor(trailColor);
		
		this.alive = alive;
	}

// --- Accessor / Mutator Methods ---
	
	public void setField(Field field) {currentField = field;}
	public void setWinID(int i) {playerID = i;}
	public int getID() {return playerID;}
	
	public int getX() {return xCoord;}
	public int getY() {return yCoord;}
	public int getXVel() {return xVel;}
	public void newXVel(int newVel) {xVel = newVel;}
	public int getYVel() {return yVel;}
	public void newYVel(int newVel) {yVel = newVel;}
	
	public String getShape() {return shape;}
	public Color getHeadColor() {return headColor;}
	public Color getTrailColor() {return trailColor;}
	public int getSize() {return size;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public boolean isAlive() {return alive;}
	public void kill() {alive = false;}
	
// --- Other Class Methods ---
	
	public void moveSelf() {
		xCoord += xVel;
		yCoord += yVel;
	}
	
	/*
	 * Keeps the players within the rectangular bounds of the field. Inverts their
	 * x and y velocities once they reach a bound.
	 */
	public void checkBounds(){
		int[] bounds = getBounds();
		//Ceiling
		if(yCoord < bounds[0]) {
			yCoord = bounds[0];
			yVel *= -1;
		}
		//Floor
		else if(yCoord + height > bounds[1]) {
			yCoord = bounds[1] - height;
			yVel *= -1;
		}
		//Left Wall
		else if(xCoord < bounds[2]) {
			xCoord = bounds[2];
			xVel *= -1;
		}
		//Right Wall
		else if(xCoord + width > bounds[3]) {
			xCoord = bounds[3] - width;
			xVel *= -1;
		}
	}
	private int[] getBounds() {
		return new int[]{currentField.getYUpper(), currentField.getYLower(), 
				currentField.getXUpper(), currentField.getXLower()};
	}
	
	//Collision Detection
	/*
	 * Generates two rectangles using the x and y coordinates, 
	 * width, and height of two different players. Determines if
	 * the rectangles have intersected.
	 */
	public boolean collidesWith(Player player) {
		if(GameRunner.getInvincible()) {return false;}
		int otherPlayerID = player.getID();
		if(otherPlayerID == this.playerID) {return false;}
		
		Rectangle rect = new Rectangle(xCoord, yCoord, width, height);
		Rectangle otherRect = new Rectangle(player.getX(), player.getY(), 
				player.getWidth(), player.getHeight());
		return rect.intersects(otherRect);
	}
}
