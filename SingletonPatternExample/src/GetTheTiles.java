
// source: http://www.newthinktank.com/2012/09/singleton-design-pattern-tutorial/

import java.util.LinkedList;

public class GetTheTiles implements Runnable {

	@Override
	public void run() {
		Singleton newInstance = Singleton.getInstance();

		System.out.println("Instance ID: " + System.identityHashCode(newInstance));
		System.out.println(newInstance.getLetterList());
		LinkedList<String> playerOneTiles = newInstance.getTiles(7);
		System.out.println("Player : " + playerOneTiles);
	}

}
