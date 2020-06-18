import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Manual {
	
	//Variables
	
	private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	//the total game area (screen size)
	public static final int screenWidth = gd.getDisplayMode().getWidth();
	public static final int screenHeight = gd.getDisplayMode().getHeight();
	
	public static final int playerWidth = 20;
	public static final int playerHeight = 30;
	
	//Methods
	
	public static Point fakeMiddle(int w, int h, Rectangle r) { //r1 must be smaller than r2
		Point p = new Point();
		int x = (r.width / 2) - (w / 2) + r.x;
		int y = (r.height / 2) - (h / 2) + r.y;
		
		p.setLocation(x, y);
		return p;
	}
		
	public static Polygon newIsoTriang(Rectangle r) {
		int x1 = r.x + (r.width / 2); //the apex
		int y1 = r.y;
		
		int x2 = r.x; //the bottom left
		int y2 = r.y + r.height;
		
		int x3 = r.x + r.width; //the bottom right
		int y3 = r.y + r.height;
		
		return new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
	}

}
