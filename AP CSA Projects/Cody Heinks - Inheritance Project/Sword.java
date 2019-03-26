
/**
 * Write a description of class Sword here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Sword extends Primary{
    public Sword(String keyword, String name, int value, int damage, String fatality){
        super(keyword, name, value, damage);
        super.setFatal("With one swift lunge, you impale the enemy with your sword. " 
        + "You brandish the bloodstained sword, with one foot resting on their fallen skull.");
    }
    
    
}
