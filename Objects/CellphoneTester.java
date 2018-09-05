
/**
 * Write a description of class fdgsdg here.
 *
 * @author Cody Heinks
 * @version 9.5.18
 */
public class CellphoneTester
{
    public static void main(String[] args){
        CellPhone cell = new CellPhone();
        System.out.println("The screen width is: ");
        System.out.println(cell.getScreenWidth());
        System.out.println();
        
        System.out.println("The old color was: ");
        System.out.println(cell.getColor());
        cell.setColor("Blue");
        System.out.println("The new color is: ");
        System.out.println(cell.getColor());
        System.out.println();
        
        if(cell.getCamera()){
            System.out.println("This phone has a camera.");
        }else{
            System.out.println("This phone has no camera.");
        }
    }
}
