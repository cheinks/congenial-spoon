
/**
 * Write a description of class ReplaceAll here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ReplaceAll
{
    /**
     * @param str a String with length > 0
     * @param oldstr a String   
     * @param newstr a String
     * @return a new String in which all occurrences of the substring 
     * oldstr in str are replaced by the substring newstr
     */
    public static String apcsReplaceAll(String str, String oldStr, String newStr)
    {
        String original = str;
        String oldstr = oldStr;        
        String newstr = newStr;
        
        int oldLen = oldstr.length();
        int psn = original.indexOf(oldstr); //Location of the string to be replaced
        String toBeReturned = ""; //Running total of the final product
        String restOfPhrase = original;
        
        //Will return the original if it does not contain the string to be replaced)
        if(psn<0){return original;}
        else{
            while(psn >= 0)
            {
                original = restOfPhrase; //Updates the original - removes the changed portion
                toBeReturned += original.substring(0, psn); //Includes the part before oldstr
                restOfPhrase = original.substring(psn + oldLen); //The part after oldstr
                toBeReturned += newstr; //Includes newstr
                psn = restOfPhrase.indexOf(oldstr); //Is there another instance of oldstr?
                //Will be -1 if not, ending the loop, otherwise is the new location of oldstr
            }
            toBeReturned += restOfPhrase; //Incudes the part after the last instance of oldstr
            return toBeReturned;
        }
    }
    public static void runner()
    {
        System.out.println("type q to quit when asked:");
        boolean running = true;
        while(running)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the original phrase?");
            String phrase = scanner.nextLine();
            if(phrase.equals("q")){running = false;}else{
                System.out.println("What do you want to replace?");
                String _old = scanner.nextLine();
                System.out.println("What do you want to replace it with?");
                String _new = scanner.nextLine();
                System.out.println(apcsReplaceAll(phrase, _old, _new));
            }
            System.out.println();
        }        
    }
}
