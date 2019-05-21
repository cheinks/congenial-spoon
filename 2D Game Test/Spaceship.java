
/**
 * Write a description of class Spaceship here.
 *
 * @author 
 * @version (a version number or a date)
 */
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class Spaceship{
    private int dy;
    private int dx;
    private int xCoord = 50;
    private int yCoord = 70;
    private int width, height;
    private Image image;
    
    public Spaceship() {
        loadImage();
    }
    
    public Spaceship(int x, int y){
        loadImage();
        xCoord = x; yCoord = y;
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("test1.png");
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    
    public void move(){
        xCoord += dx;
        yCoord += dy;
    }
    
    public int getX(){return xCoord;}
    public int getY(){return yCoord;}
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    
    public Image getImage(){return image;}
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }else if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }else if (key == KeyEvent.VK_UP) {
            dy = -2;
        }else if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }else if (key == KeyEvent.VK_UP) {
            dy = 0;
        }else if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
