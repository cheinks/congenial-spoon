
/**
 * Write a description of class GameRunner here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;
public class GameRunner{
    public static void playGame(String[] args){
        Scanner mainScanner = new Scanner(System.in);
        Room start = new Room("The Beginning", "asdf", null, null, null, null, new ArrayList<Item>());
        Room s1;
        Room s2;
        Room s3;
        Room s4;
        
        Character player1 = new Character("Player 1", 100, 10, 10, start);
        String userInput;
        while(player1.alive){
            System.out.println(player1.location.getName());
            System.out.println(player1.location.getDesc());
            userInput = mainScanner.nextLine();
            player1.move(userInput);
            
            player1.alive = false;
        }
        
    }
}
