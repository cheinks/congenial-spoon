
/**
 * Write a description of class Shield here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Shield extends Secondary{
    public Shield(String keyword, String name, int value){
        super(keyword, name, value);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("You raise your shield to take the hit, then jab " 
        + "back, dealing " + damage + " damage.");
    }
}
