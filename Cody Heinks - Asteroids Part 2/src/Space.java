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
	private Point loc = new Point();
	private Rectangle bounds;
	private Rectangle rect;
	
	private Player explorer;
	private Color explColor;
	private boolean elite = false;
	
	private ArrayList<Asteroid> field;

	public Space(Rectangle bounds, Rectangle clip) {
		field = new ArrayList<Asteroid>();
		this.bounds = bounds;
		this.rect = clip;
	}
	
	public void paintComponent(Graphics g) {
		g.setClip(rect.x, rect.y, rect.width, rect.height);
		drawSpace(g);
		checkBounds(g);
		drawField(g);
		drawPlayer(g, elite);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void checkBounds(Graphics g) {
		//the location of 'g' is the opposite of the location of the player
		loc.setLocation(offsetX - explorer.getX(), offsetY - explorer.getY());
		
		if(-loc.x < bounds.x) {//left
			loc.move(-bounds.x, loc.y);
		}
		else if(-loc.x + rect.width > bounds.x + bounds.width) {//right
			loc.move(-(bounds.x + bounds.width - rect.width), loc.y);
		}
		if(-loc.y + rect.height > bounds.y + bounds.height) {//bottom
			loc.move(loc.x, -(bounds.y + bounds.height - rect.height));
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
				g.fillPolygon(a.getPoly());
			}
			else {
				field.remove(i);
				i--;
			}
		}
		g.setColor(Color.red);
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
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
