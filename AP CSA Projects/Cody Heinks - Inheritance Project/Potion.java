
/**
 * Write a description of class Potion here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Potion extends Consumable{
    protected int strength;
    public Potion(String keyword, String name, int value, int strength){
        super(keyword, name, value);
        this.strength = strength;
    }
    
    @Override
    public boolean interact(Character target){
        System.out.println("You drink " + name);
        return true;
    }
}
