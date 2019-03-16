
/**
 * Write a description of class Player here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Player extends Character{
    String name;
    int health; boolean alive = true;
    int atk;
    int def;
    int gold;
    
    Backpack inventory = new Backpack();
    Weapon primary = null;
    Weapon offHand = null;
    Armor[] armor = new Armor[4];
    Room location;
    
    public Player(String name, int health, int attack, int defense, int gold, Room location){
        super(name, health, attack, defense, gold);
        this.location = location;
    }
    
    public void take(Item item){
        inventory.storeItem(item);
    }
    
    public void move(){
        
    }
    
    public void viewStats(){
        System.out.println(name);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
    }
    
}
