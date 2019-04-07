
/**
 * Write a description of class Sword here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Sword extends Primary{
    public Sword(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("With three quick slashes at the enemy, " 
        + "you deal " + damage + "damage.");
    }
}
