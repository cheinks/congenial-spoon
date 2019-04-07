
/**
 * Write a description of class Room here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Room{
    private String name;
    private String description;
    private HashMap<String, String> paths;
    private HashMap<String, Item> roomItems = new HashMap<String, Item>();

    public Room(String name, String desc, String n, String e, String s, String w, ArrayList<Item> items){
        this.name = name;
        description = desc;
        paths.put("N", n);
        paths.put("E", e);
        paths.put("S", s);
        paths.put("W", w);
        for(Item item : items){
            roomItems.put(item.getKeyword(), item);
        }
    }

    public String getName(){return name;}
    public String getDesc(){return description;}
    public String getPath(String direction){
        return paths.get(direction);
    }
    public Item takeItem(String keyword){
        if(roomItems.containsKey(keyword)){
            Item taken = roomItems.get(keyword);
            roomItems.remove(keyword);
            return taken;
        }
        return null;
    }
}
