
/**
 * Write a description of class Armor here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Armor extends Item{
    String name;
    int value;
    
    private int defense;
    private String bodyPart;
    public Armor(String keyword, String name, int value, int def, String bodyPart){
        super(keyword, name, value);
        defense = def;
        this.bodyPart = bodyPart;
    }
    
    public int getDefense(){return defense;}
    
    public String getBodyPart(){return bodyPart;}
}
