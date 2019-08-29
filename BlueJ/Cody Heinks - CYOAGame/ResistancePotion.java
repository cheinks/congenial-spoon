
/**
 * Write a description of class ResistancePotion here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class ResistancePotion extends Potion{
    public ResistancePotion(String keyword, String name, int value, int strength){
        super(keyword, name, value, strength);
    }
    
    @Override
    public boolean interact(Character target){
        System.out.println("You drink the resistance potion and gain " + 
        strength + " defense.");
        target.changeDef(strength);
        return true;
    }
}
