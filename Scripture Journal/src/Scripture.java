/**
 * Creates Scripture Annotation object
 * 
 * @author John Vehikite
 *
 */
public class Scripture implements Annotation {

	// member variables
	private String book;
	private int chapter;
	private int startVerse;
	private int endVerse;
	
	/**
	 * gets book
	 * 
	 * @return book
	 */
	public String getBook() {
		return book;
	}

	/**
	 * sets book
	 * 
	 * @param book
	 */
	public void setBook(String book) {
		this.book = book;
	}

	/**
	 * gets chapter
	 * @return chapter
	 */
	public int getChapter() {
		return chapter;
	}

	/**
	 * sets chapter
	 * 
	 * @param chapter
	 */
	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	/**
	 * gets startVerse
	 * 
	 * @return startVerse
	 */
	public int getStartVerse() {
		return startVerse;
	}

	/**
	 * sets startVerse
	 * 
	 * @param startVerse
	 */
	public void setStartVerse(int startVerse) {
		this.startVerse = startVerse;
	}

	/**
	 * gets endVerse
	 * @return endVerse
	 */
	public int getEndVerse() {
		return endVerse;
	}

	/**
	 * sets endVerse
	 * 
	 * @param endVerse
	 */
	public void setEndVerse(int endVerse) {
		this.endVerse = endVerse;
	}

	/* (non-Javadoc)
	 * @see Annotation#getDisplayText()
	 */
	public String getDisplayText() {
		String output = "-" + book + " ";
		if (chapter > 0) {
			output += chapter;
		}
		if (startVerse > 0) {
			output += ":" + startVerse;
		}
		if (endVerse > 0) {
			output += "-" + endVerse;
		}
		return output;
	}

}
