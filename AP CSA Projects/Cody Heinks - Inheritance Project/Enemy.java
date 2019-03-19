
/**
 * Write a description of class Enemy here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Enemy extends Character{
    String name;
    private int health; private boolean alive = true;
    private int atk;
    private int def;
    private int gold;
    
    private String battle;
    public Enemy(String name, int health, int attack, int defense, int gold, String battle){
        super(name, health, attack, defense, gold);
        this.battle = battle;
    }
    
    public String getBattle(){return battle;}
}
