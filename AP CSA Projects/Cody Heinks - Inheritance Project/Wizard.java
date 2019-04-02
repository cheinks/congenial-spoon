
/**
 * Write a description of class Wizard here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */

public class Wizard extends Human{
    private Staff staff;
    public Wizard(String name, int health, int attack, int defense, int gold, String threat, Staff staff){
        super(name, health, attack, defense, gold, threat);
        this.staff = staff;
    }
    
    @Override
    public int special(Character target){
        String ability = staff.getPower();
        if(ability.equals("fire")){
            System.out.println("The wizard casts a spell, increasing his attack by 10%.");
            atk = (int)(atk * 1.1);
        }else if(ability.equals("electricity")){
            System.out.println("The wizard casts a spell, charging you with 11 gold.");
            target.setGold(target.getGold() - 11);
        }else if(ability.equals("energy")){
            System.out.println("The wizard casts a spell, regenerating 25 health.");
            currentHP += 25;
        }else if(ability.equals("ice")){
            System.out.println("The wizard casts a spell, increasing his defense by 10%.");
            def = (int)(def * 1.1);
        }
        return 0;
    }
}
