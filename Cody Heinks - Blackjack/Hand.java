/**
 * Write a description of class Hand here.
 *
 * @author Cody Heinks
 * @version 9.10.18
 */
import java.lang.Math;
public class Hand
{
    private int card1;
    private int card2;
    private int handValue;
    private String hand;
    
    //Constructors
    public Hand(){
        card1 = (int)(Math.random() * 11) + 1;
        card2 = (int)(Math.random() * 11) + 1;
<<<<<<< HEAD
        handValue = card1 + card2;
=======
        handValue = card1 + card 2;
>>>>>>> 2a6ac82db6eff28acdf357016631ae997fb881fc
        hand = "" + card1 + " " + card2 + " ";
    }
    
    //Accessors
    public int getCard1(){
        return card1;
    }
    public int getCard2(){
        return card2;
    }
    public int getValue(){
        return handValue;
    }
    public String getHand(){
        return hand;
    }
    
    //Mutators
    public void setCard1(int card){
        card1 = card;
    }
    public void setCard2(int card){
        card2 = card;
    }
    public void setValue(int cards){
        handValue += cards;
    }
    public void setHand(String newCards){
        hand = hand + newCards;
    }
    
    //Methods
    public static void randNum(){
        int rand = (int)(Math.random() * 11) + 1;
        System.out.println(rand);
    }
    
}