
/**
 * Write a description of class Hand here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Hand extends Primary{
    private String name;
    public Hand(int damage){
        super("", "", 0, damage);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("Left jab. Right cross. Left uppercut! " 
        + "You deal " + damage + " damage.");
    }
}
