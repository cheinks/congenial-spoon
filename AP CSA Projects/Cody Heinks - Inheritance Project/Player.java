
/**
 * Write a description of class Player here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Player extends Character{
    Backpack inventory = new Backpack();
    Primary primary = new Hand(10);
    Secondary offHand = new Foot();
    Armor[] armor = new Armor[4];
    //Room location;
    public Player(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
        //this.location = location;
    }
    
    @Override
    public int attack(Character target){
        int finalDamage = super.attack(target);
        if(finalDamage > 0){
            primary.attack(finalDamage);
        }else if(finalDamage == 0){
            System.out.println("Your attack was blocked!");
        }else if(finalDamage < 0){
            changeHealth(finalDamage);
            System.out.println("They enemy parries! You lose " + finalDamage + "health.");
        }
        return finalDamage;
    }
    @Override
    public void parry(int damage){
        offHand.attack(damage);
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
        System.out.println("Health: " + currentHP);
        System.out.println("Attack: " + atk);
        System.out.println("Defense: " + def);
    }
}
