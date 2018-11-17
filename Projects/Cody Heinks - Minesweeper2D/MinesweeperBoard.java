
/**
 * Write a description of class CellBoard here.
 *
 * @author Cody
 * @version 11.16.18
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class MinesweeperBoard{
    Cell[][] board;
    int columns;
    int rows;
    int mines;
    boolean firstClick = true;
    int tracker = mines;
    
    int cellsToClear;
    boolean flagMode;
    JButton flagBtn;
    JLabel bombsLeft;
    Color bckg;
    
    public MinesweeperBoard(int row, int col, int bombs, Cell[][] board, JButton flagBtn, JLabel bombsLeft){
        this.board = board;
        this.flagBtn = flagBtn;
        this.bombsLeft = bombsLeft;
        
        bombsLeft.setText("Hello world!");
        
        bckg = flagBtn.getBackground();
        rows = row;
        columns = col;
        mines = bombs;
        cellsToClear = row*col-bombs;
    }
    
    public void playGame(int safeX, int safeY){
        try{
            addBombs(mines, safeX, safeY);
        }catch(Exception e){
            System.out.println(e);
        }
        addNums();
    }
    
    public void addBombs(int bombs, int safeX, int safeY) throws Exception{
        if(bombs > rows*columns - 1){
            throw new Exception("Too many bombs!");
        }
        int randRow = 0;
        int randCol = 0;
        int bombsLeft = bombs;
        boolean dangerous = false;
        while(bombsLeft > 0){
            randRow = (int)(Math.random()*rows);
            randCol = (int)(Math.random()*columns);
            if(randCol == safeX - 1 || randCol == safeX || randCol == safeX + 1){
                if(randRow == safeY - 1 || randRow == safeY || randRow == safeY + 1){
                    dangerous = true;
                }
            }
            if(!dangerous){
                board[randRow][randCol].setValue(11);
                bombsLeft--;
            }
            dangerous = false;
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
    
    public boolean getMode(){
        if(flagMode){return true;}
        return false;
    }
    
    public void revealBlanks(int startRow, int startCol){
        int r = startRow;
        int c = startCol;
        
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
        
        if(tLeft){board[r-1][c-1].checkCell();}
        if(above){board[r-1][c].checkCell();}
        if(tRight){board[r-1][c+1].checkCell();}
        
        if(left){board[r][c-1].checkCell();}
        if(right){board[r][c+1].checkCell();}
        
        if(bLeft){board[r+1][c-1].checkCell();}
        if(below){board[r+1][c].checkCell();}
        if(bRight){board[r+1][c+1].checkCell();}
    }
    
    public void cellCleared(){
        cellsToClear--;
        if(cellsToClear == 0){
            for(int r=0; r<board.length; r++){
                for(int c=0; c<board[0].length; c++){
                    if(board[r][c].isBomb() && !board[r][c].bombWithFlag){
                        board[r][c].addFlag();
                    }
                }
            }
            endGame(true);
        }
    }
    
    public void endGame(boolean win){
        if(!win){
            for(int r=0; r<board.length; r++){
                for(int c=0; c<board[0].length; c++){
                    board[r][c].getButton().setEnabled(false);
                    if(board[r][c].isBomb() && !board[r][c].bombWithFlag){
                        board[r][c].getButton().setText("\u2600");
                        board[r][c].getButton().setBackground(Color.RED);
                    }else if(board[r][c].isFlag && !board[r][c].isBomb()){
                        board[r][c].getButton().setText("\u274C");
                    }
                }
            }
            flagBtn.setFont(new Font("Courier", Font.PLAIN, 42));
            flagBtn.setText("\u2639");
            flagBtn.setEnabled(false);
        }else{
            flagBtn.setFont(new Font("Courier", Font.PLAIN, 42));
            flagBtn.setText("\u263A");
            flagBtn.setEnabled(false);
        }
    }
}
