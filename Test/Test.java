
/**
 * Write a description of class HangmanRunner here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Test
{
    public static void playGame(){
        Scanner scanner = new Scanner(System.in);
        String guessWord = "helloworld";
        System.out.println(guessWord);
        String whatPlayerSees = "";
        String dashes = "";
        int guessLen = guessWord.length();
        String playerGuess = "";
        int guesses = 6;
        
        String restOfPhrase = dashes;
        
        System.out.println("I'm thinking of a word...");
        System.out.println("Word to guess: " + guessWord);
        for(int i = 0; i < guessLen; i++){
            dashes += "_";
            System.out.print(dashes);
        }
        System.out.println();
        while(guesses > 0){
            System.out.println("Guess a letter:");
            playerGuess = scanner.nextLine();
            int location = guessWord.indexOf(playerGuess);
            String wordTracker = "";
            //System.out.println("Word to guess: " + guessWord);
            //System.out.println(location);
            if(location >= 0){
                while(location >= 0){
                    dashes = restOfPhrase;
                    whatPlayerSees += dashes.substring(0, location);
                    restOfPhrase = dashes.substring(location + 1);
                    whatPlayerSees += playerGuess;
                    
                    location = guessWord.indexOf(playerGuess);
                    //System.out.println("New loc: " + location);
                }
                whatPlayerSees += restOfPhrase;
                System.out.println(whatPlayerSees);
                guessWord = whatPlayerSees;
                restOfPhrase = guessWord;
                whatPlayerSees = "";
            }else{
                guesses--;
                System.out.println("Guesses remaining: " + guesses);
            }
            
        }
    }
}
