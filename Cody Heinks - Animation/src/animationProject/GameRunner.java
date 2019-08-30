package animationProject;

import java.awt.Color;
import java.lang.Math;

public class GameRunner {
	public static void main(String[] args) {
		Game game = new Game();
	}
	
	public static int[] randomLocation(int min, int max) {
		return new int[]{(int)(min+Math.random()*max), (int)(min+Math.random()*max)};
	}
	
	public static int randomSpeed() {
		int speed = (int)(-3 + Math.random()*7);
		if(speed == 0) {speed++;}
		return speed;
	}
	
	public static Color randColor() {
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}
	
	public static int randomSize() {
		return (int)(4+Math.random()*8);
	}
}
