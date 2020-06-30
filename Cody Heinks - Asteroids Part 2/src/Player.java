import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player extends Sprite{
	
	private Rectangle rect;
	private int rank;
	
	private Polygon poly;
	private Point center;
	private double[] heading = new double[3]; //0 is right, pi/2 is down, pi is left, 3pi/2 is up
	private double[] radii = new double[3]; //distance from center to each vertex
	
	private double d0 = 0; //the change in angular position (in pixels) every frame
	private boolean left = false; //eliminates angular acceleration
	private boolean right = false;
	private double angularSpeed;
	
	private double dx = 0;
	private double dy = 0;
	private boolean boost = false;
	private double accel; //pixels per frame per frame
	private double maxSpeed;

	public Player(Point p, int width, int height, int lvl) {
		super(p, width, height);
		rect = new Rectangle(p.x, p.y, width, height);
		
		poly = Manual.newIsoTriang(rect);
		calculate();
		rank = lvl;
		
		angularSpeed = Manual.playerValues[rank][0];
		accel = Manual.playerValues[rank][1];
		maxSpeed = Manual.playerValues[rank][2];
	}
	
	public void action(boolean keyDown, int key) {
		if(keyDown) {
			if(key == KeyEvent.VK_W && !boost) {
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
		if(d0 != 0) {rotate();}
		if(boost) {translate();}
		
		poly.translate((int)dx, (int)dy); //Move both the polygon and the center by the same amount 
		rect.translate((int)dx, (int)dy);
		center.translate((int)dx, (int)dy); //to keep everything in-line.
	}
	
	/*
	 * Calculates the radius and starting angle of each vertex.
	 */
	private void calculate() {
		center = Manual.equidistant(poly);
		for(int i = 0; i < poly.npoints; i++) { //the distance between the center and each vertex
			radii[i] = Math.hypot(center.getX() - poly.xpoints[i], center.getY() - poly.ypoints[i]);
		}
		
		heading[0] = 3*Math.PI*0.5;
		heading[1] = Math.PI*0.5 + Math.atan((0.5 * rect.getWidth()) / ((double)poly.ypoints[1] - center.getY()));
		heading[2] = Math.atan(((double)poly.ypoints[2] - center.getY()) / (0.5 * rect.getWidth()));
	}
	
	/*
	 * Creates a new Polygon that is a copy of 'poly' rotated 
	 * 'd0' radians about the point 'center'.
	 */
	private void rotate() {
		Polygon newPoly = new Polygon();
		for(int i = 0; i < poly.npoints; i++) {
			heading[i] += d0;
			double x = radii[i] * Math.cos(heading[i]) + center.getX();
			double y = radii[i] * Math.sin(heading[i]) + center.getY();
			newPoly.addPoint((int)x, (int)y);
		}
		poly = newPoly;
	}
	/*
	 * Determines the appropriate change in x and y velocity 
	 * given the main heading and the acceleration.
	 */
	private void translate() {
		dx += accel * Math.cos(heading[0]);
		dy += accel * Math.sin(heading[0]);
		
		if(Math.abs(dx) > maxSpeed) {dx = Math.signum(dx) * maxSpeed;}
		if(Math.abs(dy) > maxSpeed) {dy = Math.signum(dy) * maxSpeed;}
	}
	
	//Access
	@Override
	public Rectangle getRect() {return rect;}
	public Polygon getPoly() {return poly;}
	public int getX() {return rect.x;}
	public int getY() {return rect.y;}
	public int getRank() {return rank;}
}
