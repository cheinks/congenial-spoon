package animationProject;

import java.awt.Color;
import java.lang.Math;
import java.util.Scanner;

public class GameRunner {
	
	private static int numVictims = 5;
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int numVictims = 0;
//		System.out.println("How many players? ");
//		
//		try {
//			numVictims = scanner.nextInt();
//		}catch( java.util.InputMismatchException e){
//			System.out.print("Nice try, but I need an int, dummy.");
//		}
		
		Game game = new Game(numVictims);
		boolean newGame = game.run();
		if(newGame) {GameRunner.main(null);}
	}
	
	public static int getMode() {return 1;}
	public static int getNumPlayers() {return numVictims;}
	
	public static int[] randomLocation(int min, int max) {
		return new int[]{(int)(min+Math.random()*max), (int)(min+Math.random()*max)};
	}
	
	public static int randomSpeed() {
		int speed = (int)(-4 + Math.random()*9);
		if(speed == 0) {
			int direction = (int)(Math.random()*2);
			if(direction == 1) {speed++;}else {speed--;}
		}
		return speed;
	}
	
	public static Color randColor() {
		Color[] colors = new Color[] {Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, 
				Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, 
				Color.YELLOW};
		//10
//		return colors[(int)(Math.random()*colors.length)];
		
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		if(red + green + blue > 574) {
			Math.abs(red-=150);
			Math.abs(green-=150);
			Math.abs(blue-=150);
		}
		return new Color(red, green, blue);
	}
	
	public static int randomSize() {
		return (int)(6+Math.random()*10);
	}
}
