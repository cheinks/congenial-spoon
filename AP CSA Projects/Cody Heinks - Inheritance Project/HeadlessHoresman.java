
/**
 * Write a description of class HeadlessHoresman here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class HeadlessHoresman extends Boss{
    private int currentHP;
    public HeadlessHoresman(String name, int health, int attack, int defense, int gold){
        super(name, health, attack, defense, gold);
    }
    
    @Override
    public int special(Character target){
        target.setCondition("fear");
        System.out.println("The headless horseman reveals his head, striking your heart with fear.");
        
        return 0;
    }
    
    @Override
    public void passive(){
        currentHP += 5;
    }
}
