
/**
 * Write a description of class Item here.
 * 
 * @author Wiebe 
 * @version 1.2
 */
import java.util.ArrayList;
public class Item implements ItemInterface{
    String name;
    String description;
    int value;
    Item(String name, String description, int value){
        this.name = name;
        this.description = description;
        this.value = value;
    }
    
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getValue(){
        return value;
    }
}
