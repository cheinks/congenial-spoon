
/**
 * Write a description of class Beast here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Beast extends Enemy{
    private boolean rage;
    public Beast(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
        rage = false;
    }
    
    @Override
    public int special(Character target){
        System.out.println("The beast becomes enraged!");
        if(!rage){
            atk *= 2;
            def /= 2;
            rage = true;
        }
        return 0;
    }
}
