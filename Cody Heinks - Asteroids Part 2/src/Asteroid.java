import java.awt.Point;
import java.awt.Rectangle;

public class Asteroid extends Sprite{
	
	private Rectangle rect;
	
	private boolean exist = true;
	
	private int dx;
	private int dy;

	public Asteroid(Point p, int width, int height) {
		super(p, width, height);
		rect = new Rectangle(p.x, p.y, width, height);
		
		dx = Manual.randInt(-5, 5);
		dy = Manual.randInt(-5, 5);
	}
	
	public void move() {
		rect.translate(dx, dy);
	}
	
	//Access
	@Override
	public Rectangle getRect() {return rect;}
	public boolean getExist() {return exist;}
}
