
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
    
    public CellPhone(int screenW, int screenH, String color, String chargeP, boolean cam){
        screenWidth = screenW;
        screenHeight = screenH;
        color = color;
        chargePort = chargeP;
        camera = cam;
    }
}
