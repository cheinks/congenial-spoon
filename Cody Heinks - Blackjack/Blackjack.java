
/**
 * Write a description of class Blackjack here.
 *
 * @author Cody Heinks
 * @version 9.11.18
 */
import java.util.Scanner;
public class Blackjack
{
    /*
     * String str1 = "hit"
     * String str2 = "hit"
     * str1 == str2 //False
     * str1.equals(str2) //True
     */
    public static void playGame(){
        Hand playerHand = new Hand();
        int playerTotal = playerHand.getValue();
        Hand dealerHand = new Hand();
        int dealerTotal = dealerHand.getValue();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("When you are ready to play, type 'begin' and press enter.");
        String begin = scanner.next();
        boolean playing = true;
        boolean hit;
        int response;
        System.out.println("The dealer is showing a " + dealerHand.getCard2);
        while(playing){
            hit = false;
            System.out.println("Your hand:");
            System.out.println(playerHand.getHand());
            System.out.println();
            if(playerTotal < 22){
                System.out.println("Would you like a hit? Yes(1)/No(2)");
                response = scanner.nextInt();
                if(response == 1){
                    hit = true;
                }else{hit = false;}
            }
            if(hit){
                int rand = (int)(Math.random() * 11) + 1;
                playerHand.setValue(rand);
                playerHand.setHand("" + rand + " ");
            }else{
                if(playerTotal<22){
                    System.out.println("Your hand:");
                    System.out.println(playerHand.getHand());
                    System.out.println();
                    while(dealerTotal < 17){
                        int rand = (int)(Math.random() * 11) + 1;
                        dealerHand.setValue(rand);
                        dealerHand.setHand("" + rand + " ");
                        System.out.println("Dealer hand:");
                        System.out.println(dealerHand.getHand());
                        dealerTotal = dealerHand.getValue();
                    }
                    if(playerTotal > dealerTotal && dealerTotal < 22){
                        System.out.println("You won!");
                    }
                    else if(dealerTotal > playerTotal){
                        System.out.println("You lost!");
                    }
                    else{
                        System.out.println("It's a tie!");
                    }
                    playing = false;
                }else{
                    System.out.println("Darn! You busted.");
                
                    playing = false;
                }
            }
        }
    }
}
