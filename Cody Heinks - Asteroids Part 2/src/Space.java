import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Space extends JPanel{

	private static final long serialVersionUID = 5255690644129320697L;
	
	private int offsetX; //too keep the player in the center
	private int offsetY;
	
	private Player explorer;
	private Color explColor;
	private boolean elite = false;
	
	private ArrayList<Asteroid> field;

	public Space() {
		field = new ArrayList<Asteroid>();
	}
	
	public void paintComponent(Graphics g) {
		//g.translate(-explorer.getRect().x + offsetX, -explorer.getRect().y + offsetY);
		
		drawSpace(g);
		drawField(g);
		drawPlayer(g, elite);
		
		Toolkit.getDefaultToolkit().sync();
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
