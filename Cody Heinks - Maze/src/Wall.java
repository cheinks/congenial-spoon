import java.awt.Color;
import java.awt.Rectangle;

public class Wall extends Sprite{

	private Rectangle rect;
	
	public Wall(Color c, int x, int y, int size) {
		super(c, x, y, size);
		
		rect = new Rectangle(x, y, size, size);
	}

	@Override
	public Rectangle getRect() { return rect; }

}
