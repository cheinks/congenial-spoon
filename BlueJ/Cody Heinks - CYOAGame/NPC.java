
/**
 * Write a description of class NPC here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class NPC extends Character{
    private String quest;
    ArrayList<String> required;
    ArrayList<Item> possessions;
    public NPC(String name, int gold, String quest, ArrayList<String> required){
        super(name, 1, 0, 0, gold);
        this.quest = quest;
    }
    
    @Override
    public int takeDamage(int damage){
        return 0;
    }
    
    private String getQuest(){return quest;}
    
    public boolean checkChallenge(){
        for(String thing : required){
            boolean check = false;
            int index = 0;
            while(!check){
                if(possessions.get(index).getName().equals(thing)){
                    check = true;
                }
                index++;
                if(index > possessions.size()){
                    return false;
                }
            }
        }
        return true;
    }
}
