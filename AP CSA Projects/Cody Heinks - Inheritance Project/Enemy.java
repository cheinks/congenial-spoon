
/**
 * Write a description of class Enemy here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Enemy extends Character{
    String name;
    int health; boolean alive = true;
    int atk;
    int def;
    int gold;
    
    private String battleCry;
    public Enemy(String name, int health, int attack, int defense, int gold, String battle){
        super(name, health, attack, defense, gold);
        battleCry = battle;
    }
    
    public String getBattle(){return battleCry;}
}
