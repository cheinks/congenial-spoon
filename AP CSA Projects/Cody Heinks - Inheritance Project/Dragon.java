
/**
 * Write a description of class Dragon here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Dragon extends Boss{
    private int def;
    public Dragon(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
    }
    
    @Override
    public int special(Character target){
        target.setCondition("burning");
        System.out.print("The dragon spews fire! You are now burning.");
        def /= 2;
        return 0;
    }
    
    @Override
    public void passive(){
        def += 10;
    }
}
