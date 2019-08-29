
/**
 * Write a description of class Weapon here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public abstract class Weapon extends Item{
    protected int damage;
    public Weapon(String keyword, String name, int value, int damage){
        super(keyword, name, value);
        this.damage = damage;
    }
    
    public int getDamage(){return damage;}
}
