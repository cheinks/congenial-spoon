import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

public class test2 extends JPanel{

	private static final long serialVersionUID = 6493216308618135969L;
	private Color color;

	public test2(String s) {
		color = stir(new Color[] {Color.red, Color.blue, Color.blue});
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
		
		rTotal = (int)(rWeight * 255 / maxWeight);
		gTotal = (int)(gWeight * 255 / maxWeight);
		bTotal = (int)(bWeight * 255 / maxWeight);
		
		System.out.println(new Color(rTotal, gTotal, bTotal).toString());
		
		return new Color(rTotal, gTotal, bTotal);
	}
	
	private Color mix(Color one, Color two) 
	{
		int total1 = one.getRed() + one.getGreen() + one.getBlue();
		if(total1 == 0) {total1++;}
		float r1 = (float)one.getRed() / total1;
		float g1 = (float)one.getGreen() / total1;
		float b1 = (float)one.getBlue() / total1;
		
		int total2 = two.getRed() + two.getGreen() + two.getBlue();
		if(total2 == 0) {total2++;}
		float r2 = (float)two.getRed() / total2;
		float g2 = (float)two.getGreen() / total2;
		float b2 = (float)two.getBlue() / total2;
		
		int rTotal = Math.min(255, (int)((r1 + r2) * 255));
		int gTotal = Math.min(255, (int)((g1 + g2) * 255));
		int bTotal = Math.min(255, (int)((b1 + b2) * 255));
		
		return new Color(rTotal, gTotal, bTotal);
//		//java.awt.Color is dumb, so flip the "direction" of the hue
//		float[] hbvals1 = Color.RGBtoHSB(one.getRed(), one.getBlue(), one.getGreen(), null);
//		hbvals1[0] = 1 - hbvals1[0];
//		float[] hbvals2 = Color.RGBtoHSB(two.getRed(), two.getBlue(), two.getGreen(), null);
//		hbvals2[0] = 1 - hbvals2[0];
//		float[] newHB = new float[3];
//		
//		//B is the greater hue value [0.0 - 1.0)
//		float A = 0;
//		float B = 0;
//		if(hbvals1[0] < hbvals2[0]) 
//		{
//			A += hbvals1[0];
//			B += hbvals2[0];
//		} else {
//			B += hbvals1[0];
//			A += hbvals2[0];
//		}
//		
//		if(B - A >= (float)(300.0 / 360.0)) { B--; } //small not big
//		newHB[0] = (A + B) / 2; //average value of two hues
//		if(Math.abs(B - A) > (float)(61.0 / 360.0)) { newHB[0] -= (float)(30.0 / 360.0); } //how colors work
//		
//		newHB[1] = (hbvals1[1] + hbvals2[1]) / 2;
//		newHB[2] = (hbvals1[2] + hbvals2[2]) / 2;
//		
//		Color c = Color.getHSBColor(newHB[0], newHB[1], newHB[2]);
//		System.out.println(c.toString());
//		return c;
	}
	
	private int asciiToDec() 
	{
		int dec = 0;
		
		return dec;
	}
	
	private String decToHex() 
	{
		String hex = "";
		
		return hex;
	}

}
