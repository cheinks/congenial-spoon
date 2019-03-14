
/**
 * Write a description of class Armor here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Armor extends Item implements DefenseCommands{
    String name;
    String description;
    int value;
    
    int defense;
    
    public Armor(String name, String description, int value, int def){
        super(name, description, value);
        defense = def;
    }
    
    public boolean blocked(){
        return true;
    }
}
