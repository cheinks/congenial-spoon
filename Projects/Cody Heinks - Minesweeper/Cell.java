
/**
 * Write a description of class Cell here.
 * 
 * I will be representing a mine using the number: 11
 * 
 * @author Cody Heinks 
 * @version 10.14.18
 */
import javax.swing.*;   
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cell implements ActionListener{
    //Variables you need to work with
    private int value;
    
    int loc;
    boolean isFlag;
    boolean bombWithFlag;
    boolean revealed;

    //Variables you don't need to worry about or care about.
    private JButton button;
    /**
     * This constructor is complete and does not need modification
     */
    public Cell(int location){
        button = new JButton();
        button.addActionListener(this);
        button.setPreferredSize(new Dimension(20,20));
        button.setMargin(new Insets(0,0,0,0));
        value = 0;
        loc = location;
    }

    /** This Method tells me if the cell is a bomb.
     * 
     * @return true if it is a bomb, otherwse false.
     */
    boolean isBomb(){if(value == 11){return true;}else{return false;}}

    //Additional Methods may be required. Please make them yourself.

    public void setValue(int newValue){value = newValue;}
    public int getValue(){return value;}
    public void addOne(){value++;}

    //The following methods are used for the User Inferface. These methods are fully functional and do not need to be modified.
    public void checkCell(){
        if(!revealed){
            button.setEnabled(false);
            revealed = true;
            displayValue();
        }
    }

    public void displayValue(){
        if(this.isBomb()){
            button.setText("\u2600");
            MinesweeperBoard2.endGame();
            button.setBackground(Color.RED);
        }else if(value!=0){
            button.setText(String.valueOf(value));
        }else{  
            revealBlanks(loc);
        }
    }

    public JButton getButton() {
        return button;
    }
    //button.getBackground().equals(Color.YELLOW)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MinesweeperBoard2.flag){
            if(isFlag){
                clearFlag();
                //MinesweeperBoard2.flagsPlaced--;
                if(isBomb()){
                    MinesweeperBoard2.flaggedBombs--;
                }
            }else{
                addFlag();
                //MinesweeperBoard2.flagsPlaced++;
                if(isBomb()){
                    MinesweeperBoard2.flaggedBombs++;
                }
            }
        }else{
            if(!isFlag){
                checkCell();
            }
        }
    }   
    
    public void addFlag(){
        isFlag = true;
        //button.setBackground(Color.YELLOW);
        button.setText("\u2691");
    }
    
    public void clearFlag(){
        isFlag = false;
        //button.setBackground(new JButton().getBackground());
        button.setText("");
    }
    
    public void revealBlanks(int startLoc){
        int columns = MinesweeperBoard2.columns;
        int numOfCells = MinesweeperBoard2.numOfCells;
        
        int tLeft = 0;
        int above = 0;
        int tRight = 0;
        int left = 0;
        int right = 0;
        int bLeft = 0;
        int below = 0;
        int bRight = 0;
        
        if(startLoc < columns){ tLeft = -1; above = -1; tRight = -1;}
        if(startLoc % columns == 0){tLeft = -1; left = -1; bLeft = -1;}
        if((startLoc + 1) % columns == 0){tRight = -1; right = -1; bRight = -1;}
        if(startLoc + columns >= numOfCells){bLeft = -1; below = -1; bRight = -1;}
        
        if(tLeft == 0){MinesweeperBoard2.board[startLoc - columns - 1].checkCell();}
        if(above == 0){MinesweeperBoard2.board[startLoc - columns].checkCell();}
        if(tRight == 0){MinesweeperBoard2.board[startLoc - columns + 1].checkCell();}
        if(left == 0){MinesweeperBoard2.board[startLoc - 1].checkCell();}
        
        if(right == 0){MinesweeperBoard2.board[startLoc + 1].checkCell();}
        if(bLeft == 0){MinesweeperBoard2.board[startLoc + columns - 1].checkCell();}
        if(below == 0){MinesweeperBoard2.board[startLoc + columns].checkCell();}
        if(bRight == 0){MinesweeperBoard2.board[startLoc + columns + 1].checkCell();}
        
    }
}
