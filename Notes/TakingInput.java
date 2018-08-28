
/**
 * Write a description of class TakingInput here.
 *
 * @author Wiebe
 * @version 8.22.18
 */
import java.util.Scanner;
public class TakingInput{
    public static void repeatName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("Hello " + name);
    }
}
