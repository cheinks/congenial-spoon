import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Space extends JPanel{

	private static final long serialVersionUID = 5255690644129320697L;
	
	private int offsetX; //too keep the player in the center
	private int offsetY;
	private Rectangle bounds;
	private Point loc = new Point();
	
	private Player explorer;
	private Color explColor;
	private boolean elite = false;
	
	private ArrayList<Asteroid> field;

	public Space(Rectangle bounds) {
		field = new ArrayList<Asteroid>();
		this.bounds = bounds;
	}
	
	public void paintComponent(Graphics g) {
		g.setClip(0, 0, 1000/*Manual.screenWidth*/, 1000/*Manual.screenHeight*/);
		drawSpace(g);
		checkBounds(g);
		drawField(g);
		drawPlayer(g, elite);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void checkBounds(Graphics g) {
		//the location of 'g' is the inverse of the location of the player
		loc.setLocation(offsetX - explorer.getX(), offsetY - explorer.getY());
		
		if(-loc.x < bounds.x) {//left
			loc.move(-bounds.x, loc.y);
		}
		else if(-loc.x > bounds.x + bounds.width) {//right
			loc.move(-(bounds.x + bounds.width), loc.y);
		}
		if(-loc.y > bounds.y + bounds.height) {//bottom
			loc.move(loc.x, -(bounds.y + bounds.height));
		}
		else if(-loc.y < bounds.y) {//top
			loc.move(loc.x, -bounds.y);
		}
		
		g.translate(loc.x, loc.y);
	}
	
	private void drawPlayer(Graphics g, boolean elite) {
		g.setColor(explColor);
		if(elite) {g.drawPolygon(explorer.getPoly());}
		else {g.fillPolygon(explorer.getPoly());}
		
	}
	private void drawField(Graphics g) {
		g.setColor(Color.lightGray);
		for(int i = 0; i < field.size(); i++) {
			Asteroid a = field.get(i);
			if(a.getExist()) {
				Rectangle aRect = a.getRect();
				g.fillOval(aRect.x, aRect.y, aRect.width, aRect.height);
			}
			else {
				field.remove(i);
				i--;
			}
		}
	}
	private void drawSpace(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Manual.screenWidth, Manual.screenHeight);
	}
	
	//Access
	
	//Mutate
	public void addPlayer(Player p) {
		explorer = p;
		try{
			explColor = Manual.rankColors[p.getRank()];
		}
		catch(Exception exc) {
			explColor = Color.white; elite = true;
		}
		offsetX = p.getRect().x;
		offsetY = p.getRect().y;
	}
	
	public void addAsteroid(Asteroid a) {field.add(a);}
	public void addAsteroid(ArrayList<Asteroid> aa) {for(Asteroid a : aa) {addAsteroid(a);}}
}
