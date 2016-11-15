
// source: http://www.newthinktank.com/2012/09/singleton-design-pattern-tutorial/

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Singleton {

	// hold one and only Singleton class instance
	private static Singleton firstInstance = null;

	// hold scrabble letters in a String array
	String[] scrabbleLetters = { "a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "c", "c", "d", "d", "d", "d",
			"e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "g", "g", "g", "h", "h", "i", "i",
			"i", "i", "i", "i", "i", "i", "i", "j", "k", "l", "l", "l", "l", "m", "m", "n", "n", "n", "n", "n", "n",
			"o", "o", "o", "o", "o", "o", "o", "o", "p", "p", "q", "r", "r", "r", "r", "r", "r", "s", "s", "s", "s",
			"t", "t", "t", "t", "t", "t", "u", "u", "u", "u", "v", "v", "w", "w", "x", "y", "y", "z", };

	// make a linked list from the array
	private LinkedList<String> letterList = new LinkedList<String>(Arrays.asList(scrabbleLetters));

	static boolean firstThread = true;

	// make sure there is only one instance
	private Singleton() {
	}

	// getInstance() is universally used with Singleton
	public static Singleton getInstance() {
		if (firstInstance == null) {
			if (firstThread) {
				firstThread = false;

				Thread.currentThread();
				try {
					// make first thread slow down to test program with multiple
					// threads
					// must be surrounded in try/catch
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// synchronized - force thread to "wait its turn"
			synchronized (Singleton.class) {
				if (firstInstance == null) {

					// create instance only if one doesn't exist
					// "lazy instantiantion" - only created if needed
					firstInstance = new Singleton();

					// shuffle scrabble letters
					Collections.shuffle(firstInstance.letterList);
				}
			}
		}
		// return the only instance of class
		return firstInstance;
	}

	// return list of all available letters
	public LinkedList<String> getLetterList() {
		return firstInstance.letterList;
	}

	public LinkedList<String> getTiles(int howManyTiles) {
		LinkedList<String> tilesToSend = new LinkedList<String>();

		for (int i = 0; i <= howManyTiles; i++) {

			// remove 1st element in list
			// since 1st is removed, the index is always 0
			tilesToSend.add(firstInstance.letterList.remove(0));
		}

		return tilesToSend;
	}
}
