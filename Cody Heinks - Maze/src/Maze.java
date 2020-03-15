import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Maze extends JPanel {
	
	private static final long serialVersionUID = -5386529132944306261L;
	
	private int gameWidth;
	private int gameHeight;
	
	private Color outsideColor;
	private int outThick;
	
	private Color borderColor;
	private int borderThick;
	
	private Color insideColor;
	
	private ArrayList<Runner> players;

	public Maze(int w, int h) {
		gameWidth = w;
		gameHeight = h;
		
		outsideColor = Manual.color1;
		outThick = Manual.thick1;
		
		borderColor = Manual.color2;
		borderThick = Manual.thick2;
		
		insideColor = Manual.color3;
		
		players = new ArrayList<Runner>();
	}
	
	public void paintComponent(Graphics g) {
		drawBase(g);
		
		drawPlayers(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawBase(Graphics g) {
		drawOutside(g);
		drawBorder(g);
		drawInside(g);
	}
	
	private void drawOutside(Graphics g) {
		Color c = outsideColor;
		int x = 0;
		int y = 0;
		int width = gameWidth;
		int height = gameHeight;
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	private void drawBorder(Graphics g) {
		Color c = borderColor;
		int x = outThick;
		int y = outThick;
		int width = gameWidth - (2 * outThick);
		int height = gameHeight - (2 * outThick);
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	private void drawInside(Graphics g) {
		Color c = insideColor;
		int x = outThick + borderThick;
		int y = outThick + borderThick;
		int width = gameWidth - 2 * (outThick + borderThick);
		int height = gameHeight - 2 * (outThick + borderThick);
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	
	private void drawPlayers(Graphics g) {
		for(Runner r : players) {
			Color c = r.getColor();
			Rectangle rect = r.getRect();
			
			g.setColor(c);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
	
	public void addPlayer(Runner r) { players.add(r); }

}
