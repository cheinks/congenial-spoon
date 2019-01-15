    
/**
 * Write a description of class GameRunner here.
 *
 * @author Cody Heinks
 * @version 12.13.18
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class GameRunner{
    JFrame frame;
    JPanel mainPanel;
    TicTacToe game;
    boolean playing = false;
    public GameRunner(){
        frame = new JFrame("Noughts and Crosses");
        mainPanel = new JPanel();
        mainPanel.add(addInstruct());
        
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    
    public JPanel addInstruct(){
        JPanel panel = new JPanel(new GridBagLayout());
        Font defaultFont = new Font("Courier", Font.PLAIN, 20);
        Dimension defaultDim = new Dimension(200, 50);
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        
        JLabel label = new JLabel("Please choose a difficulty:");
        label.setFont(new Font("Courier", Font.BOLD, 24));
        c.gridy = 0;
        panel.add(label, c);
        
        JButton easy = new JButton("Easy");
        easy.setFont(defaultFont);
        easy.setPreferredSize(defaultDim);
            easy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                easy.setEnabled(false);
                startGame(1);
            }
        });
        c.gridy = 1;
        panel.add(easy, c);
        
        JButton normal = new JButton("Normal");
        normal.setFont(defaultFont);
        normal.setPreferredSize(defaultDim);
        normal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                normal.setEnabled(false);
                startGame(2);
            }
        });
        c.gridy = 2;
        panel.add(normal, c);
        
        JButton impossible = new JButton("Impossible");
        impossible.setFont(defaultFont);
        impossible.setPreferredSize(defaultDim);
        impossible.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                impossible.setEnabled(false);
                impossible.setText("Coming soon");
                //startGame(3);
            }
        });
        c.gridy = 3;
        panel.add(impossible, c);
        
        JButton twoPlayer = new JButton("2 Players");
        twoPlayer.setFont(defaultFont);
        twoPlayer.setPreferredSize(defaultDim);
        twoPlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                twoPlayer.setEnabled(false);
                startGame(0);
            }
        });
        c.gridy = 4;
        panel.add(twoPlayer, c);
        
        return panel;
    }
    
    public void startGame(int difficulty){
        if(!playing){
            playing = true;
            game = new TicTacToe(difficulty);
            JPanel gamePanel = game.getPanel();
            
            frame.remove(mainPanel);
            frame.add(gamePanel);frame.revalidate();
            frame.pack();
        }
    }
}
