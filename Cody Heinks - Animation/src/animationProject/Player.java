package animationProject;

import javax.swing.*;
import java.awt.*;

public class Player {
	
	private Field currentField;
	
	private int xCoord;
	private int yCoord;
	private int xVel;
//	Negative velocity is up, positive velocity is down
	private int yVel;
	
	private String shape;
	private Color color = Color.MAGENTA;
	private int width;
	private int height;
	
	private boolean alive;
	
	public Player(int[] startCoords, int xVel, int yVel, String shape, boolean alive) {
		xCoord = startCoords[0];
		yCoord = startCoords[1];
		this.xVel = xVel;
		this.yVel = yVel;
		
		this.shape = shape;
		width = 6;
		height = 6;
		this.alive = alive;
		
		if(!this.alive) {
			color = Color.PINK;
		}
	}
	public void setField(Field field) {currentField = field;}
	
	public int getX() {return xCoord;}
	public int getY() {return yCoord;}
	
	public int getXVel() {return xVel;}
	public void newXVel(int newVel) {xVel = newVel;}
	public int getYVel() {return yVel;}
	public void newYVel(int newVel) {yVel = newVel;}
	
	public String getShape() {return shape;}
	public Color getColor() {return color;}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public boolean isAlive() {return alive;}
	public void kill() {alive = false;}
	
	public void moveSelf() {
		xCoord += xVel;
		yCoord += yVel;
	}
	
	public void checkBounds(){
		int[] bounds = getBounds();
		//Top
		if(yCoord < bounds[0]) {
			yCoord = bounds[0];
			yVel*=-1;
			
		}
		//Bottom
		if(yCoord + height > bounds[1]) {
			yCoord = bounds[1] - height;
			yVel*=-1;
		}
		//Left
		if(xCoord < bounds[2]) {
			xCoord = bounds[2];
			xVel*=-1;
		}
		//Right
		if(xCoord + width > bounds[3]) {
			xCoord = bounds[3] - width;
			xVel*=-1;
		}
	}
	
	private int[] getBounds() {
		return new int[]{currentField.getYUpper(), currentField.getYLower(), currentField.getXUpper(), currentField.getXLower()};
	}
}
