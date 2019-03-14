
/**
 * Write a description of class Weapon here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Weapon extends Item{
    String name;
    String description;
    int value;
    
    int damage;
    
    public Weapon(String name, String description, int value, int damage){
        super(name, description, value);
        this.damage = damage;
    }
}
