
/**
 * Write a description of class Boss here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Boss extends Enemy{
    public Boss(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
    }
    
    @Override
    public int special(Character target){
        return 0;
    }
    
    public void passive(){
        System.out.println("Boss activates passive ability.");
    }
}
