
/**
 * Write a description of class GameRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameRunner extends JFrame {

    public GameRunner() {
        
        initUI();
    }
    
    private void initUI() {
        add(new Board());

        setTitle("Moving sprite");
        setSize(400, 300);
        
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            GameRunner ex = new GameRunner();
            ex.setVisible(true);
        });
    }
}
