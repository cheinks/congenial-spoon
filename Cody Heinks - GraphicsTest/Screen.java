
/**
 * Write a description of class Screen here.
 *
 * @author Cody
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import javax.swing.*;
public class Screen extends JPanel{
    public Screen(){
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
    }
}
