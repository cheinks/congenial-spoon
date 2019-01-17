
/**
 * Write a description of class Notes here.
 *
 * @author Cody Heinks
 * @version 1.17.19
 */
import java.util.ArrayList;
import java.util.List;
public class Notes{
    ArrayList<String> shoppingList; //Must be non-primitive
    ArrayList<Boolean> test1;
    public Notes(){
        shoppingList = new ArrayList();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
    }
    
    public void printShoppingList(){
        for(String str : shoppingList){
            System.out.println(str);
        }
    }
    
    public String getFirstElement(){
        return shoppingList.get(0);
    }
    public void removeFirstElement(){
        shoppingList.remove(0); 
    }
    
    public void engageCookieMonster(){
        for(int i = 0; i < shoppingList.size(); i++){
            shoppingList.set(i, "COOKIES!");
        }
    }
}
