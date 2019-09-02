package animationProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.Math;
import java.util.ArrayList;

public class GameRunner {

	private static Dimension screenSize;
	private static int width;
	private static int height;
	private static boolean playing = true;
	
	public static void main(String[] args) {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)(screenSize.getWidth());
		height = (int)(screenSize.getHeight());
		
		Game game = new Game();
		try {Thread.sleep(10);} catch (Exception exc) {}
		while(playing) {
			game.run();
			game.celebrate();
		}
	}
	
	public static Dimension getScreenSize() {return screenSize;}
	
	public static int[] randomLocation(int min, int max) {
		return new int[]{(int)(min + Math.random() * (max - min)), 
				(int)(min + Math.random() * (max - min))};
	}
	
	public static int randomSpeed() {
		int maxSize = width;
		if(width > height) {maxSize = height;}
		
		int speed = (int)(1 + Math.random() * (maxSize / 160));
		int direction = (int)(Math.random() * 2);
		if(direction == 1) {speed *= -1;}
		return speed;
	}
	
	public static int randomSize() { //12 to 24
		int maxSize = width;
		if(width < height) {maxSize = height;}
		
		return (int)((maxSize / 160) + Math.random() * (maxSize / 64));
	}
	public static String randomShape() {
		String[] shapes = new String[] {
				"DOT", "DOT", "DOT", "DOT", "DOT",
				"CIRCLE", "CIRCLE", "CIRCLE", "CIRCLE",
				"4STAR", "4STAR", "4STAR",
				"GEOM1", "GEOM1",
				"WIEBE"};
		return shapes[(int)(Math.random() * shapes.length)];
	}
	
	public static Color randomColor() {
		ArrayList<Color> colors = new ArrayList<Color>();
		
		//HTML Color Codes
		colors.add(new Color(0, 0, 128));     //Navy
		colors.add(new Color(0, 0, 255));     //Blue
		colors.add(new Color(0, 128, 0));     //Green
		colors.add(new Color(0, 128, 128));   //Teal
		colors.add(new Color(0, 128, 255));   //DodgerBlue
		colors.add(new Color(0, 255, 0));     //Lime
		colors.add(new Color(0, 255, 128));   //SpringGreen
		colors.add(new Color(0, 255, 255));   //Cyan
		colors.add(new Color(128, 0, 0));     //Maroon
		colors.add(new Color(128, 0, 128));   //Purple
		colors.add(new Color(128, 0, 255));   //BlueViolet
		colors.add(new Color(128, 128, 0));   //Olive
		colors.add(new Color(128, 128, 128)); //Gray
		colors.add(new Color(128, 128, 255)); //MediumSlateBlue
		colors.add(new Color(128, 255, 0));   //Chartreuse
		colors.add(new Color(128, 255, 128)); //PaleGreen
		colors.add(new Color(128, 255, 255)); //LightCyan
		colors.add(new Color(255, 0, 0));     //Red
		colors.add(new Color(255, 0, 128));   //DeepPink
		colors.add(new Color(255, 0, 255));   //Magenta
		colors.add(new Color(255, 128, 0));   //Orange
		colors.add(new Color(255, 128, 128)); //Salmon
		colors.add(new Color(255, 128, 255)); //Violet
		colors.add(new Color(255, 255, 0));   //Yellow
		colors.add(new Color(255, 255, 128)); //LemonChiffon
		
		return colors.get((int)(Math.random() * colors.size()));
	}
}
