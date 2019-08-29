package animationProject;

import java.lang.Math;

public class GameRunner {
	public static void main(String[] args) {
		Game game = new Game();
	}
	
	public static int[] randomLocation(int min, int max) {
		return new int[]{(int)(min+Math.random()*max), (int)(min+Math.random()*max)};
	}
	
	public static int randomSpeed() {
		return (int)(1 + Math.random()*3);
	}
}
