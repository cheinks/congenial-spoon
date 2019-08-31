package animationProject;

import java.awt.Color;
import java.lang.Math;
import java.util.ArrayList;
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
	
	public static int randomSize() {
		return (int)(6+Math.random()*10);
	}
	
	public static Color randColor() {
		ArrayList<Color> colors = new ArrayList<Color>();
		
		colors.add(new Color(0, 0, 128)); //Navy
		colors.add(new Color(0, 0, 255)); //Blue
		colors.add(new Color(0, 128, 0)); //Green
		colors.add(new Color(0, 128, 128)); //Teal
			colors.add(new Color(0, 128, 255)); //??
		colors.add(new Color(0, 255, 0)); //Lime
			colors.add(new Color(0, 255, 128)); //Spring Green
		colors.add(new Color(0, 255, 255)); //Cyan
		colors.add(new Color(128, 0, 0)); //Maroon
		colors.add(new Color(128, 0, 128)); //Purple
			colors.add(new Color(128, 0, 255)); //??
		colors.add(new Color(128, 128, 0)); //Olive
		colors.add(new Color(128, 128, 128)); //Gray
			colors.add(new Color(128, 128, 255)); //??
			colors.add(new Color(128, 255, 0)); //Chartreuse
			colors.add(new Color(128, 255, 128)); //Aquamarine?
			colors.add(new Color(128, 255, 255)); //
		colors.add(new Color(255, 0, 0)); //Red
		colors.add(new Color(255, 0, 128)); //??
		colors.add(new Color(255, 0, 255)); //Magenta
		colors.add(new Color(255, 128, 0)); // Orange?
		colors.add(new Color(255, 128, 128)); //Salmon?
		colors.add(new Color(255, 128, 255)); //Violet?
		colors.add(new Color(255, 255, 0)); //Yellow
		colors.add(new Color(255, 255, 128)); //?
		
		return colors.get((int)(Math.random()*colors.size()));
	}
}
