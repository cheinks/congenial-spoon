import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

/* This class stores predetermined values to be used by elements of the game. */

public class Manual {
	
	//values for the game window
	public static final int windowX = 0;
	public static final int windowY = 0;
	//private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	//public static final int windowWidth = gd.getDisplayMode().getWidth();
	//public static final int windowHeight = gd.getDisplayMode().getHeight();
	public static final int windowWidth = 500;
	public static final int windowHeight = 500;
	
	public static final int bufferX = 6; //space for the panel to exist within the frame
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
	
	public static final Point start = new Point(50, 50);
	public static final int playerSize = 25;
	public static final int playerSpeed = 6;
	
}
