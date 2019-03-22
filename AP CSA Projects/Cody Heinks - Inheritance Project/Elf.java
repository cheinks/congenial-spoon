
/**
 * Write a description of class Elf here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Elf extends Enemy{
    private int def;
    
    private int spirit; //The amount by which the Elf's defense will increase
    public Elf(String name, int health, int attack, int defense, int gold, int spirit){
        super(name, health, attack, defense, gold);
        this.spirit = spirit;
    }
    
    @Override
    public int special(Character target){
        def += spirit;
        System.out.println("Calling upon the power of the Gods, the elf increases its defense by " + spirit + ">.");
        return 0;
    }
}
