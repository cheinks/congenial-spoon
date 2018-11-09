
/**
 * Minesweeper, but with a 2D array.
 *
 * @author Cody Heinks
 * @version 11.9.18
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MinesweeperBoard2D{
    Cell[][] board;
    int rows;
    int columns;
    
    public MinesweeperBoard2D(){
        this(10, 10);
    }
    
    public MinesweeperBoard2D(int row, int column){
        rows = row;
        columns = column;
        board = new Cell[row][column];
        
        JFrame frame = new JFrame("Minesweeper");
        frame.add(addCells());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addBombs(int bombs) throws Exception{
        if(bombs > rows*columns){
            throw new Exception("Too many bombs!");
        }
        int randRow = 0;
        int randCol = 0;
        int bombsLeft = bombs;
        while(bombsLeft > 0){
            randRow = (int)(Math.random()*rows);
            randCol = (int)(Math.random()*columns);
            if(!board[randRow][randCol].isBomb()){
                board[randRow][randCol].setValue(11);
                bombsLeft--;
            }
        }
    }
    public void addNums(){
        
    }
    
    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].isBomb()){
                    System.out.print("X ");
                }else{
                    System.out.print(board[i][j].getValue() + " ");
                }
            }
            System.out.println();
        }
    }
    
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                board[r][c] = new Cell();
                panel.add(board[r][c].getButton());
            }
        }
        return panel;
    }
}
