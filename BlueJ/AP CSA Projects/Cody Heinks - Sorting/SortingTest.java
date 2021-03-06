
/**
 * Write a description of class SortingTest here.
 *
 * @author Cody Heinks
 * @version 2.21.19
 */
import java.lang.Math;
public class SortingTest{
    public static void main(String[] args){
        testBubble();
        System.out.println();
        
        testInsertion();
        System.out.println();
        
        testSelection();
        System.out.println();
        
        testMerge();
    }
    
    public static int[] randIntArray(){
        int[] numbers = new int[10];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random()*100);
        }
        return numbers;
    }

    public static void display(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    
    private static void testBubble(){
        System.out.println("Bubble Sort");
        Sorter sorter = new Sorter();
        int[] unsorted = randIntArray();
        display(unsorted);
        display(sorter.bubble(unsorted));
    }
    
    private static void testInsertion(){
        System.out.println("Insertion Sort");
        Sorter sorter = new Sorter();
        int[] unsorted = randIntArray();
        display(unsorted);
        display(sorter.insertion(unsorted));
    }
    
    private static void testSelection(){
        System.out.println("Selection Sort");
        Sorter sorter = new Sorter();
        int[] unsorted = randIntArray();
        display(unsorted);
        display(sorter.selection(unsorted));
    }
    
    private static void testMerge(){
        System.out.println("Merge Sort");
        Sorter sorter = new Sorter();
        int[] unsorted = randIntArray();
        display(unsorted);
        display(sorter.merge(unsorted));
    }
}
