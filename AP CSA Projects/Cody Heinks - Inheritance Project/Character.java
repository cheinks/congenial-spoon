
/**
 * Abstract class Character - write a description of the class here
 *
 * @author Cody Heinks
 * @version (version number or date here)
 */
public abstract class Character implements WeaponInterface, DefenseCommands{
    String name;
    int health; boolean alive = true;
    Backpack inventory;
    int atk = 0;
    int def = 0;
    Weapon primary = null;
    Weapon offHand = null;
    Armor[] armor = new Armor[4];
    
    public Character(String name, int health){
        this.name = name;
        this.health = health;
        inventory = new Backpack();
    }
    
    public boolean parry(){return true;}
    public int attack(){
        return atk;
    }
    
    
    public int takeDamage(int damage){
        int finalDamage = damage;
        if(damage > def){
            health -= (damage - def);
        }else if(damage < def){
            
        }
        
        if(health <= 0){
            alive = false;
        }
        return finalDamage;
    }
    
    public void pickUp(Item item){
        
    }
    
    
}
