
/**
 * Write a description of class Random here.
 *
 * @author Cody Heinks
 * @version 8.29.18
 */
import java.lang.Math;
public class Random
{
    /**
     * Generates a random number between 1 and 100.
    */
    public static void main(){
        int rand = (int)(Math.random() * 100) + 1;
        System.out.println("Your random number is: " + rand);
    }
    public static void run10000(){
        for(int i = 0; i < 10000; i++){
            System.out.println("Iteration " + (i + 1));
            main();
        }
    }   
    /**
     * Generates a random number between 0 and 10000.
     */
    public static void main2(){
        int rand = (int)(Math.random() * 10001);
        System.out.println("Your random number is: " + rand);
    }
    /**
     * Generates a random number between 5 and 10.
     */
    public static void main3(){
        int rand = (int)(Math.random() * 6) + 5;
        System.out.println("Your random number is: " + rand);
    }
    /**
     * Generates a random number between two given numbers.
     * 
     * precondition: end > start
     */
    public static int mainRand(int start, int end){
        int rand = (int)(Math.random()*(end-start) + start);
        return rand;
    }
}
