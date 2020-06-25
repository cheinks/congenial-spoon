import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends Sprite{
	
	private Rectangle rect;
	
	private Polygon poly;
	private Point center;
	private double[] heading = new double[3]; //0 is right, pi/2 is down, pi is left, 3pi/2 is up
	private double[] radii = new double[3]; //
	
	private double d0 = 0; //the change in angular position (in pixels) every frame
	private double angularSpeed;
	private boolean left = false; //eliminates angular acceleration
	private boolean right = false;
	
	private double speed = 0; //pixels per frame
	private double accel; //pixels per frame per frame
	private double maxSpeed;
	private boolean boost = false;

	public Player(Point p, int width, int height) {
		super(p, width, height);
		rect = new Rectangle(p.x, p.y, width, height);
		
		poly = Manual.newIsoTriang(rect);
		calculate();
		
		accel = 1; //temporary
		maxSpeed = 2; //temporary
		angularSpeed = Math.PI / 20;
	}
	
	public void action(boolean keyDown, int key) {
		if(keyDown) {
			if(key == KeyEvent.VK_W && !boost) {
				speed += accel;
				if(speed > maxSpeed) {
					boost = true;
				}
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
		if(d0 != 0) {
			Polygon newPoly = new Polygon();
			
			for(int i = 0; i < poly.npoints; i++) {
				heading[i] += d0;
				double x = radii[i] * Math.cos(heading[i]) + center.getX();
				double y = radii[i] * Math.sin(heading[i]) + center.getY();
				newPoly.addPoint((int)x, (int)y);
			}
			
			poly = newPoly;
			rect = newPoly.getBounds(); //obligatory
		}
		
		if(speed != 0) {
			double dx = speed * Math.cos(heading[0]);
			double dy = speed * Math.sin(heading[0]);
			poly.translate((int)dx, (int)dy);
			center.translate((int)dx, (int)dy);
		}
		
	}
	
	private void calculate() {
		center = Manual.equidistant(poly);
		for(int i = 0; i < poly.npoints; i++) { //the distance between the center and each vertex
			radii[i] = Math.hypot(center.getX() - poly.xpoints[i], center.getY() - poly.ypoints[i]);
		}
		
		heading[0] = 3*Math.PI*0.5;
		heading[1] = Math.PI*0.5 + Math.atan((0.5 * rect.getWidth()) / ((double)poly.ypoints[1] - center.getY()));
		heading[2] = Math.atan(((double)poly.ypoints[2] - center.getY()) / (0.5 * rect.getWidth()));
	}
	
	//Access
	public Rectangle getRect() {return rect;}
	
	public Polygon getPoly() {return poly;}
	
	//Mutate
	
	

}
