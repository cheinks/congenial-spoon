
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
        
        System.out.println(5 / 2);
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
    
    public static void testMerge(){
        Sorter sorter = new Sorter();
        int[] unsorted = randIntArray();
        display(unsorted);
        sorter.merge(unsorted, 0, 2);
        sorter.merge(unsorted, 2, 3);
        sorter.merge(unsorted, 0, 3);
        sorter.merge(unsorted, 3, 4);
        sorter.merge(unsorted, 4, 5);
        sorter.merge(unsorted, 3, 5);
        sorter.merge(unsorted, 0, 5);
    }
}
