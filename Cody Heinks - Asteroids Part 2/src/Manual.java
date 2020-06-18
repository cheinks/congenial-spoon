import java.awt.Polygon;
import java.awt.Rectangle;

public class Manual {
	
	//Variables
	public static int omg = 123;
	
	//Methods
	public static Polygon newIsoTriang(Rectangle r) {
		int x1 = r.x + (r.width / 2); //the apex
		int y1 = r.y;
		
		int x2 = r.x; //the bottom left
		int y2 = r.y + r.height;
		
		int x3 = r.x + r.width; //the bottom right
		int y3 = r.y + r.height;
		
		return new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
	}

}
