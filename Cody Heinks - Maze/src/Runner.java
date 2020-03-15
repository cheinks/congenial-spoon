import java.awt.Color;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;

public class Runner{
	
	private Color color;
	
	private Rectangle rect;
	private int speed = 0;
	private int dx = 0;
	private int dy = 0;
	
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	public Runner(Color c, int x, int y, int size, int speed) {
		color = c;
		rect = new Rectangle(x, y, size, size);
		this.speed = speed;
	}
	
	public void action(boolean keyDown, int key) {
		if(keyDown) {
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
		} else {
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
	
	public void move() {
		rect.translate(dx, dy);
		if(!Manual.bounds.contains(rect)) {
			Rectangle u = Manual.bounds.union(rect);
			rect.translate((int)(Math.signum(dx)) * (Manual.bounds.width - u.width), (int)(Math.signum(dy)) * (Manual.bounds.height - u.height));
		}
	}
	
	public Color getColor() {return color;}
	public Rectangle getRect() {return rect;}

}
