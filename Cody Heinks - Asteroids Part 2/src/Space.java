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
	private Point loc = new Point(); //position of the graphics context
	private Rectangle bounds; //the total game area
	private Rectangle rect; //the visible area
	
	private Player explorer;
	private Color explColor;
	private boolean elite = false;

	private ArrayList<Star> stars;
	private ArrayList<Asteroid> asteroids;
	
	private HUD mainHUD;

	public Space(Rectangle bounds, Rectangle camera) {
		this.bounds = bounds;
		this.rect = camera;
		
		stars = new ArrayList<Star>();
		asteroids = new ArrayList<Asteroid>();
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
		rect.setLocation(-loc.x, -loc.y);
		g.translate(loc.x, loc.y);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setClip(0, 0, Manual.gameWidth, Manual.gameHeight);
		drawBackground(g);
		checkBounds(g);
		drawSpace(g);
		drawPlayer(g, elite);
		drawField(g);
		
		mainHUD.display(g, rect.x, rect.y);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawPlayer(Graphics g, boolean elite) {
		g.setColor(Color.black);
		if(elite) {
			g.fillPolygon(explorer.getPoly());
			g.setColor(explColor);
			g.drawPolygon(explorer.getPoly());
		}
		else {
			g.setColor(explColor);
			g.fillPolygon(explorer.getPoly());
		}
		
	}
	private void drawField(Graphics g) {
		g.setColor(Color.lightGray);
		for(int i = 0; i < asteroids.size(); i++) {
			Asteroid a = asteroids.get(i);
			if(a.getExist()) {
				g.fillPolygon(a.getPoly());
			}
			else {
				asteroids.remove(i);
				i--;
			}
		}
	}
	private void drawSpace(Graphics g) {
		g.setColor(Manual.starCol);
		for(Star s : stars) {
			Rectangle sRect = s.getRect();
			if(rect.contains(sRect)) {
				g.fillRect(sRect.x, sRect.y, sRect.width, sRect.height);
				int dist = Manual.randInt(1, 10000);
				if(dist == 1) { g.drawPolygon(s.getFlicker()); }
			}
			
		}
	}
	private void drawBackground(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Manual.gameWidth, Manual.gameHeight);
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
		offsetX = (int)((rect.width * 0.5) - (p.getRect().width * 0.5));
		offsetY = (int)((rect.height * 0.5) - (p.getRect().height * 0.5));
	}
	
	public void addStar(Star s) {stars.add(s);}
	public void addStar(ArrayList<Star> ss) {for(Star s : ss) {addStar(s);}}
	
	public void addAsteroid(Asteroid a) {asteroids.add(a);}
	public void addAsteroid(ArrayList<Asteroid> aa) {for(Asteroid a : aa) {addAsteroid(a);}}
	
	public void addHUD(HUD hud) {mainHUD = hud;}
}
