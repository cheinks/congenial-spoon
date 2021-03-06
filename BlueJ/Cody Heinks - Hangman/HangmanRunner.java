
/**
 * Hangman, but without any arrays.
 *
 * @author Cody Heinks
 * @version 10.09.18
 */
import java.util.Scanner;
import java.lang.Math;
public class HangmanRunner
{
    public static void playGame(){
        Scanner scanner = new Scanner(System.in);
        String[] words = {"elastic", "yellow", "object", "knot", "jail",
            "familiar", "truck","save", "torpid", "brush", "boast",
            "measure", "annoyed", "closed", "ruin"};
        String wordToGuess = words[(int)(Math.random()*words.length)];
        int guessLen = wordToGuess.length();
        String guessWord = wordToGuess;
        String newGuessWord = guessWord;
        
        String dashes = "";
        String whatPlayerSees = "";
        String playerGuess = "";
        int guesses = 6;
        boolean win = false;
        
        System.out.println("I'm thinking of a word...");
        for(int i = 0; i < guessLen; i++){
            if(wordToGuess.charAt(i) == ' '){dashes += " ";}else{dashes += "_";}
        }
        String restOfPhrase = dashes;
        System.out.println(dashes);
        while(guesses > 0){
            System.out.println("Guess a letter:");
            playerGuess = scanner.nextLine();
            if(playerGuess.toLowerCase().equals(wordToGuess.toLowerCase())){
                System.out.println("Wow, you guessed it.");
                System.out.println("My word was " + wordToGuess + ".");
                guesses = 0;
                win = true;
            }
            int loc = guessWord.indexOf(playerGuess);
            if(loc >= 0 && !win){
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
                if(whatPlayerSees.equals(wordToGuess)){
                    guesses = 0;
                    System.out.println("Congrats! You won.");
                    System.out.println("My word was " + wordToGuess + ".");
                }
                dashes = whatPlayerSees;
                restOfPhrase = dashes;
                whatPlayerSees = "";
                guessWord.replaceAll(playerGuess, "_");
                newGuessWord = guessWord;
            }else{
                if(!win){
                    guesses--;
                    System.out.println("Guesses remaining: " + guesses);
                }  
            }
        }
    }
}
