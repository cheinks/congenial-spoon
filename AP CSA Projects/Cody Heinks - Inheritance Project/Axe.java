
/**
 * Write a description of class Axe here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Axe extends Primary{
    public Axe(String keyword, String name, int value, int damage){
        super(keyword, name, value, damage);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("Raising the " + name + " above your head, you slam it down "
        + "and deal "+ damage + "damage.");
    }
}
