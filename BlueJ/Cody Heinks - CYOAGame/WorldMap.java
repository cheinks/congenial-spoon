
/**
 * Write a description of class WorldMap here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class WorldMap{
    private HashMap<String, Room> world = new HashMap<String, Room>();
    
    public WorldMap(){
        world.put("plaza", new Room("Plaza", "You are in the center of town." +
        " There are paths leading in all directions. There is a fountain here.", 
        null, null, null, null, new ArrayList<Item>()));
    }
    
    public Room getRoom(String key){
        return world.get(key);
    }
}
