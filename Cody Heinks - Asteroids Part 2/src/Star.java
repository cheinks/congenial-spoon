import java.awt.Point;
import java.awt.Rectangle;

public class Star extends Sprite{

	private Rectangle rect;
	
	public Star(Point p, int width, int height) {
		super(p, width, height);
		
		rect = new Rectangle(p.x, p.y, width, height);
	}
	
	//Access
	
	public Rectangle getRect() {return rect;}

}
