
/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Square implements ActionListener{
    Board board;
    JButton button;
    boolean clicked = false;
    int value;//0 if empty, 1 if O, 2 if X;
    
    public Square(Board board){
        this.board = board;
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(75,75));
        button.setMargin(new Insets(0,0,0,0));
        
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Courier", 1, 50));
        value = 0;  
        
    }
    public JButton getButton(){return button;}
    public int getValue(){return value;}
    
    @Override
    public void actionPerformed(ActionEvent e){
        checkSquare();
    }
    
    public void checkSquare(){
        if(board.p1Turn && !board.p2Turn && !clicked){
            addO();
            clicked = true;
            board.p1Turn = false;
            board.p2Turn = true;
            board.checkSquare();
        }else if(!board.p1Turn && board.p2Turn && !clicked){
            addX();
            clicked = true;
            board.p1Turn = true;
            board.p2Turn = false;
            board.checkSquare();
        }
    }
    public void addO(){
        button.setText("O");
        clicked = true;
        value = 1;
        board.squaresFilled++;
    }
    public void addX(){
        button.setText("X");
        clicked = true;
        value = 2;
        board.squaresFilled++;
    }
}
