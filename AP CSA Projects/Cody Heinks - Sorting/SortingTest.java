
/**
 * Write a description of class SortingTest here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
public class SortingTest{
    public static void main(String[] args){
        int[] numbers = new int[10];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random()*100);
        }
        display(numbers);

        //testBubble(numbers);
        //testInsertion(numbers);
        testSelection(numbers);
    }

    public static void display(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    
    public static void testBubble(int[] unsorted){
        Sorter sorter = new Sorter();
        display(sorter.bubble(unsorted));
    }
    
    public static void testInsertion(int[] unsorted){
        Sorter sorter = new Sorter();
        display(sorter.insertion(unsorted));
    }
    
    public static void testSelection(int[] unsorted){
        Sorter sorter = new Sorter();
        display(sorter.selection(unsorted));
    }
}
