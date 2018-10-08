
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
        int guessLen = guessWord.length();
        String newGuessWord = guessWord;
        System.out.println(guessWord);
        
        String dashes = "";
        String whatPlayerSees = "";
        String playerGuess = "";
        int guesses = 6;
        
        System.out.println("I'm thinking of a word...");
        System.out.println("Word to guess: " + guessWord);
        for(int i = 0; i < guessLen; i++){
            System.out.print("_");
            dashes += "_";
        }
        String restOfPhrase = dashes;
        System.out.println();
        while(guesses > 0){
            System.out.println("Guess a letter:");
            playerGuess = scanner.nextLine();
            int loc = guessWord.indexOf(playerGuess);
            if(loc >= 0){
                while(loc >= 0){
                    guessWord = newGuessWord;
                    dashes = restOfPhrase;
                    whatPlayerSees += dashes.substring(0, loc);
                    restOfPhrase = dashes.substring(loc + 1);
                    whatPlayerSees += playerGuess;
                    newGuessWord = guessWord.substring(0, loc) + "_" + guessWord.substring(loc + 1);
                    System.out.println(newGuessWord);
                    loc = newGuessWord.indexOf(playerGuess);
                    System.out.println("New loc: " + loc);
                    System.out.println(restOfPhrase);
                }
                whatPlayerSees += restOfPhrase;
                System.out.println(whatPlayerSees);
                dashes = whatPlayerSees;
                restOfPhrase = dashes;
                whatPlayerSees = "";
            }else{
                guesses--;
                System.out.println("Guesses remaining: " + guesses);
            }
        }
    }
}
