import java.util.ArrayList;
import java.util.List;

/**
 * Topic - each topic has a name and list of keywords associated with topic
 * 
 * @author John Vehikite
 *
 */
public class Topic {
	
	private String topicName;
	List<String> keywords = new ArrayList<String>();
	
	/**
	 * adds keyword to keywords member variable
	 * @param keyword
	 */
	public void addKeywords(String keyword) {
		keywords.add(keyword);
	}
	
	/**
	 * sets topicName member variable
	 * 
	 * @param name
	 */
	public void setTopicName(String name) {
		topicName = name;
	}
	
	/**
	 * gets value of topicName member variable
	 * @return name string
	 */
	public String getTopicName() {
		return topicName;
	}
}
