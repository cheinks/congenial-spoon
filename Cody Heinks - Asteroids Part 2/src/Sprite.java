import java.awt.Rectangle;

public abstract class Sprite {

	private Rectangle rect;
	
	public Sprite(int x, int y, int width, int height) {
		
		rect = new Rectangle(x, y, width, height);
	}
	
	//Access
	public Rectangle getRect() { return rect; }

}
