import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.JPanel;

/* This class controls the GUI of the entire game. */

public class Maze extends JPanel {
	
	private static final long serialVersionUID = -5386529132944306261L;
	
	//the total area of u.i. space
	private int gameWidth;
	private int gameHeight;
	
	//values for the maze u.i.
	private Color outsideColor;
	private int outThick;
	private Color borderColor;
	private int borderThick;
	private Color insideColor;
	
	private ArrayList<Sprite> sprites; //the sprites to be drawn
	
	public Maze(int w, int h) {
		gameWidth = w;
		gameHeight = h;
		
		outsideColor = Manual.color1;
		outThick = Manual.thick1;
		
		borderColor = Manual.color2;
		borderThick = Manual.thick2;
		
		insideColor = Manual.color3;
		
		sprites = new ArrayList<Sprite>();
	}
	
	public void paintComponent(Graphics g) {
		drawBase(g);
		
		drawSprites(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	//Makes the maze u.i.
	private void drawBase(Graphics g) {
		drawOutside(g);
		drawBorder(g);
		drawInside(g);
	}
	
	//Get the corresponding color and rectangle and draw it
	private void drawOutside(Graphics g) { //the space between the frame and the maze border
		Color c = outsideColor;
		int x = 0;
		int y = 0;
		int width = gameWidth;
		int height = gameHeight;
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	private void drawBorder(Graphics g) { //teh maze border
		Color c = borderColor;
		int x = outThick;
		int y = outThick;
		int width = gameWidth - (2 * outThick);
		int height = gameHeight - (2 * outThick);
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	private void drawInside(Graphics g) { //the background within the maze
		Color c = insideColor;
		int x = outThick + borderThick;
		int y = outThick + borderThick;
		int width = gameWidth - 2 * (outThick + borderThick);
		int height = gameHeight - 2 * (outThick + borderThick);
		
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}
	
	//Gets the corresponding color and rectangle for each sprite and draws them
	private void drawSprites(Graphics g) {
		for(Sprite s : sprites) {
			Color c = s.getColor();
			Rectangle rect = s.getRect();
			
			g.setColor(c);
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
	
	//Mutators
	public void addSprite(Sprite s) { sprites.add(s); }
	public void addSprite(ArrayList<Sprite> ss) { for(Sprite s : ss) { addSprite(s); } }

}
