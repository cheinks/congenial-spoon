
/**
 * The program generates a random number, then gives the user 5 chances to guess the number. 
 * If the guess is incorrect, it prompts the user that they are too low or too high.
 *
 * @author Cody Heinks
 * @version 8.30.18
 */
import java.lang.Math;
import java.util.Scanner;
public class GuessGame
{
    public static int randNum(){
        int rand = (int)(Math.random() * 101) + 100;
        //System.out.println(rand);
        return rand;
    }
    public static void playGame(){
        boolean numNotGuessed = true;
        int guesses = 5;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("I am thinking of a number between 100 and 200...");
        int numToGuess = randNum();
        System.out.println("Got it! Guess my number.");
        while(guesses > 0){
            int playerGuess = scanner.nextInt();
            if(playerGuess > numToGuess){
                System.out.println("Too high. Guess again.");
                guesses--;
            }
            else if(playerGuess < numToGuess){
                System.out.println("Too low. Guess again.");
                guesses--;
            }
            else{
                System.out.println("That's it. You win!");
                guesses = 0;
                numNotGuessed = false;
            }
        }
        if(numNotGuessed){
            System.out.println("Oh, wait, you ran out of guesses. You lose!");
        }
    }
}
