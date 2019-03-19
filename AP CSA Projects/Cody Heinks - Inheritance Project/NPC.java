
/**
 * Write a description of class NPC here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class NPC extends Character{
    private String name;
    
    private String quest;
    private int reward;
    ArrayList<String> required;
    ArrayList<Item> possessions;
    public NPC(String name, String quest, int reward, ArrayList<String> required){
        super(name, 1, 0, 0, reward);
        this.quest = quest;
    }
    
    @Override
    public int takeDamage(int damage){
        return 0;
    }
    
    @Override
    public void changeGold(int amount){
        reward -= amount;
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
