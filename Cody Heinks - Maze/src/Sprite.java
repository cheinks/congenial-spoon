import java.awt.Color;
import java.awt.Rectangle;

public abstract class Sprite {

	private Color color;
	private Rectangle rect;
	
	public Sprite(Color c, int x, int y, int size) {
		color = c;
		rect = new Rectangle(x, y, size, size);
	}
	
	public Color getColor() { return color; }
	public Rectangle getRect() { return rect; }

}
