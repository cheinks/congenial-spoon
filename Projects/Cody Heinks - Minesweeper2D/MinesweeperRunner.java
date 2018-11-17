
/**
 * Minesweeper, fully functional as long you
 * don't try to break it. Complete with a 2D
 * array and addBombs().
 *
 * @author Cody Heinks
 * @version 11.13.18
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class MinesweeperRunner{
    Cell[][] board;
    int rows;
    int columns;
    int bombs;
    
    boolean flagMode = false;
    boolean hasBombs = false;
    
    JButton flagButton = new JButton();
    Color bckg = flagButton.getBackground();
    MinesweeperBoard cellBoard;
    JLabel bombsLeft = new JLabel();
    
    public MinesweeperRunner(int difficulty){
        if(difficulty == 1){
            rows = 9;
            columns = 9;
            bombs = 10;
        }else if(difficulty == 2){
            rows = 12;
            columns = 12;
            bombs = 21;
        }else if(difficulty == 3){
            rows = 12;
            columns = 18;
            bombs = 38;
        }else if(difficulty == 4){
            rows = 16;
            columns = 16;
            bombs = 40;
        }else if(difficulty == 5){
            rows = 16;
            columns = 30;
            bombs = 99;
        }else{
            
            rows = 20;
            columns = 30;
            bombs = 145;
        }
        
        board = new Cell[rows][columns];
        cellBoard = new MinesweeperBoard(rows, columns, bombs, board, flagButton, bombsLeft);
        
        JFrame frame = new JFrame("Minesweeper");
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipady = 40;
        c.weightx = 0.0;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(addCells(), c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridwidth = 1;
        c.gridy = 0;
        mainPanel.add(addModeSelector(), c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(0,20,0,0);
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 0;
        mainPanel.add(bombsLeft, c);
        
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].isBomb()){
                    System.out.print("X ");
                }else{
                    System.out.print(board[i][j].getValue() + " ");
                }
            }
            System.out.println();
        }
    }
    
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int r = 0; r<board.length; r++){
            for(int c = 0; c<board[0].length; c++){
                board[r][c] = new Cell(c, r, cellBoard);
                panel.add(board[r][c].getButton());
            }
        }
        return panel;
    }
    
    public JPanel addModeSelector(){
        JPanel panel = new JPanel();
        flagButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(flagMode){
                    flagMode = false;
                    cellBoard.flagMode = false;
                    flagButton.setBackground(bckg);
                }else{
                    flagMode = true;
                    cellBoard.flagMode = true;
                    flagButton.setBackground(Color.GREEN);
                }
            }
        });
        flagButton.setPreferredSize(new Dimension(50,50));
        flagButton.setMargin(new Insets(0,0,0,0));
        panel.add(flagButton);
        return panel;
    }
}
