
public class GameRunner {
	
	private boolean playing;

	public GameRunner() {
		initializeGame();
	}
	
	private void newGame() {
		
		finalizeGame();
		
		play();
	}
	
	private void initializeGame() {
		playing = false;
		
	}
	
	private void finalizeGame() {
		
		playing = true;
	}
	
	private void play() {
		while(playing) {
			
//			try { Thread.sleep(10); } catch (Exception exc) {}
//			frame.repaint();
		}
	}

	public static void main(String[] args) {
		GameRunner run = new GameRunner();
		run.newGame();
	}

}
