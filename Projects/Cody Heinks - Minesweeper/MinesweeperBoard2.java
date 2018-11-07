
/**
 * Write a description of class MinesweeperBoard2 here.
 * 
 * @author Cody Heinks 
 * @version 10.25.18
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import java.awt.event.*;

public class MinesweeperBoard2{
    static Cell[] board;
    static int rows;
    static int columns;
    static int mines;
    public static boolean flag = false;
    public static int flaggedBombs = 0;
    static int cellsToClear;
    
    public static boolean beyondScope = false;
    JButton flagButton = new JButton();

    static int numOfCells; 
    boolean hasBombs = false;
    boolean hasNums = false;
    
    public MinesweeperBoard2(){
        this(10, 10);
    }

    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        rows = row;
        columns = column;
        numOfCells = row * column;
        board = new Cell[numOfCells];
        
        //These pieces are for the GUI.
        JFrame frame = new JFrame("Minesweeper");
        frame.add(addCells());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
    
    public MinesweeperBoard2(int difficulty){
        if(difficulty == 1){
            rows = 9;
            columns = 9;
            mines = 10;
        }else if(difficulty == 2){
            rows = 12;
            columns = 12;
            mines = 21;
        }else if(difficulty == 3){
            rows = 12;
            columns = 18;
            mines = 38;
        }else if(difficulty == 4){
            rows = 16;
            columns = 16;
            mines = 40;
        }else if(difficulty == 5){
            rows = 16;
            columns = 30;
            mines = 99;
        }else{
            rows = 20;
            columns = 30;
            mines = 145;
        }
        
        numOfCells = rows*columns;
        cellsToClear = numOfCells - mines;
        board = new Cell[numOfCells];
        
        JFrame frame = new JFrame("Minesweeper");
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(addModeSelectors(flagButton));
        panel.add(addCells());
        frame.add(panel);
        
        try{
            this.addBombs(mines);
        }catch(Exception e){
            System.out.println(e);
        }
        addNums();
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        beyondScope = true;
    }

    public void addBombs(int bombs) throws Exception{
        if (bombs == 4200){throw new CodyException("NICE!!!");}
        else if(!hasBombs){
            if(bombs < numOfCells && bombs > 0){
                int randCell = 0;
                while(bombs > 0){
                    randCell = (int)(Math.random() * numOfCells);
                    if(!board[randCell].isBomb()){
                        board[randCell].setValue(11);
                        bombs--;
                    }
                }
                hasBombs = true;
            }else if(bombs != 0){throw new Exception("That value is invalid.");}
        }
        else{throw new Exception("It is too dangerous to plant more mines.");}
    }
    
    public void addNums(){
        if(!hasNums){
            if(hasBombs){
                for(int i = 0; i < numOfCells; i++){
                    if(!board[i].isBomb()){
                        boolean tLeft = true;
                        boolean above = true;
                        boolean tRight = true;
                        boolean left = true;
                        boolean right = true;
                        boolean bLeft = true;
                        boolean below = true;
                        boolean bRight = true;
                        
                        if(i < columns){tLeft = false; above = false; tRight = false;}
                        if(i % columns == 0){tLeft = false; left = false; bLeft = false;}
                        if((i + 1) % columns == 0){tRight = false; right = false; bRight = false;}
                        if(i + columns >= numOfCells){bLeft = false; below = false; bRight = false;}
                        
                        if(tLeft && board[i - columns - 1].isBomb()){board[i].addOne();}
                        if(above && board[i - columns].isBomb()){board[i].addOne();}
                        if(tRight && board[i - columns + 1].isBomb()){board[i].addOne();}
                        if(left && board[i - 1].isBomb()){board[i].addOne();}
                        if(right && board[i + 1].isBomb()){board[i].addOne();}
                        if(bLeft && board[i + columns - 1].isBomb()){board[i].addOne();}
                        if(below && board[i + columns].isBomb()){board[i].addOne();}
                        if(bRight && board[i + columns + 1].isBomb()){board[i].addOne();}
                    }
                }
                hasNums = true;
            }else{System.out.println("There aren't any mines yet.");}
        }else{System.out.println("This board already has numbers.");}
    }

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int n = 0;
        int nValue;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                nValue = board[n].getValue();
                if(nValue == 11){System.out.print("X ");}else{System.out.print(nValue + " ");}
                n++;
            }
            System.out.println();
        }        
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell(i);
            panel.add(board[i].getButton());
        }
        return panel;
    }
    
    public JButton flagButton(JButton btn){
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(flag){   
                    flag = false;
                    btn.setBackground(new JButton().getBackground());
                }else{
                    flag = true;
                    btn.setBackground(Color.GREEN);
                }
                btn.setEnabled(true);
            }
        });
        btn.setPreferredSize(new Dimension(50,50));
        btn.setMargin(new Insets(0,0,0,0));;
        return btn;
    }
    
    public JPanel addModeSelectors(JButton Cbtn){
        JPanel panel = new JPanel();
        panel.add(flagButton(Cbtn));
        return panel;
    }
    
    public static void endGame(boolean win){
        if(beyondScope){
            if(!win){
                for(int i = 0; i<numOfCells; i++){
                    board[i].getButton().setEnabled(false);
                    if(board[i].isBomb() && !board[i].bombWithFlag){
                        board[i].getButton().setText("\u2600");
                        board[i].getButton().setBackground(Color.RED);
                    }else if(board[i].isFlag && !board[i].isBomb()){
                        board[i].getButton().setText("\u274C");
                    }
                }
            }else{
                System.out.println("Congrats, you won!");
            }            
        }    
    }
    
    public static void cellCleared(){
        cellsToClear--;
        if(cellsToClear == 0){
            for(int i = 0; i < numOfCells; i++){
                if(board[i].isBomb() && !board[i].bombWithFlag){
                    board[i].addFlag();
                }
            }
            endGame(true);
        }
    }
}
