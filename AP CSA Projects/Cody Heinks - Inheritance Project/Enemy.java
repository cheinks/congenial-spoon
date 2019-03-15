
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
    Room location;
    private String battle;
    public Enemy(String name, int health, int attack, int defense, Room location, String battle){
        super(name, health, attack, defense, location);
        this.battle = battle;
    }
    
    public String getBattle(){return battle;}
}
