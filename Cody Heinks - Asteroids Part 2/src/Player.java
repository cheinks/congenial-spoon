import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Player extends Sprite{
	
	private Rectangle rect;
	
	private Polygon poly;
	 

	public Player(Point p, int width, int height) {
		super(p, width, height);
		rect = new Rectangle(p.x, p.y, width, height);
		
		poly = Manual.newIsoTriang(rect);
	}
	
	//Access
	public Rectangle getRect() {return rect;}
	
	public Polygon getPoly() {return poly;}
	
	//Mutate
	
	

}
