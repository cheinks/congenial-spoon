import java.awt.Color;
import java.awt.Rectangle;

/* This is the basis for every sprite that can move. */

public abstract class Player extends Sprite {

	private Rectangle rect;
	
	//the current values for velocity
	private int dx;
	private int dy;
	
	public Player(Color c, int x, int y, int size) {
		super(c, x, y, size);
		
		//redefine the 'rect' context
		rect = new Rectangle(x, y, size, size);
	}
	
	//change the sprite's position
	public void move() { rect.translate(dx, dy); }
	public void move(int xDist, int yDist) { rect.translate(xDist, yDist); }
	
	//Accessor
	@Override
	public Rectangle getRect() { return rect; }
	
	public int getDX() { return dx; }
	public int getDY() { return dy; }

}
