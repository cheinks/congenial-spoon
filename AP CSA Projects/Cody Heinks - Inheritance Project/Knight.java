
/**
 * Write a description of class Knight here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
public class Knight extends Human{
    public Knight(String name, int health, int attack, int defense, int gold, String threat){
        super(name, health, attack, defense, gold, threat);
    }
    
    @Override
    public int special(Character target){
        threaten();
        int recover = (int)(Math.random()*3);
        if(recover == 0){atk += 5;}
        else if(recover == 1){def += 5;}
        else if(recover == 2){currentHP += 5;}
        return 0;
    }
}
