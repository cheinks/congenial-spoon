
/**
 * Write a description of class TTTBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
public class TTTBot{
    int mode;
    int turnCounter;
    Square[][] game;
    Square selection;
    Square firstChoice;
    Square secondChoice;
    
    public TTTBot(int difficulty, Square[][] b){
        mode = difficulty;
        game = b;
        turnCounter = 1;
    }
    
    public void takeTurn(){
        if(mode == 0){
            //Do nothing. This is a two-player game.
        }else if(mode == 1){ //Easy
            randSquare();
        }else if(mode == 2){ //Medium
            if(turnCounter == 1){
                randSquare();
            }else{
                int value;
            }
        }else if(mode == 3){ //Impossible
            
        }
        selection = null;
    }
    
    private void randSquare(){
        boolean searching = true;
        while(searching){
            int row = (int)(Math.random()*3);
            int col = (int)(Math.random()*3);
            selection = game[row][col];
            if(selection.getValue() == 0){searching = false;}
            selection.checkSquare();
        }
    }
    
    private boolean dangerous(Square sq1, Square sq2, Square sq3){
        boolean dangerous = false;
        int v1 = sq1.getValue();
        int v2 = sq2.getValue();
        int v3 = sq3.getValue();
        if(v1 + v2 + v3 % 2 == 1){return false;}
        //else if(){v1+}
        
        return dangerous;
    }
    
    private Square findMove(Square sq1, Square sq2, Square sq3){
        Square selection = sq1;
        
        return selection;
    }
    
    private void checkDanger(){}
    
    public void reset(){
        firstChoice = null;
        secondChoice = null;
        turnCounter = 1;
    }
}
