
/**
 * Write a description of class HangmanRunner here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class HangmanRunner
{
    public static void playGame(){
        Scanner scanner = new Scanner(System.in);
        String guessWord = "helloworld";
        System.out.println(guessWord);
        String whatPlayerSees = "";
        int guessLen = guessWord.length();
        String playerGuess = "";
        int guesses = 6;
        
        String restOfPhrase = guessWord;
        
        System.out.println("I'm thinking of a word...");
        System.out.println(guessWord);
        for(int i = 0; i < guessLen; i++){
            System.out.print("_");
        }
        System.out.println();
        while(guesses > 0){
            System.out.println("Guess a letter:");
            playerGuess = scanner.next();
            if(guessWord.contains(playerGuess)){
                int location = guessWord.indexOf(playerGuess);
                while(location >= 0){
                    guessWord = restOfPhrase;
                    whatPlayerSees += guessWord.substring(0, location);
                    restOfPhrase = guessWord.substring(location + 1);
                    whatPlayerSees += "_";
                    location = restOfPhrase.indexOf(playerGuess);
                }
                whatPlayerSees += restOfPhrase;
                System.out.println(whatPlayerSees);
            }else{
                guesses--;
                System.out.println("Guesses remaining: " + guesses);
            }
            guessWord = whatPlayerSees;
        }
    }
}
