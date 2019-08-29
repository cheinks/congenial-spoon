
/**
 * Write a description of class MilkBucket here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class MilkBucket extends Potion{
    private String condition;
    public MilkBucket(String keyword, String name, int value, String condition){
        super(keyword, name, value, 0);
        this.condition = condition;
    }
    
    @Override
    public boolean interact(Character target){
        System.out.println("You drink the potion and are no longer " + condition + ".");
        target.removeCondition(condition);
        return true;
    }
}
