
/**
 * Write a description of class Spellbook here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Spellbook extends Secondary{
    private String name;
    public Spellbook(String keyword, String name, int value){
        super(keyword, name, value);
    }
    
    @Override
    public void attack(int damage){
        System.out.println("You cast a fireball at the enemy. They lose " + damage + " health.");
    }
}
