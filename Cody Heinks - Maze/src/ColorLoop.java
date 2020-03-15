import java.awt.Color;

public class ColorLoop {
	
	private static final int maxValue = 255;
	private static final int minValue = 0;

	private static int r = maxValue;
	private static boolean r2min;
	private static boolean r2max;
	
	private static int g = minValue;
	private static boolean g2min;
	private static boolean g2max = true;
	
	private static int b = minValue;
	private static boolean b2min;
	private static boolean b2max;
	
	public static Color nextColor() {
		if(g2max && g < maxValue) {
			g++;
		}else if(g2max && g >= maxValue) {
			g = maxValue;
			g2max = false;
			r2min = true;
		}
		
		if(r2min && r > minValue) {
			r--;
		}else if(r2min && r <= minValue) {
			r = minValue;
			r2min = false;
			b2max = true;
		}
		
		if(b2max && b < maxValue) {
			b++;
		}else if(b2max && b >= maxValue) {
			b = maxValue;
			b2max = false;
			g2min = true;
		}
		
		if(g2min && g > minValue) {
			g--;
		}else if(g2min && g <= minValue ) {
			g = minValue;
			g2min = false;
			r2max = true;
		}
		
		if(r2max && r < maxValue) {
			r++;
		}else if(r >= maxValue) {
			r = maxValue;
			r2max = false;
			b2min = true;
		}
		
		if(b2min && b > minValue) {
			b--;
		}else if(b2min && b <= minValue) {
			b = minValue;
			b2min = false;
			g2max = true;
		}
		
		return new Color(r, g, b);
	}
}
