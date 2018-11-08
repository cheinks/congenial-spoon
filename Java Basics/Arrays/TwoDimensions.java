
/**
 * Write a description of class TwoDimensions here.
 *
 * @author Cody Heinks
 * @version 11.7.18
 */
public class TwoDimensions
{
    double[][] array;
    double[][][][] ridiculousArray; //4D
    public TwoDimensions(){
        array = new double[10][5]; //Think [rows][columns]
        ridiculousArray = new double[10][10][10][10];
    }
    public void addNumbers(){
        for(int row = 0; row < array.length; row++){
            for(int col = 0; col < array[0].length; col++){
                array[row][col] = 10.5;
            }
        }
    }
    
    /**
     * This method turns all elements in the array to different numbers
     * starting at 1 and going to N, where N is the total number of elements.
     */
    public void count(){
        int N = 1;
        for(int row = 0; row < array.length; row++){
            for(int col = 0; col < array[0].length; col++){
                array[row][col] = N; //N gets promoted to a double!
                N++;
            }
        }
    }
}
