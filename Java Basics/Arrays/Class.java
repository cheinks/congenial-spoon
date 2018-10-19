
/**
 * Write a description of class Errors here.
 *
 * @author Cody Heinks
 * @version 10.19.18
 */
import java.util.Scanner;
public class Class{
    int numOfStudents;
    public Class(int students){
        numOfStudents = students;
    }
    public boolean isHere(int id) throws Exception{
        if(id < 1 || id > numOfStudents){
            throw new Exception("Invalid number of students");
        }
        if(id == 14){
            return false;
        }
        return true;
    }
    
    public void askAboutStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the student id?");
        int id = scanner.nextInt();
        try{
            System.out.println(isHere(id));
        }catch (Exception e){
            System.out.println("You typed in an invalid student id.");
        }
    }
}
