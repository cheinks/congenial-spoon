
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
    boolean player1;
    boolean player2;
    
    public Board(){
        player1 = true;
        player2 = false;
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
        //3-in-a-row top to bo  ttom
        for(int i = 0; i<3; i++){
            int sValue = board[0][i].getValue();
            if(sValue > 0 && board[1][i].getValue()==sValue && board[2][i].getValue()==sValue){
                if(sValue==1){System.out.println();}
                else if(sValue==2){System.out.println();}
                endGame();
            }
        }
        //3-in-a-row left to right
        for(int i = 0; i<3; i++){
            int sValue = board[i][0].getValue();
            if(sValue > 0 && board[i][1].getValue()==sValue && board[i][2].getValue()==sValue){
                if(sValue==1){System.out.println();}
                else if(sValue==2){System.out.println();}
                endGame();
            }
        }
        //3-in-a-row top left to bottom right
        int tL = board[0][0].getValue();
        if(tL == board[1][1].getValue() && tL == board[2][2].getValue()){
            if(tL != 0){
                if(tL==1){System.out.println();}
                else if(tL==2){System.out.println();}
                endGame();
            }
        }
        //3-in-a-row top right to bottom left
        int tR = board[0][2].   getValue();
        if(tR == board[1][1].getValue() && tR == board[2][0].getValue()){
            if(tR != 0){
                if(tR==1){System.out.println();}
                else if(tR==2){System.out.println();}
                endGame();
            }
        }
    }
    
    public void endGame(){
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                board[r][c].getButton().setEnabled(false);
            }
        }
    }
}
