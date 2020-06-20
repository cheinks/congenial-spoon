import java.awt.Point;

public class test1 {

	public test1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Point center = new Point(100, 100);
		Point a = new Point(105, 100);
		double rotation = Math.PI*0.25;
		
		for(int i = 0; i < 8; i++) {
			a = Manual.rotate(center, a, rotation);
			System.out.println(a);
		}
	}

}
