
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Test
{
    public static void test1(){
        Scanner scanner = new Scanner(System.in);
        String guessWord = "Hello world!";
        System.out.println(guessWord);
        String whatPlayerSees = "";
        String whatComputerSees = "";
        int guessLen = guessWord.length();
        String playerGuess = "";
        int guesses = 6;
        
        System.out.println("I'm thinking of a word...");
        System.out.println();
        for(int i = 0; i < guessLen; i++)
        {
           System.out.print("_");
           whatPlayerSees += "_";
        }
        System.out.println();
        while(guesses > 0)
        {
            whatComputerSees = "";
            System.out.println("Guess a letter:");
            playerGuess = scanner.next();
            for(int i = 0; i < guessLen; i++)
            {
                String original = guessWord.substring(i, i + 1);
                if(playerGuess.equals(original))
                {
                    whatComputerSees += playerGuess;
                }else{
                    whatComputerSees += "_";
                }
                if(whatComputerSees.equals(whatPlayerSees))
                {
                    guesses--;
                }else{
                    whatPlayerSees = whatComputerSees;
                }
            }
            System.out.println(whatPlayerSees);
        }
    }
}
