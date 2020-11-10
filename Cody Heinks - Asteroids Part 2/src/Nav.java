import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Nav {
	
	private Rectangle rect;
	
	Player player;
	
	int x, y;

	public Nav(Player p) {
		player = p;
		
		rect = new Rectangle(0, 20, 0, 0);
	}
	
	public void track(Graphics g) {
		g.setColor(Color.cyan);
		g.drawString(player.getX() + ", " + player.getY(), rect.x, rect.y);
	}

}
