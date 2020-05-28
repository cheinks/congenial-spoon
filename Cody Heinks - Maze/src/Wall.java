import java.awt.Color;
import java.awt.Rectangle;

public class Wall extends Sprite{

	private Rectangle rect;
	
	public Wall(Color c, int x, int y, int size, char plane, int length) {
		super(c, x, y, size);
		
		if(plane == 'x') {
			rect = new Rectangle(x, y, length, size);
		}else if(plane == 'y') {
			rect = new Rectangle(x, y, size, length);
		}else {
			rect = new Rectangle(x, y, size, size);
		}
	}

	@Override
	public Rectangle getRect() { return rect; }

}
