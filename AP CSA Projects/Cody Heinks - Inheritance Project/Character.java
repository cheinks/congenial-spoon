
/**
 * public class Character - write a description of the class here
 *
 * @author Cody Heinks
 * @version (version number or date here)
 */
public abstract class Character implements WeaponInterface, DefenseCommands{
    String name;
    private final int baseHP;
    private int currentHP; private boolean alive = true;
    private int atk;
    private int def;
    private int gold;
    public Character(String name, int health, int attack, int defense, int gold){
        this.name = name;
        baseHP = health;
        currentHP = health;
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
            currentHP -= finalDamage; //Lose difference in health
        }

        if(currentHP <= 0){
            kill();
        }
        return finalDamage;
    }
    
    public String getName(){return name;}
    
    public void changeHealth(int amount){
        currentHP += amount;
    }
    
    public boolean isAlive(){return alive;}
    public void kill(){alive = false;}
    
    public int getGold(){return gold;}
    public void changeGold(int amount){
        gold += amount;
    }   
}
