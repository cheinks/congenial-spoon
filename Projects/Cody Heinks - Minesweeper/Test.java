
/**
 * Write a description of class Test here.
 *
 * @author asdasdasd
 * @version asdasdasdasdasd
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import java.awt.event.*;
public class Test{
    public Test(){
        JFrame frame = new JFrame("Minesweeper");
        
        frame.add(addModeSelectors());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
    
    public JButton flagButton(){
        JButton btn = new JButton();
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Hello world!");
                btn.setEnabled(true);
            }
        });
        btn.setPreferredSize(new Dimension(50,50));
        btn.setMargin(new Insets(0,0,0,0));;
        return btn;
    }
    
    public JPanel addModeSelectors(){
        JPanel panel = new JPanel();
        panel.add(flagButton());
        panel.add(flagButton());
        return panel;
    }
}
