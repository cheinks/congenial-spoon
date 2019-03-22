
/**
 * Write a description of class Dragon here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Dragon extends Enemy{
    public Dragon(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
    }
    
    @Override
    public int special(Character target){
        target.setCondition("burning");
        System.out.print("The dragon spews fire! You are now burning.");
        return 0;
    }
}
