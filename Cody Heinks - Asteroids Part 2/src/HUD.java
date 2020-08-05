import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private int x0 = 0;
	private int y0 = 0;

	private Radio radio;
	private int radioX;
	private int radioY;
	
	public HUD() {
		radio = new Radio();
		radio.incomTrans("Once upon a time in a galaxy far far away...");
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
		g.setColor(Color.red);
		g.setFont(Manual.radioFont);
		g.drawString(radio.getDisplayText(), x0 + radioX, y0 + radioY);
	}

}
