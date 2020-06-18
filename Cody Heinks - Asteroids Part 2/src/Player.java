import java.awt.Polygon;
import java.awt.Rectangle;

public class Player extends Sprite{
	
	private Rectangle rect;
	
	private Polygon poly; //triangle for now
	 

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		rect = new Rectangle(x, y, width, height);
		
		poly = Manual.newIsoTriang(rect);
	}
	
	//Access
	public Rectangle getRect() {return rect;}
	
	public Polygon getPoly() {return poly;}
	
	//Mutate
	
	

}
