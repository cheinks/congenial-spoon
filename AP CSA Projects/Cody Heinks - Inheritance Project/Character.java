
/**
 * public class Character - write a description of the class here
 *
 * @author Cody Heinks
 * @version (version number or date here)
 */
import java.util.ArrayList;
public abstract class Character implements WeaponInterface, DefenseCommands{
    String name;
    ArrayList<String> conditions;
    private final int baseHP;
    private int currentHP; private boolean alive = true;
    private int atk;
    private int def;
    private int gold;
    public Character(String name, int health, int attack, int defense, int gold){
        this.name = name;
        this.conditions = new ArrayList<String>();
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
    
    //Accessors/Mutators
    public String getName(){return name;}
    
    public void setCondition(String newCond){conditions.add(newCond);}
    public void removeCondition(String oldCond){
        int index = -1;
        for(int i = 0; i < conditions.size(); i++){
            if(conditions.get(i).equals(oldCond)){
                index = i;
            }
        }
        try{conditions.remove(index);}catch(IndexOutOfBoundsException e){}
    }
    public void checkCondition(String action){
        if(action.equals("ATK")){
            
        }else if(action.equals("DEF")){
            
        }else if(action.equals("HP")){
            
        }
    }
    
    public int getBaseHP(){return baseHP;}
    public void changeHealth(int amount){currentHP += amount;}
    public boolean isAlive(){return alive;}
    public void kill(){alive = false;}
    
    public int getAtk(){return atk;}
    public void changeAtk(int amount){atk += amount;}
    
    public int getDef(){return def;}
    public void changeDef(int amount){def += amount;}
    
    public int getGold(){return gold;}
    public void setGold(int newGold){gold = newGold;}
}
