
/**
 * Write a description of class Player here.
 *
 * @author Cody
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class Sprite{
    private int x;
    private int y;
    private int speed;
    File myFile = new File("myImage.png");
    private BufferedImage img = null;
    
    public Sprite(int xCoord, int yCoord){
        x = xCoord;
        y = yCoord;
        speed = 10;
        try{
            img = ImageIO.read(myFile);
        }catch(IOException e){
            System.out.println("Noooo!");
        }
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public int getSpeed(){return speed;}
    public BufferedImage getImg(){return img;}
}
