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
	
	public static Point fakeMiddle(int w, int h, Rectangle r) { //the "magnetic center" of rectangle r, given w and h 
		Point p = new Point();
		int x = (r.width / 2) - (w / 2) + r.x;
		int y = (r.height / 2) - (h / 2) + r.y;
		
		p.setLocation(x, y);
		return p;
	}
	
	public static Point equidistant(Polygon poly) {
		Point o = new Point();
		double x = 0;
		double y = 0;
		
		for(int i = 0; i < poly.npoints; i++) {
			x += poly.xpoints[i];
			y += poly.ypoints[i];
		}
		
		x /= poly.npoints;
		y /= poly.npoints;
		o.setLocation(x, y);
		return o;
	}
	/*
	 * Returns a Point that gives the position of 'a' after being 
	 * rotated 'rotation' radians around 'center'.
	 */
	public static Point rotate(Point center, Point a, double rotation) {
		double radius;
		double i0 = 0;
		double f0 = 0;
		Point b = new Point();
		
		//calculate the radius
		radius = Math.sqrt(Math.pow(Math.abs(center.getX() - a.getX()), 2) + 
				Math.pow(Math.abs(center.getY() - a.getY()), 2));
		
		//determine the quadrant, then determine the initial angular displacement
		if(a.x > center.x && a.y <= center.y) { //quadrant 1
			double tan = (center.getY() - a.getY()) / (a.getX() - center.getX());
			i0 = 2*Math.PI - Math.atan(tan);
		}
		else if(a.x == center.x && a.y < center.y) {
			i0 = 3*Math.PI*0.5;
		}
		else if(a.x < center.x && a.y < center.y) {//quadrant 2
			double tan = (center.getX() - a.getX()) / (center.getY() - a.getY());
			i0 = 3*Math.PI*0.5 - Math.atan(tan);
		}
		else if(a.x < center.x && a.y == center.y) {
			i0 = Math.PI;
		}
		else if(a.x <= center.x && a.y > center.y) {//quadrant 3
			double tan = (center.getX() - a.getX()) / (a.getY() - center.getY());
			i0 = Math.PI*0.5 + Math.atan(tan);
		}
		else if(a.x > center.x && a.y > center.y) {
			double tan = (a.getY() - center.getY()) / (a.getX() - center.getX());
			i0 = Math.atan(tan);
		}
		
		//find the new angle given the rotation (a positive rotation is clockwise)
		f0 = i0 + rotation;
		
		//calculate the coordinates of the new locations
		double x = center.getX() + radius*Math.cos(f0);
		double y = center.getY() + radius*Math.sin(f0);
		b.setLocation(x, y);
		return b;
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
