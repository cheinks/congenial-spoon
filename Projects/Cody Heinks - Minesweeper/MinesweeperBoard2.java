
/**
 * Write a description of class MinesweeperBoard2 here.
 * 
 * @author Cody Heinks 
 * @version 10.11.18
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;
    int numOfCells;
    
    public MinesweeperBoard2(){
        this(10, 10);
    }
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        rows = row;
        columns = column;
        numOfCells = row * column;
        board = new Cell[numOfCells];
        
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addBombs(int bombs) throws Exception{
        
    }

    public void addNums(){
        
    }
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int n = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                System.out.print(board[n].getValue());
                n++;
            }
            System.out.println();
        }        
    }
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
                board[i]= new Cell();
                panel.add(board[i].getButton());
        }
        return panel;
    }
}
