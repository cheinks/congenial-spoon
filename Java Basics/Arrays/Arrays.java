
/**
 * Write a description of class Arrays here.
 *
 * @author Cody Heinks
 * @version 10.4.18
 */
import java.util.Scanner;
public class Arrays
{
    int[] newArray = new int[10000];
    Scanner[] scannerArray = new Scanner[40];
    /**Creates a new array with 10000 n's in it.
     * 
     * @param n All 10000 entries will be the integer n.
     */
    public Arrays(int n){
        for(int i = 0; i < newArray.length; i++){newArray[i] = n;}
    }
    public Arrays(){
        newArray[0] = 5;
        newArray[1] = 9;
        newArray[2] = 7;
        newArray[3] = 8;
    }
    
    public void printArray(){
        for(int i = 0; i < newArray.length; i++){System.out.println(newArray[i]);}
    }
}
