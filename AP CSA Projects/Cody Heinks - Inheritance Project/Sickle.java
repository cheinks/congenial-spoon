
/**
 * Write a description of class Sickle here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Sickle extends Primary{
    private String name;
    public Sickle(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("With a grand swipe, you deal " + damage + " damage.");
    }
}
