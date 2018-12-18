
/**
 * Write a description of class Test3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
public class Test3{
    Graphics graphics;
    public Test3(){
        JFrame frame = new JFrame();
        graphics = frame.getGraphics();
        //graphics.fillRect(0,0,10,70);
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
}
