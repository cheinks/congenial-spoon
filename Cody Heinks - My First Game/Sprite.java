
/**
 * Write a description of class Sprite here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
public class Sprite{
    private int x;
    private int width;
    private int y;
    private int height;
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
        width = img.getWidth();
        height = img.getHeight();
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    public int getSpeed(){return speed;}
    public BufferedImage getImg(){return img;}
    
    public void move(String d){
        if(d.equals("N")){y -= speed;}
        if(d.equals("E")){x += speed;}
        if(d.equals("S")){y += speed;}
        if(d.equals("W")){x -= speed;}
        
        if(x < 0){x = 0;}else if(x > 500 - width){x = 500 - width;}
        if(y < 0){y = 0;}else if(y > 500 - height){y = 500 - height;}
    }
}
