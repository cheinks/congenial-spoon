import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;

import java.util.ArrayList;

/* This class is the main character of the 
 * game and is controlled by the user. 
 * */

public class Runner extends Player{
	
	private Rectangle rect;
	private int dx; //(+) is to the right, (-) is to the left
	private int dy; //(+) is downwards, (-) is upwards
	
	//values for movement
	private int speed;
	private boolean up; //true if the object is moving upwards
	private boolean down;
	private boolean left;
	private boolean right;
	
	private ArrayList<Wall> walls; //the barriers

	public Runner(Color c, int x, int y, int size, int speed, ArrayList<Wall> w) {
		super(c, x, y, size);
		
		rect = new Rectangle(x, y, size, size);
		this.speed = speed;
		walls = w;
	}
	
	//Called when a user input is given via the keyboard
	public void action(boolean keyDown, int key) {
		if(keyDown) { //Increments the dx or dy value
			if(key == KeyEvent.VK_W && !up) {
				dy -= speed;
				up = true;
			}
			else if(key == KeyEvent.VK_S && !down) { 
				dy += speed;
				down = true;
			}
			else if(key == KeyEvent.VK_A && !left) { 
				dx -= speed;
				left = true;
			}
			else if(key == KeyEvent.VK_D && !right) { 
				dx += speed;
				right = true;
			}
		} else { //Resets the dx or dy value
			if(key == KeyEvent.VK_W && up) { 
				dy += speed;
				up = false;
			}
			else if(key == KeyEvent.VK_S && down) { 
				dy -= speed;
				down = false;
			}
			else if(key == KeyEvent.VK_A && left) { 
				dx += speed;
				left = false;
			}
			else if(key == KeyEvent.VK_D && right) { 
				dx -= speed;
				right = false;
			}
		}
	}
	
	@Override
	public void move() {
		rect.translate(dx, dy);
		checkCollisions();
		
	}
	
	//Computes the collision of the runner with bounds and walls
	private void checkCollisions() {
		if(!Manual.bounds.contains(rect)) { //if the player is outside the bounds, move it back in
			Rectangle u = Manual.bounds.union(rect);
			rect.translate((int)(Math.signum(dx)) * (Manual.bounds.width - u.width), (int)(Math.signum(dy)) * (Manual.bounds.height - u.height));
		}
		
		for(Wall w : walls) {
			Rectangle wRect = w.getRect(); //the space of the wall
			Point wCenter = new Point(wRect.x + (wRect.width / 2), wRect.y + (wRect.height / 2));
			
			if(wRect.intersects(rect)){
				Rectangle i = wRect.intersection(rect); //the overlap
				int idx = 0; //the value to correct the player's movement
				int idy = 0;
				int iWidth = i.width;
				int iHeight = i.height;
				
				//whatever axis is shorter, move it back that way
				//if that axis is zero, use the other axis.
				if(iWidth < iHeight || dy == 0) {
					idx = (int)(Math.signum(dx)) * -iWidth;
				}else if(iHeight < iWidth || dx == 0) {
					idy = (int)(Math.signum(dy)) * -iHeight;
				}else { //if width = height, move the player diagonally away from the corner of the wall
					idx = (int)(Math.signum(wCenter.x - i.x)) * -iWidth;
					idy = (int)(Math.signum(wCenter.y - i.y)) * -iHeight;
				}
				
				//if the object were to move again in the same direction
//				Rectangle futureRect = new Rectangle(rect.x + dx, rect.y + dy, rect.width, rect.height);
//				Rectangle futureI = wRect.intersection(futureRect);
//				
//				//will be false if the object is moving parallel to its axis of collision
//				if(futureI.width > i.width) { idx = (int)(Math.signum(dx)) * -i.width; }
//				if(futureI.height > i.height) { idy = (int)(Math.signum(dy)) * -i.height; }
				
				rect.translate(idx, idy);
			}
		}
	}
	
	@Override
	public Rectangle getRect() { return rect; }
	@Override
	public int getDX() { return dx; }
	@Override
	public int getDY() { return dy; }

}
