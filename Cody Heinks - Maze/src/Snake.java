import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class Snake extends Player{
	
	private Rectangle rect;
	private int dx;
	private int dy;
	
	private double heading; //0 is +x, pi/2 is +y, pi is -x, 3pi/2 is -y
	private int speed;
	private int interval; //number of moves before trying to change direction
	private int current = 0;
	
	private Point destination = new Point(450, 450);
	
	public Snake(Color c, int x, int y, int size, int speed, int i) {
		super(c, x, y, size);
		
		rect = new Rectangle(x, y, size, size);
		
		this.speed = speed;
		this.interval = i;
		
		changeDirection();
	}
	
	private void changeDirection() {
		
		heading = newHeading(destination);
		
		dx = (int)(speed * Math.cos(heading));
		dy = (int)(speed * Math.sin(heading));
	}
	
	//a random direction
	private double newHeading() {
		return (int)(4 * Math.random()) * (Math.PI * 0.5);
	}
	//the optimal change in direction to get to point p (non-diagonal movement)
	private double newHeading(Point p) {
		double newHead = 0;
		int deltaX = p.x - rect.x; //negative means go to the left
		int deltaY = p.y - rect.y; //negative means go up
		
		if(Math.abs(deltaX) >= Math.abs(deltaY)) {
			if(deltaX < 0) {
				newHead = Math.PI;
			}
		}else {
			if(deltaY < 0) {
				newHead = 3 * Math.PI * 0.5;
			}else {
				newHead = Math.PI * 0.5;
			}
		}
		
		return newHead;
	}
	
	@Override
	public void move() {
		rect.translate(dx, dy);
		
		current++;
		if(current >= interval) {
			current = 0;
			changeDirection();
		}
	}
	
	@Override
	public Rectangle getRect() { return rect; }
	@Override
	public int getDX() { return dx; }
	@Override
	public int getDY() { return dy; }

}
