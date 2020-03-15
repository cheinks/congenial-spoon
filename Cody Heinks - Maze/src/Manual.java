import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

public class Manual {
	
	//values for the game window
	public static final int windowX = 0;
	public static final int windowY = 0;
	private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int windowWidth = gd.getDisplayMode().getWidth();
	public static final int windowHeight = gd.getDisplayMode().getHeight();
	
	public static final int bufferX = 6;
	public static final int bufferY = 35;
	
	//values for the maze u.i.
	public static final Color color1 = Color.WHITE; //outside the border
	public static final Color color2 = Color.BLACK; //the border
	public static final Color color3 = Color.WHITE; //inside the border
	
	public static final int thick1 = 3; //exterior
	public static final int thick2 = 5; //border
	
	//values for the runner
	private static Point p = new Point(thick1 + thick2, thick1 + thick2);
	private static Dimension d = new Dimension(windowWidth - bufferX - 2 * (p.x), windowHeight - bufferY - 2 * (p.y));
	public static final Rectangle bounds = new Rectangle(p, d);
	
	//color loop
	private static int r = 255;
	private static int g = 0;
	private static int b = 0;
	public static Color nextColor() {
		g++;

		
		return new Color(r, g, b);
	}
}
