import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Space extends JPanel{

	private static final long serialVersionUID = 5255690644129320697L;
	
	//private ArrayList<> asteroids;
	
	private Polygon explorer;

	public Space() {
	}
	
	public void paintComponent(Graphics g) {
		drawSpace(g);
		
		drawPlayer(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawPlayer(Graphics g) {
		g.setColor(Color.white);
		g.drawPolygon(explorer);
	}
	
	private void drawSpace(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Manual.screenWidth, Manual.screenHeight);
	}
	
	//Access
	
	//Mutate
	public void addPlayer(Polygon p) {explorer = p;}

}
