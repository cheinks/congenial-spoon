
/**
 * Write a description of class MinesweeperRunner here.
 *
 * @author Cody Heinks
 * @version 11.14.18
 */
import java.lang.Math;
public class MinesweeperRunner{
    static int difficulty;
    public static void playGame(){
        difficulty = (int)(Math.random()*5 + 1);
        MinesweeperBoard2 board = new MinesweeperBoard2(difficulty);
    }
}
