
/**
 * public class Character - write a description of the class here
 *
 * @author Cody Heinks
 * @version (version number or date here)
 */
public class Character implements WeaponInterface, DefenseCommands{
    String name;
    int health; private boolean alive = true;
    int atk;
    int def;
    private int gold;

    public Character(String name, int health, int attack, int defense, int gold){
        this.name = name;
        this.health = health;
        atk = attack;
        def = defense;
        this.gold = gold;
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
    
    public void addGold(int amount){
        gold += amount;
    }
    public void takeGold(int amount){
        gold -= amount;
    }
    
    public boolean isAlive(){return alive;}
    public void kill(){alive = false;}
}
