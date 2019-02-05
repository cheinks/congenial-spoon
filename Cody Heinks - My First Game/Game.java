
/**
 * Write a description of class Screen here.
 *
 * @author Cody Heinks
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
import java.lang.Math;
public class Game extends JFrame{
    private JPanel screen;
    private ArrayList<Sprite> allCharacters = new ArrayList();
    
    private String direction;
    public Game(){
        setTitle("My Game");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Sprite player1 = new Sprite(250, 250);
        allCharacters.add(player1);
        direction = "";
        
        addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == e.VK_UP){direction = "N";}
                if(e.getKeyCode() == e.VK_DOWN){direction = "S";}
                if(e.getKeyCode() == e.VK_LEFT){direction = "W";}
                if(e.getKeyCode() == e.VK_RIGHT){direction = "E";}
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        });
        
        screen = new JPanel();
        add(screen);
        pack();
        playGame();
    }
    
    public void playGame(){
        boolean playing = true;
        while(playing){
            
            for(Sprite s: allCharacters){
                s.move(direction);
            }
            
            for(Sprite s: allCharacters){
                paint(s);
            }
            playing = false;
        }
    }
    
    public void paint(Sprite s){
        Graphics g = screen.getGraphics();
        g.drawImage(s.getImg(), s.getX(), s.getY(), null);
    }
}
