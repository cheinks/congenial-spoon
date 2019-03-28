
/**
 * Write a description of class Enemy here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
public abstract class Enemy extends Character{
    String name;
    private int health; private boolean alive = true;
    private int atk;
    private int def;
    private int gold;
    public Enemy(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
    }
    
    @Override
    public int attack(Character target){
        int ranNum = (int)(1 + Math.random()*10);
        int finalDamage = 0;
        if(ranNum <= 3){
            return special(target);
        }else{
            finalDamage = super.attack(target);
        }
        
        if(finalDamage < 0){
            changeHealth(finalDamage);
            target.parry(-finalDamage);
        }
        return finalDamage;
    }
    
    public int special(Character target){
        System.out.println("The enemy activates their special!");
        return 0;
    }
}
