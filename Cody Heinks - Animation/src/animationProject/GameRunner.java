package animationProject;

import java.awt.Color;
import java.lang.Math;
//import java.util.Scanner;

public class GameRunner {
	public static void main(String[] args) {
		Game game = new Game(5);
		boolean newGame = game.run();
		if(newGame) {GameRunner.main(null);}
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
		Color[] colors = new Color[] {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, 
				Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, 
				Color.YELLOW};
		//10
//		return colors[(int)(Math.random()*colors.length)];
		return new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
	}
	
	public static int randomSize() {
		return (int)(5+Math.random()*11);
	}
}
