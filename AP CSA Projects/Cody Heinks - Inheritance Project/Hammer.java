
/**
 * Write a description of class Hammer here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Hammer extends Secondary{
    private String name;
    public Hammer(String keyword, String name, int value){
        super(keyword, name, value);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("You dodge the attack and pound the enemy with the " + name + "."
        + " They lose " + damage + " health.");
    }
}
