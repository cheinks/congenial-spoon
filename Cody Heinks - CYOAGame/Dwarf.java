
/**
 * Write a description of class Dwarf here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Dwarf extends Enemy{
    private int food;
    public Dwarf(String name, int health, int attack, int defense, int gold, int food){
        super(name, health, attack, defense, gold);
        this.food = food;
    }
    
    @Override
    public int special(Character target){
        System.out.println("The dwarf takes a fruit from its bag and eats it, gaining 50 health.");
        currentHP += 50;
        return 0;
    }
}
