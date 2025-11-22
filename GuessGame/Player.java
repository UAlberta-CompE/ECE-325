package our.cool.game;

public class Player {
	int number;
	String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	
	/**
	 * Make a guess and store the number in the number instance variable.
	 * 
	 */
	public void guess() {
		int guess = (int) (Math.random() * 10);
		this.number = guess;
	}
}
