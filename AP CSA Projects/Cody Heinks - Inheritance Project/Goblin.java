
/**
 * Write a description of class Goblin here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Goblin extends Enemy{
    private int gold;
    
    private double greed; //The percent (0.XXX) that the goblin will steal.
    public Goblin(String name, int health, int attack, int defense, int gold, double greed){
        super(name, health, attack, defense, gold);
        this.greed = greed; 
    }
    
    @Override
    public int special(Character target){
        double newGold = target.getGold();
        newGold *= greed;
        gold += newGold;
        target.setGold((int)(target.getGold()*(1-greed)));
        System.out.println("The goblin steals " + (int)(greed*100) + "% of your gold.");
        return 0;
    }
}
