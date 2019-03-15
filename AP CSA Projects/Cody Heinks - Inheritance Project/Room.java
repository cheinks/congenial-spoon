
/**
 * Write a description of class Room here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Room{
    private String name;
    private String description;
    private Room n;
    private Room e;
    private Room s;
    private Room w;
    private ArrayList<Item> items;
    public Room(String name, String desc, Room north, Room east, Room south, Room west, ArrayList<Item> items){
        this.name = name;
        this.description = desc;
        n = north;
        e = east;
        s = south;
        w = west;
        this.items = items;
    }
    
    public String getName(){return name;}
    public String getDesc(){return description;}
    public Room getPath(String direction){
        if(direction.equals("north")){return n;}
        if(direction.equals("east")){return e;}
        if(direction.equals("south")){return s;}
        if(direction.equals("west")){return w;}
        return null;
    } 
    
    public void addItem(Item item){items.add(item);}
    public boolean removeItem(Item item){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).equals(item)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }
}
