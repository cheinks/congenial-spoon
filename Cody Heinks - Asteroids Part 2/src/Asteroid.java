import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Asteroid extends Sprite{
	
	private Rectangle rect;
	private Polygon poly;
	
	private boolean exist = true;
	
	private int dx;
	private int dy;

	public Asteroid(Point p, Rectangle bounds, Polygon poly) {
		super(p, bounds.width, bounds.height);
		rect = bounds;
		rect.translate(p.x, p.y);
		this.poly = poly;
		this.poly.translate(p.x, p.y);
		
		dx = Manual.randInt(-Manual.maxAstVel, Manual.maxAstVel);
		dy = Manual.randInt(-Manual.maxAstVel, Manual.maxAstVel);
	}
	
	public void move() {
		poly.translate(dx, dy);
		rect.translate(dx, dy);
	}
	
	//Access
	@Override
	public Rectangle getRect() {return rect;}
	public Polygon getPoly() {return poly;}
	public boolean getExist() {return exist;}
}
