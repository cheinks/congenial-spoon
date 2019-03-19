
/**
 * Write a description of class Armor here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Armor extends Item{
    String name;
    int value;
    
    private int durability;
    private String bodyPart;
    public Armor(String keyword, String name, int value, int dur, String bodyPart){
        super(keyword, name, value);
        durability = dur;
        this.bodyPart = bodyPart;
    }
    
    public int getDefense(){return durability;}
    
    public String getBodyPart(){return bodyPart;}
}
