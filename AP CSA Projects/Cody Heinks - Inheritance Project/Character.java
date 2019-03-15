
/**
 * public class Character - write a description of the class here
 *
 * @author Cody Heinks
 * @version (version number or date here)
 */
public class Character implements WeaponInterface, DefenseCommands{
    String name;
    int health; boolean alive = true;
    Backpack inventory;
    int atk = 10;
    int def = 10;
    Weapon primary = null;
    Weapon offHand = null;
    Armor[] armor = new Armor[4];
    Room location;

    public Character(String name, int health, int attack, int defense, Room location){
        this.name = name;
        this.health = health;
        atk = attack;
        def = defense;
        this.location = location;
        inventory = new Backpack();
    }

    public boolean parry(int damage){
        return damage < def;
    }
    public boolean blocked(int damage){
        return damage == def;
    }
    public int attack(Character target){
        return target.takeDamage(atk);
    }

    public int takeDamage(int damage){
        int finalDamage = damage;
        if(parry(damage)){
            finalDamage -= def; //Should be negative
        }else if(blocked(damage)){
            finalDamage = 0; //Blocked
        }else{
            finalDamage = damage - def;
            health -= finalDamage; //Lose difference in health
        }

        if(health <= 0){
            alive = false;
        }
        return finalDamage;
    }

    public void pickUp(Item item){

    }

    public void equip(Item item){

    }
    
    public void move(String direction){
        Room newLoc = location.getPath(direction);
        if(newLoc == null){
            System.out.println("You can't go that way.");
        }else{
            location = newLoc;
        }
        
    }
}
