
/**
 * Write a description of class HelloWorld here.
 *
 * @author Wiebe
 * @version 8.21.18
 */
public class Notes
{
    private static String str = "Hello World";
    
    public static void dataTypes(){
        //Primitive Data Types
        
        long schoolDay = 8; //Not tested on AP
        int banana;
        banana = -3;
        short b = 15; //Not tested
        byte c = 14; //Not tested
        
        float decimal = 3.3f; //Not tested
        double dec = 9.81; //*********IMPORTANT********
        boolean bool = false;
        
        char a = 'a'; //Not tested
        
        // Non-Primitive Types
        String str2 = "Hello";
    }
    public static void main(String[] args){
        System.out.println(str);
        //System.out.println(str2);
    }
    public static void math(){
        int a = 15;
        int b = 10;
        System.out.println(a + b);
        System.out.println(b - a);
        System.out.println(a * b);
        System.out.println(b / a);
        
        //This is special
        System.out.println(a / b);
        
        System.out.println(12 / 5);
        System.out.println(12 / 5.);
        System.out.println( (double)a / b );
        System.out.println( (double) (a/b) );
        
        a += 1;
        b -= 1;
        a *= 4; // Multiply by 4 and set it to a
        a++; //Increment by 1 and set it to a
        b--; //Decrement by 1 and set it to b
        
        System.out.println(298 % 13); // 12
        System.out.println(12 % 5); // 2
        System.out.println(14 % 5);  // 4
        
        a %= 3;
        
    }
}
