
/**
 * Write a description of class Test3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
import java.lang.Math;
public class Test3{
    public Test3(){
        JFrame frame = new JFrame();
        frame.add(addMain());
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
    
    public JPanel addMain(){
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Graphics g = panel.getGraphics();
                g.fillRect(e.getX(), e.getY(), 10, 10);
                g.dispose();
            }
        });
        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                
            }
        });
        
        return panel;
    }
}
