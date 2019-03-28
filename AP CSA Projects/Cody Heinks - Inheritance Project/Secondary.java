
/**
 * Write a description of class Secondary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Secondary extends Weapon{
    String name;
    int value;
    int damage;
    public Secondary(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
    }
    
    public void attack(int damage){
        System.out.println("You attack with your secondary weapon.");
    }
}
