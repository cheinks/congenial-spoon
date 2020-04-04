import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

public class test2 extends JPanel{

	private static final long serialVersionUID = 6493216308618135969L;
	private static final String colorAlphabet  = "qj9zxv8kw7yfb6ghm5pd4ucl 3sn2toi1rae0";
	private Color color;

	public test2(String s) {
		color = stir(asciiToColors(s));
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(color);
		g.fillRect(0, 0, 500, 500);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private Color stir(Color[] colors) 
	{
		int rTotal = 0;
		int gTotal = 0;
		int bTotal = 0;
		float rWeight = 0;
		float gWeight = 0;
		float bWeight = 0;
		Color[] c = colors;
		float maxWeight = 0;
		
		for(int i = 0; i < c.length; i++) {
			Color j = c[i];
			float colorTotal = j.getRed() + j.getGreen() + j.getBlue();
			if(colorTotal == 0) { colorTotal++; }
			
			rWeight += j.getRed() / colorTotal;
			
			gWeight += j.getGreen() / colorTotal;
			
			bWeight += j.getBlue() / colorTotal;
		}
		
		if(rWeight > gWeight && rWeight > bWeight) { maxWeight = rWeight; } 
		else if(gWeight > bWeight) { maxWeight = gWeight; } 
		else { maxWeight = bWeight; }
		
		maxWeight = Math.max(maxWeight, (float)1.0);
		
		rTotal = (int)(rWeight * 255 / maxWeight);
		gTotal = (int)(gWeight * 255 / maxWeight);
		bTotal = (int)(bWeight * 255 / maxWeight);
		
		return new Color(rTotal, gTotal, bTotal);
	}
	
	/*private String asciiToHex(String ascii) 
	{
		char[] chars = ascii.toCharArray();
	    StringBuffer hex = new StringBuffer();
	    for (int i = 0; i < chars.length; i++)
	    {
	        hex.append(Integer.toHexString((int) chars[i]));
	    }
	    return hex.toString();
	}*/
	
	private Color[] asciiToColors(String ascii) 
	{
		String input = ascii.substring(0, ascii.length() - (ascii.length() % 3)).toLowerCase();
		Color[] newColors = new Color[input.length() / 3];
		
		int currentColor = 0;
		for(int i = 0; i <= input.length() - 3; i += 3) 
		{
			newColors[currentColor] = charsToColor(input.substring(i, i + 3));
			currentColor++;
		}
		
		return newColors;
	}
	
	private Color charsToColor(String chars)
	{
		int r = (int)(colorAlphabet.indexOf(chars.substring(0, 1)) * 255 / (float)(colorAlphabet.length()));
		int g = (int)(colorAlphabet.indexOf(chars.substring(1, 2)) * 255 / (float)(colorAlphabet.length()));
		int b = (int)(colorAlphabet.indexOf(chars.substring(2, 3)) * 255 / (float)(colorAlphabet.length()));
		
		return new Color(r, g, b);
	}

}
