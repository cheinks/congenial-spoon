import java.awt.Color;

/* This class creates a looping rainbow effect by iterating through 
 * a range of RGB color-space values in a specific order. 
 * */

public class ColorLoop {
	
	private static final int maxValue = 255;
	private static final int minValue = 0;

	//The modes through which the ColorLoop will phase
	private static int r = maxValue;
	private static boolean r2min; //true if r is shrinking
	private static boolean r2max; //true if r is growing
	
	private static int g = minValue;
	private static boolean g2min;
	private static boolean g2max = true;
	
	private static int b = minValue;
	private static boolean b2min;
	private static boolean b2max;
	
	//Computes the next color in the loop given the current states of the variables above 
	public static Color nextColor() {
		//Mode 1
		if(g2max && g < maxValue) {
			g++;
		}
		else if(g2max && g >= maxValue) { //once reached the target value, move on to the next mode
			g = maxValue;
			g2max = false;
			r2min = true;
		}
		
		//Mode 2
		if(r2min && r > minValue) {
			r--;
		}
		else if(r2min && r <= minValue) {
			r = minValue;
			r2min = false;
			b2max = true;
		}
		
		//Mode 3
		if(b2max && b < maxValue) {
			b++;
		}
		else if(b2max && b >= maxValue) {
			b = maxValue;
			b2max = false;
			g2min = true;
		}
		
		//Mode 4
		if(g2min && g > minValue) {
			g--;
		}
		else if(g2min && g <= minValue ) {
			g = minValue;
			g2min = false;
			r2max = true;
		}
		
		//Mode 5
		if(r2max && r < maxValue) {
			r++;
		}
		else if(r >= maxValue) {
			r = maxValue;
			r2max = false;
			b2min = true;
		}
		
		//Mode 6
		if(b2min && b > minValue) {
			b--;
		}
		else if(b2min && b <= minValue) {
			b = minValue;
			b2min = false;
			g2max = true;
		}
		
		return new Color(r, g, b);
	}
	
}
