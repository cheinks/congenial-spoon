
/**
 * Write a description of class Consumable here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Consumable extends Item{
    public Consumable(String keyword, String name, int value){
        super(keyword, name, value);
    }
    
    public boolean interact(Character target){
        System.out.println("You use the " + name);
        return true;
    }
}
