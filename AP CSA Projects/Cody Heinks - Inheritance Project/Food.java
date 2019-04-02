
/**
 * Write a description of class Food here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Food extends Consumable{
    public Food(String keyword, String name, int value){
        super(keyword, name, value);
    }
    
    @Override
    public void interact(String command, Character target){
        System.out.println("You eat " + name);
    }
}
