
/**
 * Write a description of class SortingTest here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
import java.util.ArrayList;
public class SortingTest{
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList();
        ArrayList<Integer> sorted;
        for(int i = 0; i < 10 + (int)(Math.random()) * 15; i++){
            numbers.add(new Integer((int)(Math.random()*100)));
        }
        display(numbers);

        testBubble(numbers);
    }

    public static void display(ArrayList<Integer> list){
        for(Integer num : list){
            System.out.print(num.intValue() + " ");
        }
        System.out.println();
    }
    
    public static void testBubble(ArrayList unsorted){
        Sorter sorter = new Sorter();
        display(sorter.bubble(unsorted));
    }
}
