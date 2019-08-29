
/**
 * Write a description of class Human here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Human extends Enemy{
    protected String threat;
    public Human(String name, int health, int attack, int defense, int gold, String threat){
        super(name, health, attack, defense, gold);
        this.threat = threat;
    }
    
    public void threaten(){
        System.out.println(threat);
    }
    
    @Override
    public int special(Character target){
        threaten();
        return 0;
    }
}
