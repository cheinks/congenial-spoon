
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

    public int[] bubble(int[] list){
        int middleMan;
        for(int lastSortedIndex = list.length - 1; lastSortedIndex > 0; lastSortedIndex--){
            for(int currentIndex = 0; currentIndex < lastSortedIndex; currentIndex++){
                if(list[currentIndex] > list[currentIndex + 1]){
                    middleMan = list[currentIndex];
                    list[currentIndex] = list[currentIndex + 1];
                    list[currentIndex + 1] = middleMan;
                }
            }
        }
        return list;
    }

    public int[] insertion(int[] list){
        int middleMan;
        
        return list;
    }

    public int[] selection(int[] list){
        int middleMan;
        for(int nextSlot = 0; nextSlot < list.length; nextSlot++){
            int lowestIndex = nextSlot;
            for(int i = nextSlot; i < list.length; i++){
                if(list[i] < list[lowestIndex]){
                    lowestIndex = i;
                }
            }
            middleMan = list[nextSlot];
            list[nextSlot] = list[lowestIndex];
            list[lowestIndex] = middleMan;
        }
        return list;
    }
}
