
/**
 * Minesweeper, but with a 2D array.
 *
 * @author Cody Heinks
 * @version 11.13.18
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
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(!board[r][c].isBomb()){
                    int numValue = 0;
                    boolean tLeft = true;
                    boolean above = true;
                    boolean tRight = true;
                    boolean left = true;
                    boolean right = true;
                    boolean bLeft = true;
                    boolean below = true;
                    boolean bRight = true;
                    //Top edge
                    if(r == 0){tLeft = false; above = false; tRight = false;}
                    //Left edge
                    if(c == 0){tLeft = false; left = false; bLeft = false;}
                    //Right edge
                    if(c == columns - 1){tRight = false; right = false; bRight = false;}
                    //Bottom edge
                    if(r == rows - 1){bLeft = false; below = false; bRight = false;}
                    
                    if(tLeft && board[r-1][c-1].isBomb()){numValue++;}
                    if(above && board[r-1][c].isBomb()){numValue++;}
                    if(tRight && board[r-1][c+1].isBomb()){numValue++;}
                    
                    if(left && board[r][c-1].isBomb()){numValue++;}
                    if(right && board[r][c+1].isBomb()){numValue++;}
                    
                    if(bLeft && board[r+1][c-1].isBomb()){numValue++;}
                    if(below && board[r+1][c].isBomb()){numValue++;}
                    if(bRight && board[r+1][c+1].isBomb()){numValue++;}
                    
                    board[r][c].setValue(numValue);
                }  
            }
        }
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
