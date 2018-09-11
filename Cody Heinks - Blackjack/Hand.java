
/**
 * Write a description of class Hand here.
 *
 * @author Cody Heinks
 * @version 9.10.18
 */
import java.lang.Math;
public class Hand
{
    private int numCards;
    private int handValue;
    private String hand;
    //private int
    
    //Constructors
    public Hand(){
        numCards = 2;
        handValue = 0;
        hand = "";
    }
    
    //Accessors
    public int getCards(){
        return numCards;
    }
    public int getValue(){
        return handValue;
    }
    public String getHand(){
        return hand;
    }
    
    //Mutators
    public void setCards(int cards){
        numCards = cards;
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
