
/**
 * Write a description of class CellPhone here.
 *
 * @author Cody Heinks
 * @version 9.4.18
 */
public class CellPhone
{
    //Fields
    private int screenWidth;
    private int screenHeight;
    private String color;
    private String chargePort;
    private boolean camera;
    
    //Constructors
    public CellPhone(int screenW, int screenH, String colour, String chargeP, boolean cam){
        screenWidth = screenW;
        screenHeight = screenH;
        color = colour;
        chargePort = chargeP;
        camera = cam;
    }
    public CellPhone(){
        this(1920, 1080, "Black", "USB", true); //"this" refers to the constructor with that takes (int, int, String, String, boolean)
    }
    
    public CellPhone(int screenW, int screenH, String color, boolean cam){
        screenWidth = screenW;
        screenHeight = screenH;
        this.color = color; //"this" refers to the private field at the top NOT the parameter.
        chargePort = "USB";
        camera = cam;
    }
    public CellPhone(int screenW, int screenH){
        this(screenW, screenH, "Black", true);
    }
    
    //Methods
    public void call(String name){
        System.out.println("You call " + name);
    }
    public void compute(){
        System.out.println("2 + 2 = 4");
    }
    public static void getOtherPhoneNumber(){
        System.out.println("You get their digits");
    }
    
    /**
     * The following is an accessor method.
     * 
     * @return The width of the screen.
     */
    public int getScreenWidth(){
        return screenWidth;
    }
    public boolean getCamera(){
        return camera;
    }
    public int getScreenHeight(){
        return screenHeight;
    }
    public String getColor(){
        return color;
    }
    public String getChargePort(){
        return chargePort;
    }
    
    /**
     * The following is a mutator method.
     * 
     * @param The new color
     */
    public void setColor(String color){
        this.color = color;
    }
    public void setCamera(boolean camera){
        this.camera = camera;
    }
    public void setScreenWidth(int width){
        this.screenWidth = width;
    }
    public void setScreenHeight(int height){
        this.screenHeight = height;
    }
    public void setChargePort(String chargePort){
        this.chargePort = chargePort;
    }
}
