// source: http://www.newthinktank.com/2012/09/singleton-design-pattern-tutorial/

// implement different players as threads
public class ScrabbleTestThreads {
	public static void main(String[] args) {
		Runnable getTiles = new GetTheTiles();
		Runnable getTilesAgain = new GetTheTiles();

		new Thread(getTiles).start();
		new Thread(getTilesAgain).start();
	}
}
