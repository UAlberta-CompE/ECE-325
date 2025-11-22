package our.cool.game;

public class GameLauncher {
	boolean p1Won;
	boolean p2Won;
	boolean p3Won;
	
	
	public GameLauncher() {
		
	}
	
	public void launch() {
		p1Won = false;
		p2Won = false;
		p3Won = false;
		GuessGame game = new GuessGame();
		game.startGame();
		p1Won = game.p1isRight;
		p2Won = game.p2isRight;
		p3Won = game.p3isRight;
	}
	
	
	public static void main(String[] args) {
		GameLauncher launcher = new GameLauncher();
		launcher.launch();
	}
}
