
/**
 * Write a description of class TicTacToe here.
 *
 * @author Cody Heinks
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class TicTacToe{
    Board gameBoard;
    
    public TicTacToe(){
        gameBoard = new Board();
        JFrame frame = new JFrame("Tic Tac Toe");
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setOpaque(true);
        mainPanel.setBackground(gameBoard.randomColor());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridy = 0;
        mainPanel.add(gameBoard.info, c);
        
        c.insets = new Insets(10,50,10,50);
        c.gridy = 1;
        mainPanel.add(addGameBoard(), c);
        
        c.insets = new Insets(10,0,10,0);
        c.gridy = 2;
        mainPanel.add(addScore(), c);
        
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    JPanel addGameBoard(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = -1;
        for(int row = 0; row<gameBoard.board.length; row++){
            c.gridy++;
            for(int col = 0; col<gameBoard.board[0].length; col++){
                gameBoard.board[row][col] = new Square(gameBoard);
                
                c.gridwidth  = 3;
                c.gridheight = 3;
                panel.add(gameBoard.board[row][col].getButton(), c);
                
                if(col<2){
                    JLabel divider = new JLabel();
                    divider.setPreferredSize(new Dimension(20,75));
                    divider.setOpaque(true);
                    divider.setBackground(Color.BLACK);
                    c.gridwidth = 1;       
                    panel.add(divider, c);
                }
            }
            if(row < 2){
                c.gridwidth = 11;
                c.gridheight = 1;
                c.gridy = row*4 + 4;
                JLabel divider = new JLabel();
                divider.setPreferredSize(new Dimension(265,20));
                divider.setOpaque(true);
                divider.setBackground(Color.BLACK);
                panel.add(divider, c);
            }
        }
        return panel;
    }
    public JPanel addScore(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(265, 40));
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(0,0,0,30);
        panel.add(gameBoard.p1, c);
        
        c.insets = new Insets(0,30,0,0);
        panel.add(gameBoard.p2, c);
        
        return panel;
    }
}
