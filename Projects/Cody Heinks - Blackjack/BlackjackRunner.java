
/**
 * Write a description of class BlackjackRunner here.
 *
 * @author Cody Heinks
 * @version 9.14.18
 */
import java.util.Scanner;
public class BlackjackRunner{
    public static void playGame(){
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Welcome! Here to play some Blackjack I see.");
        System.out.println("Type 'begin' when you're ready.");
        String begin = scanner2.next();
        boolean playing = true;
        while(playing){
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            Scanner scanner = new Scanner(System.in);
            
            boolean dealersTurn = true;
            boolean playersTurn = true;
            String response;
            System.out.println("The dealer is showing " + dealerHand.getCard2() + ".");
            while(playersTurn){
                System.out.println();
                System.out.println("Your hand:");
                System.out.println(playerHand.getHand());
                System.out.println();
                if(playerHand.getBust()){
                    System.out.println("Darn! You busted");
                    playersTurn = false;
                    dealersTurn = false;
                }else{
                System.out.println("Would you like to hit?");
                response = scanner.next().toLowerCase();
                if(response.equals("hit") || response.equals("yes")){
                    int rand = (int)(Math.random() * 11) + 1;
                    playerHand.addTotal(rand);
                    playerHand.addCard("" + rand + " ");
                }else{playersTurn = false;}
                }
            }
            if(dealersTurn){
                System.out.println();
                System.out.println("Your hand:");
                System.out.println(playerHand.getHand());
                System.out.println();
                System.out.println("Dealer hand:");
                System.out.print(dealerHand.getHand());
                int dealerTotal = dealerHand.getTotal(); 
                while(dealerTotal < 17){
                    int rand = (int)(Math.random() * 11) + 1;
                    dealerHand.addTotal(rand);
                    dealerHand.addCard("" + rand + " ");
                    System.out.print(rand + " ");
                    dealerTotal = dealerHand.getTotal();
                }
                System.out.println();
                System.out.println();
                int playerTotal = playerHand.getTotal();
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
                    System.out.println("You push.");
                }
                dealersTurn = false;
            }
            System.out.println();
            System.out.println("Would you like to play again? (yes/no)");
            begin = scanner2.next().toLowerCase();
            if(begin.equals("yes")){playing = true; System.out.println();}else{playing = false;}
        }
    }
}
