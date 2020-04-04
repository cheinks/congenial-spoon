import java.awt.*;
import javax.swing.*;

public class test1 {

	public test1() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Bruh moment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        
        String text = "Hello World!";
		JPanel test2 = new test2(text);
		
		frame.getContentPane().add(BorderLayout.CENTER, test2);
		
		boolean playing = true;
		while(playing) {
			try { Thread.sleep(10); } catch (Exception exc) {}
			frame.repaint();
		}
	}

}
