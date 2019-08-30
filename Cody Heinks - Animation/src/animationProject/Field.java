package animationProject;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Field extends JPanel{
	
	private static final long serialVersionUID = -3030379568821478211L;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player currentPlayer;
	
	private int borderThickness = 6;
	
	//Bounds
	private int xUpper;
	private int xLower;
	private int yUpper;
	private int yLower;
	
	public Field(int width, int height){updateBounds(width, height);}
	
	public void addPlayer(Player newPlayer) {players.add(newPlayer);}
	
	public int getThick() {return borderThickness;}
	
	public int getXUpper() {return xUpper;}
	public int getXLower() {return xLower;}
	public int getYUpper() {return yUpper;}
	public int getYLower() {return yLower;}
	
	public void updateBounds(int newWidth, int newHeight) {
		xUpper = borderThickness; //Left
		xLower = newWidth - (borderThickness+6); //Right
		yUpper = borderThickness; //Top
		yLower = newHeight - (borderThickness+6 + 23); //Bottom
	}
	
	public void paintComponent(Graphics g) {
    	makeBorder(g);
        //Draw Players
        for(int i = players.size()-1; i >= 0; i--) {
        	currentPlayer = players.get(i);
        	if(currentPlayer.getShape() == "DOT") {
    	    	g.setColor(currentPlayer.getColor());
    	    	g.fillRect(currentPlayer.getX(), currentPlayer.getY(), currentPlayer.getWidth(), currentPlayer.getHeight());
            }
        }
    }
	private void makeBorder(Graphics g) {
		//White Border
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        //Black Border
        g.setColor(Color.BLACK);
        g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
        
        //Inside Color
        g.setColor(Color.WHITE);
        g.fillRect(borderThickness, borderThickness, this.getWidth()-(borderThickness*2), this.getHeight()-(borderThickness*2));
	}
}
