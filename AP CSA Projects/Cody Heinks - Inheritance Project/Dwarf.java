
/**
 * Write a description of class Dwarf here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Dwarf extends Enemy{
    private int height; //centimeters
    public Dwarf(String name, int health, int attack, int defense, int gold, int height){
        super(name, health, attack, defense, gold);
        this.height = height;
    }
    
    @Override
    public int special(Character target){
        
        return 0;
    }
}
