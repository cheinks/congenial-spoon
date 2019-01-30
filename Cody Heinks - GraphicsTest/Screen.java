
/**
 * Write a description of class Screen here.
 *
 * @author Cody
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import javax.swing.*;
import java.util.ArrayList;
public class Screen extends JPanel{
    private ArrayList<Sprite> sprites;
    private Dimension fieldSize;
    public Screen(){
        sprites = new ArrayList();
        fieldSize = new Dimension(500, 500);
        Graphics g = getGraphics();
        for(Sprite s : sprites){
            g.drawImage(s.getImg(), s.getX(), s.getY());
        }
        
        
        addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == e.VK_UP){}
                if(e.getKeyCode() == e.VK_DOWN){}
                if(e.getKeyCode() == e.VK_LEFT){}
                if(e.getKeyCode() == e.VK_RIGHT){}
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
        
        setPreferredSize(fieldSize);
    }
    
    public void addSprite(Sprite newSprite){
        sprites.add(newSprite);
    }
}
