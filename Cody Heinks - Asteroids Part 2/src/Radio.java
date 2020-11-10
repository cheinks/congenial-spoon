import java.util.ArrayList;

public class Radio{ //30 character limit?
	
	private int buffer = 0;
	private int bufferLimit = Manual.radioTextDelay;

	private String transmission = "  "; //bottom left for now
	private String displayText = "";
	private int transIndex = 0;
	
	private ArrayList<String> log;
	private int logIndex = 0;
	
	private boolean newTrans;
	
	//make the fuel display in the upper right
	//ammo / inventory in the bottom left

	public Radio() {
		log = new ArrayList<String>();
		log.add(transmission);
		newTrans = true;
	}
	
	public void updateDisplay() {
		if(newTrans && buffer == bufferLimit) {
			if(transIndex < transmission.length()) { //add the next character
				String letter = transmission.substring(transIndex, transIndex + 1);
				if(letter == " ") {
					displayText += transmission.substring(transIndex, transIndex + 2);
					transIndex++;
				}else {
					displayText += letter;
				}
				transIndex++;
			}
			else {
				try {
					transmission = log.get(logIndex + 1); //get the next transmission
					logIndex++; //increment the index 
					transIndex = 0; //reset the position
					displayText = ""; //clear the display
				}
				catch(Exception e){
					newTrans = false;
				}
			}
			buffer = 0;
		}
		
		buffer++;
	}
	
	//Access
	
	public String getDisplayText() {
		return displayText;
	}
	
	public ArrayList<String> getDisplayTexto() {
		ArrayList<String> formatted = new ArrayList<String>();
		String[] words = displayText.split(" ");
		String row = "";
		int rowLimit = 38;
		int numChars = 0;
		for(int i = 0; i < words.length; i++) {
			if(numChars + words[i].length() < rowLimit) { //if there is enough space, keep the next word
				row += words[i]; row += " ";
				numChars += words[i].length() + 1;
			}else { //otherwise reset and try again
				formatted.add(row);
				row = "";
				numChars = 0;
				i--;
			}
		}
		if(!row.isEmpty()) {formatted.add(row);} //finish off the last row
		return formatted;
	}
	
	//Mutate
	
	public void incomTrans(String s) {
		log.add(s);
		newTrans = true;
	}
}
