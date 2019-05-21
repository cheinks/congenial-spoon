
/**
 * Write a description of class Board here.
 *
 * @author 
 * @version (a version number or a date)
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Spaceship spaceship;
    private Spaceship enemy;
    private final int DELAY = 10;
    public Board() {
        initBoard();
    }

    private void initBoard() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
	setFocusable(true);

        spaceship = new Spaceship();
        enemy = new Spaceship(100, 100);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(spaceship.getImage(), spaceship.getX(), 
            spaceship.getY(), this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        step();
    }
    
    private void step() {
        spaceship.move();
        
        //repaint(spaceship.getX()-10, spaceship.getY()-10, 
                //spaceship.getWidth()+50, spaceship.getHeight()+50);
        
        repaint();
    }    

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceship.keyPressed(e);
        }
    }
}