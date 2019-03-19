
/**
 * Write a description of class Consumable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Consumable extends Item{
    String keyword;
    String name;
    String description;
    int value;
    public Consumable(String keyword, String name, int value){
        super(keyword, name, value);
    }
    
    public void interact(String command){
        System.out.println("You use " + name);
    }
}
