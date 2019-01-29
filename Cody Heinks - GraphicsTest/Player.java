
/**
 * Write a description of class Player here.
 *
 * @author Cody
 * @version (a version number or a date)
 */
import java.awt.*;
import java.io.File;
public class Player{
    private int x;
    private int y;
    private int speed;
    private File img = new File("myImage.png");
    public Player(int xCoord, int yCoord){
        x = xCoord;
        y = yCoord;
        speed = 10;
        
    }
}
