
/**
 * Controls the GUI for the game.
 *
 * @author Cody Heinks
 * @version 1.01.19
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class TicTacToe{
    Board gameBoard;
    JPanel mainPanel;
    public TicTacToe(int difficulty){
        gameBoard = new Board(difficulty);
        
        mainPanel = new JPanel(new GridBagLayout());
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
        
        c.insets = new Insets(0,0,0,0);
        c.gridy = 3;
        mainPanel.add(addNewGame(), c);
    }
    
    JPanel addGameBoard(){
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); 
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = -1;
        for(int row = 0; row<3; row++){
            c.gridy++;
            for(int col = 0; col<3; col++){
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
    public JPanel addNewGame(){
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        
        JButton playAgain = new JButton();
        playAgain.setOpaque(false);
        playAgain.setPreferredSize(new Dimension(115, 40));
        playAgain.setFont(new Font("Courier", Font.PLAIN, 16));
        playAgain.setText("New Game");
        playAgain.setContentAreaFilled(false);
        
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!gameBoard.playing){
                    gameBoard.resetBoard();
                    playAgain.setEnabled(true);
                }
            }
        };
        playAgain.addActionListener(l);
        
        panel.add(playAgain);
        return panel;
    }
    
    public JPanel getPanel(){return mainPanel;}
}
