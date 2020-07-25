import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Manual {
	
	//Variables
	
	public static final int delay = 17; //(1000 / fps) = appropriate milliseconds per frame delay
	
	//The game area
	private static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int screenWidth = gd.getDisplayMode().getWidth();
	public static final int screenHeight = gd.getDisplayMode().getHeight();
	public static final int gameWidth = screenWidth;//the largest possible play area
	public static final int gameHeight = screenHeight;
	
	//Background
	public static final double minStarFreq = 0.00001;
	public static final double maxStarFreq = 0.00005;
	public static final Color starCol = new Color(191, 234, 255);
	
	//Player balancing
	public static final int playerWidth = 24;
	public static final int playerHeight = 36;
	public static final double[][] playerValues = new double[][] {
		{Math.PI / 42, 0.25, 5}, 
		{Math.PI / 42, 0.25, 6}, 
		{Math.PI / 40, 0.275, 6},
		{Math.PI / 40, 0.3, 7},
		{Math.PI / 38, 0.325, 7},
		{Math.PI / 38, 0.35, 8},
		{Math.PI / 36, 0.375, 8},
		{Math.PI / 36, 0.4, 8},
		{Math.PI / 32, 0.5, 10}};
	public static final Color[] rankColors = new Color[] {Color.white, Color.yellow, Color.orange, Color.green, 
			Color.cyan, Color.blue, Color.red, Color.magenta};
	
	//Asteroid balancing
	public static final int minPoints = 16;
	public static final int maxPoints = 20;
	public static final int maxAstVel = 5;
	
	//HUD
	public static final Font radioFont = new Font(null, Font.PLAIN, 50);
	public static final int radioTextSpeed = 12;
	
	//Methods
	
	public static int randInt(int min, int max) { //(inclusive, inclusive)
		return min + (int)(Math.random()*(max - min + 1));
	}
	
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
	
	public static Polygon newIsoTriang(Rectangle r) {
		int x1 = r.x + (r.width / 2); //the apex
		int y1 = r.y;
		
		int x2 = r.x; //the bottom left
		int y2 = r.y + r.height;
		
		int x3 = r.x + r.width; //the bottom right
		int y3 = r.y + r.height;
		
		return new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
	}
	
	public static Polygon newAsteroid(int minSize, int maxSize) {
		Polygon poly = new Polygon();
		int points = randInt(minPoints, maxPoints);
		double d0 = 2*Math.PI / (double)points;
		double theta = Math.random() * 2*Math.PI;
		
		for(int i = 0; i < points; i++) {
			int radius = randInt(minSize, maxSize);
			poly.addPoint((int)(radius*Math.cos(theta)), (int)(radius*Math.sin(theta)));
			theta += d0;
		}
		
		return poly;
	}
	
	public static ArrayList<Star> starArray(Rectangle bounds, double frequency){
		ArrayList<Star> stars = new ArrayList<Star>();
		int numStars = (int)(bounds.width * bounds.height * frequency);
		for(int i = 0; i < numStars; i++) {
			Point p = new Point();
			double x = Math.random() * bounds.width;
			double y = Math.random() * bounds.height;
			p.setLocation(x, y);
			
			stars.add(new Star(p, 1, 1));
		}
		return stars;
	}
}
