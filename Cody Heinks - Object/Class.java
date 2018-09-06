
/**
 * This is a typical Edison High class.
 *
 * @author Cody Heinks
 * @version 9.6.18
 */
public class Class
{
    //Fields
    private String name;
    private int students;
    private String roomNumber;
    private boolean pathway;
    private boolean advancedPlacement;
    
    //Constructor
    public Class(String name, int studs, String roomNum, boolean pathway, boolean advPl){
        this.name = name;
        students = studs;
        roomNumber = roomNum;
        this.pathway = pathway;
        advancedPlacement = advPl;
    }
    public Class(){
        this("Computer Science A", 29, "R19A", true, true);
    }
    
    //Accessors
    public String getName(){
        return name;
    }
    public int getStudents(){
        return students;
    }
    public String getRoomNum(){
        return roomNumber;
    }
    public boolean getPathway(){
        return pathway;
    }
    public boolean getAP(){
        return advancedPlacement;
    }
    
    //Mutators
    public void setName(String name){
        this.name = name;
    }
    public void setStudents(int students){
        this.students = students;
    }
    public void setRoomNum(String roomNum){
        roomNumber = roomNum;
    }
    public void setPath(boolean pathway){
        this.pathway = pathway;
    }
    public void setAP(boolean advPl){
        advancedPlacement = advPl;
    }
    
    //Methods
    public void getTeacher(){
        System.out.println("I haven't gotten this far yet okay!");
        System.out.println("Mr. Wiebe teaches this class for now.");
    }
    public void takeClass(){
        System.out.println("You are now enrolled in this class.");
        students++;
    }
    public void studyForTest(){
        System.out.println("Eh, I've still got a couple days, and I already know everything.");
        System.out.println("I'm gonna play Fortnite instead.");
    }
}
