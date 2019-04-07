
/**
 * Write a description of class Foot here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Foot extends Secondary{
    private String name;
    public Foot(){
        super("", "", 0);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("You deflect your opponent's attack, then sparta " 
        + "kick them to the ground." + "They lose " + damage + " health.");
    }
}
