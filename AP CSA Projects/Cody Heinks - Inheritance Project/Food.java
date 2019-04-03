
/**
 * Write a description of class Food here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Food extends Consumable{
    private int hunger;
    private boolean poisoned;
    public Food(String keyword, String name, int value, int hunger, boolean poisoned){
        super(keyword, name, value);
        this.hunger = hunger;
        this.poisoned = poisoned;
    }
    
    @Override
    public boolean interact(Character target){
        if(target.getCurrentHP() < target.getBaseHP()){
            if(!poisoned){
                target.changeHealth(hunger);
                System.out.println("You eat the " + name + " and gain " 
                + hunger + " health.");
                return true;
            }else{
                target.changeHealth(-hunger);
                System.out.println("You eat the " + name + ", but it was poisoned!" 
                + " You lose " + hunger + " health.");
                return true;
            }
        }
        System.out.println("You are not hungry.");
        return false;
    }
}
