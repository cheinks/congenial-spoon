/**
 * Write a description of class Blackjack here.
 *
 * @author Cody Heinks
 * @version 9.11.18
 */
import java.util.Scanner;
public class Blackjack
{
    public static void playGame(){
        Hand playerHand = new Hand();
<<<<<<< HEAD
        Hand dealerHand = new Hand();
=======
        int playerTotal = playerHand.getValue();
        Hand dealerHand = new Hand();
        int dealerTotal = dealerHand.getValue();
>>>>>>> 2a6ac82db6eff28acdf357016631ae997fb881fc
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("When you are ready to play, type 'begin' and press enter.");
        String begin = scanner.next();
        boolean playing = true;
        boolean hit;
<<<<<<< HEAD
        String response;
        System.out.println("The dealer is showing a " + dealerHand.getCard2() + ".");
=======
        int response;
        System.out.println("The dealer is showing a " + dealerHand.getCard2);
>>>>>>> 2a6ac82db6eff28acdf357016631ae997fb881fc
        while(playing){
            hit = false;
            System.out.println();
            System.out.println("Your hand:");
            System.out.println(playerHand.getHand());
            System.out.println();
<<<<<<< HEAD
            int playerTotal = playerHand.getValue();
=======
>>>>>>> 2a6ac82db6eff28acdf357016631ae997fb881fc
            if(playerTotal < 22){
                System.out.println("Would you like to hit?");
                response = scanner.next().toLowerCase();
                if(response.equals("hit") || response.equals("yes")){hit = true;}else{hit = false;}
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
                    System.out.println("Dealer hand:");
                    System.out.print(dealerHand.getHand());
                    int dealerTotal = dealerHand.getValue(); 
                    while(dealerTotal < 17){
                        int rand = (int)(Math.random() * 11) + 1;
                        dealerHand.setValue(rand);
                        dealerHand.setHand("" + rand + " ");
                        System.out.print(rand + " ");
                        dealerTotal = dealerHand.getValue();
                    }
                    System.out.println();
                    if(dealerTotal > 21){
                        System.out.println("The dealer busted. You won!");
                    }
                    else if(dealerTotal > playerTotal){
                        System.out.println("You lost!");
                    }
                    else if(playerTotal > dealerTotal){
                        System.out.println("You won!");
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