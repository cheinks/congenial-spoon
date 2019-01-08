
/**
 * Write a description of class ArrModTester here.
 *
 * @author Cody Heinks
 * @version 1.8.19
 */
public class ArrModTester{
    public static void main(String[] args){
        int[] testArr = {20, 15, 4, 300, 62, 39, 176};
        ArrayModifier arrMod = new ArrayModifier(testArr);
        
        display(arrMod.original);
        arrMod.remove(1);
        display(arrMod.arr);
    }
    
    private static void display(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
