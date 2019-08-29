
/**
 * Write a description of class StrengthPotion here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class StrengthPotion extends Potion{
    public StrengthPotion(String keyword, String name, int value, int strength){
        super(keyword, name, value, strength);
    }
    
    @Override
    public boolean interact(Character target){
        System.out.println("You drink the strength potion and gain " + 
        strength + " attack.");
        target.changeAtk(strength);
        return true;
    }
}
