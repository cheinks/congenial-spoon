
/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon extends Item implements WeaponInterface{
    String name;
    String description;
    int value;
    
    int damage;
    
    public Weapon(String name, String description, int value, int damage){
        super(name, description, value);
        this.damage = damage;
    }
    
    public boolean parry(){
        return false;
    }
    public int attack(){
        return damage;
    }
}
