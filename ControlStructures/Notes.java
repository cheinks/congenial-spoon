
/**
 * Write a description of class Notes here.
 *
 * @author Cody Heinks
 * @version 8.24.18
 */
public class Notes
{
    public static void grade(int percentage){
        if (percentage >= 90){
            System.out.println("You got an A! What do you want? A cookie?"); 
        }
        else if (percentage >= 80 && percentage < 90){
            System.out.println("B? B for Be better next time.");
        }
        else if (percentage >= 70){
            System.out.println("C. You're average.");
        }
        else if (percentage >= 60){
            System.out.println("D. Definitely not your best work");
        }
        else{
            System.out.println("F? I'm not even sure McDonalds will hire you.");
        }
    }
}
