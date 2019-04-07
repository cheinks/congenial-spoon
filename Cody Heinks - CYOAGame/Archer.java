
/**
 * Write a description of class Archer here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Archer extends Human{
    public Archer(String name, int health, int attack, int defense, int gold, String threat){
        super(name, health, attack, defense, gold, threat);
    }
    
    @Override
    public int special(Character target){
        System.out.println("The archer shoots an arrow, but it flies over your head.");
        return 0;
    }
}
