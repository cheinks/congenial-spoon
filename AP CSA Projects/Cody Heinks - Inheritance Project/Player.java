
/**
 * Write a description of class Player here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Player extends Character{
    String name;
    private int baseHealth;
    private int health; private boolean alive = true;
    private int atk;
    private int def; //Armor
    private int gold;
    
    Backpack inventory = new Backpack();
    Primary primary = null;
    Secondary offHand = null;
    Armor[] armor = new Armor[4];
    //Room location;
    public Player(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
        baseHealth = health;
        //this.location = location;
    }
    
    public void take(Item item){
        if(item instanceof Consumable){
            inventory.storeItem(item);
        }else{
            equip(item);
        }
    }
    public void equip(Item item){
        
    }
    
    //public void move(){}
    
    public void viewStats(){
        System.out.println(name);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
    }
}
