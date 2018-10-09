
/**
 * Write a description of class HangmanRunner here.
 *
 * @author Cody Heinks
 * @version 10.09.18
 */
import java.util.Scanner;
public class HangmanRunner
{
    public static void playGame(){
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = "hello world";        
        int guessLen = wordToGuess.length();
        String guessWord = wordToGuess;
        String newGuessWord = guessWord;
        
        String dashes = "";
        String whatPlayerSees = "";
        String playerGuess = "";
        int guesses = 6;
        
        System.out.println("I'm thinking of a word...");
        for(int i = 0; i < guessLen; i++){
            if(wordToGuess.charAt(i) == ' '){dashes += " ";}else{dashes += "_";}
        }
        String restOfPhrase = dashes;
        System.out.println(dashes);
        while(guesses > 0){
            System.out.println("Guess a letter:");
            playerGuess = scanner.nextLine();
            int loc = guessWord.indexOf(playerGuess);
            if(loc >= 0){
                while(loc >= 0){
                    dashes = restOfPhrase;
                    whatPlayerSees += dashes.substring(0, loc);
                    restOfPhrase = dashes.substring(loc + 1);
                    whatPlayerSees += playerGuess;
                    newGuessWord = newGuessWord.substring(loc + 1);
                    loc = newGuessWord.indexOf(playerGuess);
                }
                whatPlayerSees += restOfPhrase;
                System.out.println(whatPlayerSees);
                dashes = whatPlayerSees;
                restOfPhrase = dashes;
                whatPlayerSees = "";
                guessWord.replaceAll(playerGuess, "_");
                newGuessWord = guessWord;
            }else{
                guesses--;
                System.out.println("Guesses remaining: " + guesses);
            }
        }
    }
}
