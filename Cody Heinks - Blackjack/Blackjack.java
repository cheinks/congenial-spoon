
/**
 * Write a description of class Blackjack here.
 *
 * @author Cody Heinks
 * @version 9.10.18
 */
import java.util.Scanner;
public class Blackjack
{
    public static void playGame(){
        Hand playerHand = new Hand(2);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("When you are ready to play, press enter.");
        String begin = scanner.next();
        boolean playing = true;
        while(playing){
            System.out.println("Your hand:");
            
            System.out.println("Dealer hand:");
        }
    }
}
