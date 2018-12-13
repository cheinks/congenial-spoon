
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
            randSquare().checkSquare();
        }else if(mode == 2){ //Medium
            if(turnCounter == 1){
                randSquare().checkSquare();
            }else{
                makeMove().checkSquare();
            }
        }else if(mode == 3){ //Impossible
            
        }
        turnCounter++;
    }
    
    private Square randSquare(){
        Square selection = null;
        boolean searching = true;
        while(searching){
            int row = (int)(Math.random()*3);
            int col = (int)(Math.random()*3);
            selection = game[row][col];
            if(selection.getValue() == 0){searching = false;}
            
        }
        return selection;
    }
    
    private boolean dangerous(Square sq1, Square sq2, Square sq3){
        boolean dangerous = false;
        int v1 = sq1.getValue();
        int v2 = sq2.getValue();
        int v3 = sq3.getValue();
        
        if(v1 == 2){dangerous = false;}
        else if(v2 == 2){dangerous = false;}
        else if(v3 == 2){dangerous = false;}
        else if(v1 + v2 + v3 == 2){dangerous = true;}
        
        return dangerous;
    }
    private Square findMove(Square sq1, Square sq2, Square sq3){
        Square move = null;
        if(sq1.getValue() == 0){move = sq1;}
        if(sq2.getValue() == 0){move = sq2;}
        if(sq3.getValue() == 0){move = sq3;}
        return move;
    }
    private Square checkDanger(){
        Square selection = null;
        //First row
        if(dangerous(game[0][0], game[0][1], game[0][2])){
            selection = findMove(game[0][0], game[0][1], game[0][2]);
        }
        //Second row
        else if(dangerous(game[1][0], game[1][1], game[1][2])){
            selection = findMove(game[1][0], game[1][1], game[1][2]);
        }
        //Third row
        else if(dangerous(game[2][0], game[2][1], game[2][2])){
            selection = findMove(game[2][0], game[2][1], game[2][2]);
        }
        //First column
        else if(dangerous(game[0][0], game[1][0], game[2][0])){
            selection = findMove(game[0][0], game[1][0], game[2][0]);
        }
        //Seocnd column
        else if(dangerous(game[0][1], game[1][1], game[2][1])){
            selection = findMove(game[0][1], game[1][1], game[2][1]);
        }
        //Third column
        else if(dangerous(game[0][2], game[1][2], game[2][2])){
            selection = findMove(game[0][2], game[1][2], game[2][2]);
        }
        //Top left to bottom right
        else if(dangerous(game[0][0], game[1][1], game[2][2])){
            selection = findMove(game[0][0], game[1][1], game[2][2]);
        }
        //Top right to bottom left
        else if(dangerous(game[0][2], game[1][1], game[2][0])){
            selection = findMove(game[0][2], game[1][1], game[2][0]);
        }
        else{
            selection = randSquare();
        }
        return selection;
    }
    private boolean safe(Square sq1, Square sq2, Square sq3){
        boolean safe = false;
        int v1 = sq1.getValue();
        int v2 = sq2.getValue();
        int v3 = sq3.getValue();
        
        if(v1 == 1){safe = false;}
        else if(v2 == 1){safe = false;}
        else if(v3 == 1){safe = false;}
        else if(v1 + v2 + v3 == 4){safe = true;}
        
        return safe;
    }
    private Square findWin(Square sq1, Square sq2, Square sq3){
        Square win = null;
        if(sq1.getValue() == 0){win = sq1;}
        if(sq2.getValue() == 0){win = sq2;}
        if(sq3.getValue() == 0){win = sq3;}
        return win;
    }
    private Square makeMove(){
        Square selection = null;
        //First row
        if(safe(game[0][0], game[0][1], game[0][2])){
            selection = findWin(game[0][0], game[0][1], game[0][2]);
        }
        //Second row
        else if(safe(game[1][0], game[1][1], game[1][2])){
            selection = findWin(game[1][0], game[1][1], game[1][2]);
        }
        //Third row
        else if(safe(game[2][0], game[2][1], game[2][2])){
            selection = findWin(game[2][0], game[2][1], game[2][2]);
        }
        //First column
        else if(safe(game[0][0], game[1][0], game[2][0])){
            selection = findWin(game[0][0], game[1][0], game[2][0]);
        }
        //Seocnd column
        else if(safe(game[0][1], game[1][1], game[2][1])){
            selection = findWin(game[0][1], game[1][1], game[2][1]);
        }
        //Third column
        else if(safe(game[0][2], game[1][2], game[2][2])){
            selection = findWin(game[0][2], game[1][2], game[2][2]);
        }
        //Top left to bottom right
        else if(safe(game[0][0], game[1][1], game[2][2])){
            selection = findWin(game[0][0], game[1][1], game[2][2]);
        }
        //Top right to bottom left
        else if(safe(game[0][2], game[1][1], game[2][0])){
            selection = findWin(game[0][2], game[1][1], game[2][0]);
        }
        else{
            selection = checkDanger();
        }
        return selection;
    }
    
    public void reset(){
        firstChoice = null;
        secondChoice = null;
        turnCounter = 1;
    }
}
