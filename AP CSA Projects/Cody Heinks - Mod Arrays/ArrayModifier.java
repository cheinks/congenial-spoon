
/**
 * Write a description of class ArrayModifier here.
 *
 * @author Cody Heinks
 * @version 1.8.19
 */
public class ArrayModifier{
    int[] original;
    int[] arr;
    public ArrayModifier(int[] array){
        original = array;
        arr = array;
    }
    
    public void add(int num, int index){
        int newNum = num;
        int pos = index;
        int tempValue = 0;
        for(int i = arr.length-1; i>pos; i--){
            arr[i] = arr[i - 1];
        }
        arr[pos] = newNum;
    }

    public void remove(int index){
        int pos = index;
        for(int i = pos; i<arr.length-1 ; i++){
            arr[i] = arr[i + 1];
        }
        arr[arr.length-1] = 0;
    }
}
