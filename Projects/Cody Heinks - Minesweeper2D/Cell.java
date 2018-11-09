
/**
 * Write a description of class Cell here.
 *
 * @author Cody Heinks
 * @version 11.9.18
 */
import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Cell implements ActionListener{
    private int value;
    
    private JButton button;
    public Cell(){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
    }
    
    boolean isBomb(){if(value == 11){return true;}else{return false;}}
    
    public void setValue(int newValue){value = newValue;}
    public int getValue(){return value;}
    //public void addOne(){}
    
    public void checkCell(){
        button.setEnabled(false);
        displayValue();
    }
    
    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }
    }
    
    public JButton getButton(){
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        checkCell();
    }
}
