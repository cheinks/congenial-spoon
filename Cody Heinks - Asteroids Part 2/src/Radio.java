import java.util.ArrayList;

public class Radio{
	
	private int buffer = 0;
	private int bufferLimit = Manual.radioTextSpeed;

	private String transmission = " "; //bottom left for now
	private String display = "";
	private int transIndex = 0;
	
	private ArrayList<String> log;
	private int logIndex = 0;
	
	private boolean newTrans;
	
	//make the fuel display in the upper right
	//ammo / inventory in the bottom left

	public Radio() {
		log = new ArrayList<String>();
		log.add(" ");
		newTrans = true;
	}
	
	public void updateDisplay() {
		
		if(newTrans && buffer == bufferLimit) {
			if(transIndex < transmission.length()) {
				display += transmission.substring(transIndex, transIndex + 1);
				transIndex++;
			}
			else {
				try {
					transmission = log.get(logIndex + 1); //get the next transmission
					logIndex++; //increment the index 
					transIndex = 0; //reset the position
					display = ""; //clear the display
				}
				catch(Exception e){
					newTrans = false;
				}
			}
			buffer = 0;
			System.out.println(getDisplay());
		}
		
		
		buffer++;
	}
	
	//Access
	
	public String getDisplay() {
		return display;
	}
	
	//Mutate
	
	public void incomTrans(String s) {
		log.add(s);
		newTrans = true;
	}
}
