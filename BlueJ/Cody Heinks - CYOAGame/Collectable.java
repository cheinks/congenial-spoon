
/**
 * Write a description of class Collectable here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Collectable extends Item{
    String desc;
    Collectable(String keyword, String name, int value, String description){
        super(keyword, name, value);
        desc = description;
    }
    
    public String getDesc(){return desc;}
}
