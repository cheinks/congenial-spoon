
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

import java.awt.Graphics;
public class TestGame extends JFrame{
    private Screen game;
    private ArrayList<Sprite> sprites = new ArrayList();
    public TestGame(){
        setTitle("Does it work?");
        
        Sprite player1 = new Sprite(100, 100);
        sprites.add(player1);
        game = new Screen(sprites);
        
        add(game);
        setVisible(true);
        pack();
    }
}
