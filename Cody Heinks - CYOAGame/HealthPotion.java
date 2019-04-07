
/**
 * Write a description of class HealthPotion here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class HealthPotion extends Potion{
    public HealthPotion(String keyword, String name, int value, int strength){
        super(keyword, name, value, strength);
    }
    
    @Override
    public boolean interact(Character target){
        System.out.println("You drink the health potion and gain " + 
        strength + " health.");
        target.changeHealth(strength);
        return true;
    }
}
