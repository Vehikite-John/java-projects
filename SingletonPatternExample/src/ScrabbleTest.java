
// source: http://www.newthinktank.com/2012/09/singleton-design-pattern-tutorial/

import java.util.LinkedList;

public class ScrabbleTest {
	public static void main(String[] args) {
		Singleton newInstance = Singleton.getInstance();
		
		// Instance ID should be the same for both players
		System.out.println("Instance ID: " + System.identityHashCode(newInstance));
		
		// print letters in list
		System.out.println(newInstance.getLetterList());
		
		// player 1 gets first 7 letters from list
		// first 7 letters removed from list
		LinkedList<String> playerOneTiles = newInstance.getTiles(7);
		System.out.println("Player 1: " + playerOneTiles);
		
		// print remaining letters from list
		System.out.println(newInstance.getLetterList());
		
		// repeat for player two
		// make sure instance is the same and player two tiles are next 7 in list
		Singleton instanceTwo = Singleton.getInstance();
		System.out.println("Instance 2 ID: " + System.identityHashCode(instanceTwo));
		LinkedList<String> playerTwoTiles = newInstance.getTiles(7);
		System.out.println("Player 2: " + playerTwoTiles);
	}
}
