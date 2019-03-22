
/**
 * Write a description of class Enemy here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
public class Enemy extends Character{
    String name;
    private int health; private boolean alive = true;
    private int atk;
    private int def;
    private int gold;
    public Enemy(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
    }
    
    public int special(Character target){
        System.out.println("The enemy activates their special!");
        return 0;
    }
}
