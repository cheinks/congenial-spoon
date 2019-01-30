
/**
 * Write a description of class MainFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import javax.swing.*;
import java.util.ArrayList;


public class GameRunner extends JFrame{
    private Screen game;
    private Sprite player1;
    public GameRunner(){
        setTitle("Yay!");
        
        
        game = new Screen();
        player1 = new Sprite(100, 100);
        game.addSprite(player1);
        
        add(game);
        setVisible(true);
        pack();
    }
    
}
