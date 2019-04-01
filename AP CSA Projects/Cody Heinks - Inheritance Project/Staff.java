
/**
 * Write a description of class Staff here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Staff extends Primary{
    String power;
    public Staff(String keyword, String name, int value, int damage, String power){
        super(keyword, name, value, damage);
        this.power = power;
    }
    
    @Override
    public void attack(int damage){
        if(power.equals("fire")){
            System.out.println("You shoot a fireball at the enemy, dealing " 
            + damage + " damage.");
        }else if(power.equals("electricity")){
            System.out.println("The sky rumbles as lightning strikes the enemy. " 
            + "They lose " + damage + " health.");
        }else if(power.equals("energy")){
            System.out.println("You blast the energy with a ball of plasma, dealing "
            + damage + " damage.");
        }
    }
}
