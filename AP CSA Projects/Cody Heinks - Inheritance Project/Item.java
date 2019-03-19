
/**
 * Write a description of class Item here.
 * 
 * @author Wiebe 
 * @version 1.2
 */
import java.util.ArrayList;
public class Item implements ItemInterface{
    String keyword;
    String name;
    int value;
    Item(String keyword, String name, int value){
        this.keyword = keyword;
        this.name = name;
        this.value = value;
    }
    
    public String getKeyword(){return keyword;}
    public String getName(){return name;}
    public int getValue(){return value;}
}
