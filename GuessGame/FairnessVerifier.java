package our.cool.game;

public class FairnessVerifier {
	public static void main(String[] args) {
		int noOfGames = 1000;
		
		GameLauncher launcher = new GameLauncher();
		
		int p1Wins = 0;
		int p2Wins = 0;
		int p3Wins = 0;
		
		for(int i = 0; i < noOfGames; i++) {
			launcher.launch();
			if(launcher.p1Won)
				p1Wins++;
			if(launcher.p2Won)
				p2Wins++;
			if(launcher.p3Won)
				p3Wins++;			
		}
		
		System.out.println("P1 wins: " + p1Wins + ", P2 wins: " + p2Wins + ", P3 wins: " + p3Wins);
	}
}
