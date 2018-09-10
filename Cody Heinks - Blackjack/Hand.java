
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
    //private int
    
    //Constructors
    public Hand(int value){
        numCards = value;
    }
    public Hand(){
        numCards = (int)(Math.random() * 11) + 1;
    }
    
    //Accessors
    public int getCards(){
        return numCards;
    }
    
    //Mutators
    public void setCards(int cards){
        numCards = cards;
    }
    
    //Methods
    public static void randNum(){
        int rand = (int)(Math.random() * 11) + 1;
        System.out.println(rand);
    }
    
}
