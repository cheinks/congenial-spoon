
/**
 * Write a description of class TaxCalc here.
 *
 * @author Cody Heinks
 * @version 8.22.18
 */
import java.util.Scanner;
public class TaxCalc{
    public static void computeTax(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the gross income:");
        double grossIncome = scanner.nextDouble();
        System.out.println("Enter the number of dependents:");
        int numDependents = scanner.nextInt();
        double taxableIncome = grossIncome - 10000 - 2000 * numDependents;
        double incomeTax = 0;
        if (taxableIncome > 0){
            incomeTax = taxableIncome * 0.20;    
        }
        System.out.println("The income tax is $" + incomeTax);
    }
}
