
/**
 * Write a description of class CellPhone here.
 *
 * @author Cody Heinks
 * @version 9.4.18
 */
public class CellPhone
{
    private int screenWidth;
    private int screenHeight;
    private String color;
    private String chargePort;
    private boolean camera;
    
    public CellPhone(int screenW, int screenH, String colour, String chargeP, boolean cam){
        screenWidth = screenW;
        screenHeight = screenH;
        color = colour;
        chargePort = chargeP;
        camera = cam;
    }
    
    public void call(String name){
        System.out.println("You call " + name);
    }
    
    public void compute(){
        System.out.println("2 + 2 = 4");
    }
    
    public static void getOtherPhoneNumber(){
        System.out.println("You get their digits");
    }
}
