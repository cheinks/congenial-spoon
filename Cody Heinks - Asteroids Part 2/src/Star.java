import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Star extends Sprite{

	private Rectangle rect;
	
	public Star(Point p, int width, int height) {
		super(p, width, height);
		
		rect = new Rectangle(p.x, p.y, width, height);
	}
	
	//Access
	
	@Override
	public Rectangle getRect() {return rect;}
	public Polygon getFlicker() {
		int[] xPoints = new int[]{rect.x + 2, rect.x, rect.x - 2, rect.x};
		int[] yPoints = new int[] {rect.y, rect.y - 2, rect.y, rect.y + 2};
		return new Polygon(xPoints, yPoints, 4);
	}

}
