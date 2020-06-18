import java.awt.Point;
import java.awt.Rectangle;

public abstract class Sprite {

	private Rectangle rect;
	
	public Sprite(Point p, int width, int height) {
		
		rect = new Rectangle(p.x, p.y, width, height);
	}
	
	//Access
	public Rectangle getRect() { return rect; }

}
