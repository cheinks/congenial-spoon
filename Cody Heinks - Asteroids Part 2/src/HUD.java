import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class HUD { //-47 from bottom, 10 border from edge
	
	private int x0 = 0;
	private int y0 = 0;
	private int botEdgeBuffer = 57;

	private Radio radio;
	private int radioX;
	private int radioY;
	private int spacing = Manual.radioFont.getSize();
	
	
	public HUD() {
		radio = new Radio();
		radioX = 17;
		radioY = spacing - botEdgeBuffer + 4 * Manual.gameHeight / 5;
		radio.incomTrans("gandg unadufhadf judhsn dfh udfadhfdf ifdh idfsdfsd uf ifff id is sdudguhadg dbaldgbj");
		
		
	}
	
	public void updateDisplay() {
		radio.updateDisplay();
	}
	
	public void display(Graphics g, int x, int y) {
		x0 = x;
		y0 = y;
		drawRadio(g);
	}
	
	private void drawRadio(Graphics g) {
		g.setColor(Manual.HUDborder);
		g.drawRect(x0 + 10, y0 - 57 + 4 * Manual.gameHeight / 5, Manual.gameWidth / 3, Manual.gameHeight / 5);
		
		g.setColor(Color.red);
		g.setFont(Manual.radioFont);
		ArrayList<String> message = radio.getDisplayTexto();
		
		int i = 0;
		for(String s: message) {
			g.drawString(s, x0 + radioX, y0 + radioY + i);
			i += spacing;
		}
//		g.drawString(radio.getDisplayText(), x0 + radioX, y0 + radioY);
	}

}
