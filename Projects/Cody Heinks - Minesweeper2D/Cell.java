    
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
    int xCoord; //column
    int yCoord; //row
    
    MinesweeperBoard board;
    boolean revealed;
    boolean isFlag;
    boolean bombWithFlag;
    
    private JButton button;
    public Cell(int x, int y, MinesweeperBoard board){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
        xCoord = x;
        yCoord = y;
        this.board = board;
    }
    
    boolean isBomb(){if(value == 11){return true;}else{return false;}}
    
    public void setValue(int newValue){value = newValue;}
    public int getValue(){return value;}
    
    public void checkCell(){
        if(board.firstClick){
            board.playGame(xCoord, yCoord);
            board.firstClick = false;
        }
        if(!revealed && !isFlag){
            revealed = true;
            button.setEnabled(false);
            displayValue();
        }
    }
    
    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            button.setBackground(Color.RED);
            board.endGame(false);
        }else if(value!=0){
            button.setText(String.valueOf(value));
            board.cellCleared();
        }else{
            board.revealBlanks(yCoord, xCoord);
            board.cellCleared();
        }
    }
    
    public JButton getButton(){
        return button;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(board.getMode()){
            if(isFlag){clearFlag();}else{addFlag();}
        }else{if(!isFlag){checkCell();}}
    }
    
    void addFlag(){
        isFlag = true;
        button.setText("\u2691");
        if(isBomb()){bombWithFlag = true;}
    }
    void clearFlag(){
        isFlag = false;
        button.setText("");
        if(isBomb()){bombWithFlag = true;}
    }
}
