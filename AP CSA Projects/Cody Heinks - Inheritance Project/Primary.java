
/**
 * Write a description of class Primary here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Primary extends Weapon{
    String name;
    int value;
    int damage;
    public Primary(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
    }
    
    public void attack(int damage){
        System.out.println("You attack with your primary weapon.");
    }
}
