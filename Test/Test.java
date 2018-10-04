
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
        String before;
        String after;
        System.out.println(guessWord);
        String whatPlayerSees = "";
        String dashes = "";
        String restOfPhrase = "";
        int guessLen = guessWord.length();
        String playerGuess = "";
        int guesses = 6;
        
        System.out.println("I'm thinking of a word...");
        System.out.println("Word to guess: " + guessWord);
        for(int i = 0; i < guessLen; i++){
            dashes += "_";
            restOfPhrase += "_";
        }
        System.out.println(dashes);
        
        while(guesses > 0){
            System.out.println("Guess a letter:");
            playerGuess = scanner.next();
            int location = guessWord.indexOf(playerGuess);
            
            if(location >= 0){
                while(location >= 0){
                    dashes = restOfPhrase;
                    //System.out.println(dashes.substring(0, location));
                    whatPlayerSees += dashes.substring(0, location);
                    whatPlayerSees += playerGuess;
                    //System.out.println(dashes.substring(location + 1));
                    restOfPhrase = dashes.substring(location + 1);
                    
                    before = guessWord.substring(0, location);
                    after = guessWord.substring(location + 1);
                    guessWord = before + "_" + after;
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
