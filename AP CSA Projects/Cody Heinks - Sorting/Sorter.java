
/**
 * Write a description of class Sorter here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Sorter{
    public Sorter(){
        
    }

    public ArrayList bubble(ArrayList<Integer> list){
        int middleMan;
        for(int lastSortedIndex = list.size() - 1; lastSortedIndex > 0; lastSortedIndex--){
            for(int index = 0; index < lastSortedIndex; index++){
                if(list.get(index).intValue() > list.get(index + 1).intValue()){
                    middleMan = list.get(index).intValue();
                    list.set(index, new Integer(list.get(index + 1).intValue()));
                    list.set(index + 1, new Integer(middleMan));
                }
            }
        }
        
        return list;
    }

    public ArrayList insertion(ArrayList<Integer> list){
        
        return list;
    }

    public ArrayList selection(ArrayList<Integer> list){
        
        return list;
    }
}
