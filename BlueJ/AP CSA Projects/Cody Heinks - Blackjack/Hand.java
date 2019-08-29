
/**
 * Write a description of class Hand here.
 *
 * @author Cody Heinks
 * @version 9.14.18
 */
public class Hand{
    private int card1;
    private int card2;
    private int total;
    private String hand;
    private boolean bust;
    
    public Hand(){
        card1 = (int)(Math.random() * 11) + 1;
        card2 = (int)(Math.random() * 11) + 1;
        total = card1 + card2;
        hand = "" + card1 + " " + card2 + " ";
        bust = false;
    }
    
    public int getCard1(){return card1;}
    public int getCard2(){return card2;}
    public int getTotal(){return total;}
    public String getHand(){return hand;}
    public boolean getBust(){return bust;}
    
    public void setCard1(int card){card1 = card;}
    public void setCard2(int card){card2 = card;}
    public void addTotal(int newCard){total += newCard; 
        if(total > 21){bust = true;}
    }
    public void addCard(String newCard){hand = hand + newCard;}
    public void busted(){bust = true;}
    
    
}
