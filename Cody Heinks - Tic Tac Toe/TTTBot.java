
/**
 * Write a description of class TTTBot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
public class TTTBot{
    int mode;
    Square[][] game;
    Square selection;
    
    public TTTBot(int difficulty, Square[][] b){
        mode = difficulty;
        game = b;
    }
    
    public void takeTurn(){
        boolean searching = true;
        if(mode == 0){
            
        }else if(mode == 1){
            while(searching){
                int row = (int)(Math.random()*3);
                int col = (int)(Math.random()*3);
                selection = game[row][col];
                if(selection.getValue() == 0){searching = false;}
                selection.checkSquare();
            }
        }else if(mode == 2){
        
        }else if(mode == 3){
            
        }
    }
}
