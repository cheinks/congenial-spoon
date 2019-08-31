package animationProject;

import java.awt.*;
import javax.swing.*;

public class Player {
	
	private Field currentField;
	private int playerID;
	
	private int xCoord;
	private int yCoord;
	private int xVel;
//	Negative velocity is up, positive velocity is down
	private int yVel;
	
	private String shape;
	private Color color;
	private int size;
	private int width;
	private int height;
	
	private boolean alive;
	
	public Player(int playerID, int[] startCoords, int xVel, int yVel, String shape, int size, Color color, boolean alive) {
		this.playerID = playerID;
		xCoord = startCoords[0];
		yCoord = startCoords[1];
		this.xVel = xVel;
		this.yVel = yVel;
		
		this.shape = shape;
		this.size = size;
		if(shape == "DOT") {
			width = size;
			height = size;
		}
		this.color = color;
		
		this.alive = alive;
		if(!this.alive) {
			this.color = getTrailColor(color);
		}
	}
	public void setField(Field field) {currentField = field;}
	public int getID() {return playerID;}
	
	public int getX() {return xCoord;}
	public int getY() {return yCoord;}
	
	public int getXVel() {return xVel;}
	public void newXVel(int newVel) {xVel = newVel;}
	public int getYVel() {return yVel;}
	public void newYVel(int newVel) {yVel = newVel;}
	
	public String getShape() {return shape;}
	public Color getColor() {return color;}
	public Color getTrailColor(Color base) {
		int red = base.getRed();
		int green = base.getGreen();
		int blue = base.getBlue();
//		return new Color(red, green, blue, (int)(base.getAlpha()*0.45));
		
		red += 37;
		green += 37;
		blue += 37;
		if(red > 255) {red = 255;}
		if(green > 255) {green = 255;}
		if(blue > 255) {blue = 255;}
		return new Color(red, green, blue);
	}
	
	public int getSize() {return size;}
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	public boolean isAlive() {return alive;}
	public void kill() {
		alive = false;
		Color newColor = getTrailColor(color);
		color = newColor;
	}
	
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
		return new int[]{currentField.getYUpper(), currentField.getYLower(), 
				currentField.getXUpper(), currentField.getXLower()};
	}
	
	public boolean collidesWith(Player player) {
		int otherPlayerID = player.getID();
		if(otherPlayerID == this.playerID) {return false;}
		int playerX = player.getX();
		int playerY = player.getY();
		int playerWidth = player.getWidth();
		int playerHeight = player.getHeight();
		
		if(xCoord >= playerX && xCoord <= playerX + playerWidth) {
			if(yCoord >= playerY && yCoord <= playerY + playerHeight) {
				return true;
			}
		}
		return false;
	}
}
