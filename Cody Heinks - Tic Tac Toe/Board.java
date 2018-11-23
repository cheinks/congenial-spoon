
/**
 * Write a description of class Board here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class Board{
    Square[][] board = new Square[3][3];
    JLabel info = new JLabel("O Turn");
    int squaresFilled = 0;
    
    JLabel p1;//O
    boolean p1Turn;
    int games1;
    
    JLabel p2;//X
    boolean p2Turn;
    int games2;
    
    public Board(){
        info.setFont(new Font("Courier", Font.PLAIN, 30));
        
        p1Turn = true;
        games1 = 0;
        p1 = new JLabel("O:   " + games1);
        p1.setFont(new Font("Courier", Font.PLAIN, 32));
        p1.setOpaque(false);
        
        p2Turn = false;
        games2 = 0;
        p2 = new JLabel("X:   " + games2);
        p2.setFont(new Font("Courier", Font.PLAIN, 32));
        p2.setOpaque(false);
    }
    
    public Color randomColor(){
        int redValue = 0;
        int greenValue = 0;
        int blueValue = 0;
        while(redValue + greenValue + blueValue < 255){
            redValue = (int)(Math.random()*255);
            greenValue = (int)(Math.random()*255);
            blueValue = (int)(Math.random()*255);
        }
        return new Color(redValue, greenValue, blueValue);
    }
    
    public void checkSquare(){
        boolean checked = false;
        //3-in-a-row top to bottom
        for(int i = 0; i<3; i++){
            int sValue = board[0][i].getValue();
            if(sValue > 0 && board[1][i].getValue()==sValue && board[2][i].getValue()==sValue){
                if(sValue==1){games1++;}
                else if(sValue==2){games2++;}
                endGame(sValue);
                checked = true;
            }
        }
        if(!checked){
            //3-in-a-row left to right
            for(int i = 0; i<3; i++){
                int sValue = board[i][0].getValue();
                if(sValue > 0 && board[i][1].getValue()==sValue && board[i][2].getValue()==sValue){
                    if(sValue==1){games1++;}
                    else if(sValue==2){games2++;}
                    endGame(sValue);
                    checked = true;
                }
            }
        }
        
        if(!checked){
            //3-in-a-row top left to bottom right
            int tL = board[0][0].getValue();
            if(tL == board[1][1].getValue() && tL == board[2][2].getValue()){
                if(tL != 0){
                    if(tL==1){games1++;}
                    else if(tL==2){games2++;}
                    endGame(tL);
                    checked = true;
                }
            }
        }
        
        if(!checked){
            //3-in-a-row top right to bottom left
            int tR = board[0][2].   getValue();
            if(tR == board[1][1].getValue() && tR == board[2][0].getValue()){
                if(tR != 0){
                    if(tR==1){games1++;}
                    else if(tR==2){games2++;}
                    endGame(tR);
                    checked = true;
                }
            }
        }
        
        if(!checked){
            //Cats game
            if(squaresFilled == 9){
                endGame(0);
                checked = true;
            }
        }
        
        if(!checked){
            updateInfo(false, 0);
            checked = true;
        }
    }
    public void updateInfo(boolean gameOver, int winner){
        if(!gameOver){
            if(p1Turn){
                info.setText("O Turn");
            }else{
                info.setText("X Turn");
            }
        }else{
            if(winner == 0){
                info.setText("Cat's game!");
            }else if(winner == 1){
                info.setText("O wins!");
            }else if(winner == 2){
                info.setText("X wins");
            }
            
        }   
    }
    
    public void endGame(int winner){
        updateInfo(true, winner);
        p1.setText("O:   " + games1);
        p2.setText("X:   " + games2);
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                if(board[r][c].value == 0){
                    board[r][c].getButton().setEnabled(false);
                }
            }
        }
        //add delay
        resetBoard();
    }
    public void resetBoard(){
        for(int r=0; r<3; r++){
            for(int c=0; c<3; c++){
                board[r][c].clicked = false;
                board[r][c].value = 0;
                board[r][c].getButton().setText("");
                board[r][c].getButton().setEnabled(true);
            }
        }
        squaresFilled = 0;
        updateInfo(false, 0);
    }
}
