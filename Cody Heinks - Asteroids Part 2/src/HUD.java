import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HUD extends JPanel{
	
	private static final long serialVersionUID = -6485270112216579037L;
	
	private JLabel radio; //bottom left for now
	//make the fuel display in the upper right
	//ammo / inventory in the bottom left

	public HUD() {
		super(new GridBagLayout());

		this.setOpaque(false);
		makeLabel();
	}
	
	private void makeLabel() {
		radio = new JLabel("");
		radio.setFont(new Font("gamer", Font.BOLD, 20));
		radio.setForeground(Color.red);
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 0, 0, 0);
		this.add(radio, c);
	}
	
	//Access
	
	//Mutate
	
	public void incomTrans(String s) { radio.setText(s); }

}
