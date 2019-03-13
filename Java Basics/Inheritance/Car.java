
/**
 * Write a description of class Car here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
public class Car extends Vehicle{
    public Car(int passengers, String start, String end){
        super(passengers, start, end);
    }
    public void start(){
        System.out.println("You start the car.");
    }
    public void moveForward(){
        System.out.println("You drive the car forward.");
    }
    public void turnOff(){
        System.out.println("You turn off the engine.");
    }
    public void yourDriving(){
        System.out.println("Russel hit a tree.");
    }
}
