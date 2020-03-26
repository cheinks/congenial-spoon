import java.awt.Color;
import java.awt.Rectangle;

public class Snake {
	
	private Color color;
	
	private Rectangle rect;
	private double heading; //0 is +x, pi/2 is +y, pi is -x, 3pi/2 is -y
	private int dx;
	private int dy;
	
	private int size;
	
	private int steps; //number of moves before trying to change direction
	private int current = 0;
	
	public Snake(Color c, int x, int y, int size, int steps) {
		color = c;
		
		rect = new Rectangle(x, y, size, size);
		changeDirection();
		
		this.size = size;
		this.steps = steps;
	}
	
	private void changeDirection() {
		double newHead = (int)(4 * Math.random()) * Math.PI * 0.5; ;
		heading = newHead;
		
		dx = (int)(size * Math.cos(heading));
		dy = (int)(size * Math.sin(heading));
	}
	
	public void move() {
		rect.translate(dx, dy);
		
		current++;
		if(current >= steps) {
			current = 0;
			changeDirection();
		}
	}
	
	public Color getColor() { return color; }
	public Rectangle getRect() { return rect; }

}
