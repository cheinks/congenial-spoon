import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends Sprite{
	
	private Rectangle rect;
	
	private Polygon poly;
	private double accel; //pixels per frame per frame
	private double maxSpeed;
	private double angularSpeed;
	
	private double d0 = 0; //the change in angular position (in pixels) every frame
	private double heading = 3*Math.PI*0.5; //0 is right, 90 is down, 180 is left, 270 is up
	private boolean left = false;
	private boolean right = false;
	
	private boolean boost = false;
	private double dx; //the resulting change in position (in pixels) every frame
	private double dy;

	public Player(Point p, int width, int height) {
		super(p, width, height);
		rect = new Rectangle(p.x, p.y, width, height);
		
		poly = Manual.newIsoTriang(rect);
		accel = 1; //temporary
		maxSpeed = 0; //temporary
		angularSpeed = Math.PI / 12;
	}
	
	public void action(boolean keyDown, int key) {
		if(keyDown) {
			if(key == KeyEvent.VK_W) {
				boost = true;
			}
			else if(key == KeyEvent.VK_A && !left) {
				d0 += -angularSpeed;
				left = true;
			}
			else if(key == KeyEvent.VK_D && !right) {
				d0 += angularSpeed;
				right = true;
			}
		}
		else {
			if(key == KeyEvent.VK_W) {
				boost = false;
			}
			else if(key == KeyEvent.VK_A && left) {
				d0 -= -angularSpeed;
				left = false;
			}
			else if(key == KeyEvent.VK_D && right) {
				d0 -= angularSpeed;
				right = false;
			}
		}
	}
	
	public void move() {
		heading += d0;
		if(heading >= 2*Math.PI) {heading -= 2*Math.PI;}
		
		Point center = Manual.equidistant(poly);
		Polygon newPoly = new Polygon();
		for(int i = 0; i < poly.npoints; i++) {
			Point a = new Point(poly.xpoints[i], poly.ypoints[i]);
			Point b = Manual.rotate(center, a, d0);
			newPoly.addPoint(b.x, b.y);
		}
		poly = newPoly;
		rect = newPoly.getBounds();
		
	}
	
	//Access
	public Rectangle getRect() {return rect;}
	
	public Polygon getPoly() {return poly;}
	
	//Mutate
	
	

}
