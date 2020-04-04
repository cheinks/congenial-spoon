import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

public class test2 extends JPanel{

	private static final long serialVersionUID = 6493216308618135969L;
	private static final String colorAlphabet  = "qjzxvkwyfbghmpduclsntoirae";
	private Color color;

	public test2(String s) {
		color = stir(hexToColors(asciiToHex(s)));
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
	
	private String asciiToHex(String ascii) 
	{
		char[] chars = ascii.toCharArray();
	    StringBuffer hex = new StringBuffer();
	    for (int i = 0; i < chars.length; i++)
	    {
	        hex.append(Integer.toHexString((int) chars[i]));
	    }
	    return hex.toString();
	}
	
	private Color[] hexToColors(String hex) 
	{
		hex = hex.substring(0, hex.length() - (hex.length() % 6));
//		int numChannels = hex.length() / 2;
//		while (numChannels % 3 != 0) 
//		{
//			numChannels++;
//			hex += "00";
//		}
//		
//		Color[] newColors = new Color[numChannels / 3];
		Color[] newColors = new Color[hex.length() / 6];
		int currentColor = 0;
		for(int i = 0; i <= hex.length() - 6; i += 6) 
		{
			newColors[currentColor] = hexToColor(hex.substring(i, i+6));
			currentColor++;
		}
		
		return newColors;
	}
	
	private Color hexToColor(String hexCode)
	{
		int r = Integer.parseInt(hexCode.substring(0, 2), 16);
		int g = Integer.parseInt(hexCode.substring(2, 4), 16);
		int b = Integer.parseInt(hexCode.substring(4, 6), 16);
		
		return new Color(r, g, b);
	}

}
