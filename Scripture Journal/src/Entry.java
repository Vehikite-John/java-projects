import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;


/**
 * creates object representing journal entry
 * 
 * @author John Vehikite
 *
 */

public class Entry {
	
	// member variables
	private String date;
	private List<Scripture> scriptures = new ArrayList<Scripture>();
	private List<Topic> topics = new ArrayList<Topic>();
	private String content;
	private List<Annotation> annotations = new ArrayList<Annotation>();
	
	/**
	 * adds scripture annotation to annotations
	 * overloaded method
	 * 
	 * @param scripture
	 */
	public void setAnnotations(Scripture scripture) {
		
		// anonymous class
		// source of info: https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
		Annotation annotation = new Annotation() {
			public String getDisplayText() {
				return scripture.getDisplayText();
			}
		};
		
		// add annotation to annotations
		annotations.add(annotation);
	}
	
	/**
	 * adds topic annotation to annotations
	 * overloaded method
	 * 
	 * @param scripture
	 */
	public void setAnnotations(Topic topic) {
		Annotation annotation = new Annotation() {
			public String getDisplayText() {
				return topic.getDisplayText();
			}
		};
		annotations.add(annotation);
	}
	
	/**
	 * returns annotations - List<Annotation>
	 * @return
	 */
	public List<Annotation> getAnnotations() {
		return annotations;
	}
	
	/**
	 * populates scriptures member variable
	 * 
	 * @param list
	 */
	public void setScriptures(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Element element = (Element)node;
			NamedNodeMap nnm = element.getAttributes();
			Scripture scripture = new Scripture();
			scripture.setBook(nnm.getNamedItem("book").getTextContent());
			scripture.setChapter(Integer.parseInt(nnm.getNamedItem("chapter").getTextContent()));
			
			// if nnm only has 2 elements, don't assign values to startVerse and endVerse
			// ex: Abraham 1 (no verses)
			if (nnm.getLength() > 2) {
				scripture.setStartVerse(Integer.parseInt(nnm.getNamedItem("startVerse").getTextContent()));
				
				// if nnm has 4 elements, assign value to endVerse
				if (nnm.getLength() == 4) {
					scripture.setEndVerse(Integer.parseInt(nnm.getNamedItem("endVerse").getTextContent()));
				}
			}
			// add scripture to scriptures
			scriptures.add(scripture);
			
			// add scripture annotation to annotations
			setAnnotations(scripture);
		}
	}
	
	
	/**
	 * populate topics member variable
	 * 
	 * @param list
	 */
	public void setTopics(NodeList list) {
		for (int i = 0; i < list.getLength(); i++) {
			// create temp Topic object
			Topic topic = new Topic();
			
			Node node = list.item(i);
			Element element = (Element)node;
			topic.setTopic(element.getAttribute("name"));
			
			// add topic to topics
			topics.add(topic);
			
			// add topic annotation to annotations
			setAnnotations(topic);
		}
	}
	
	/**
	 * gets date
	 * 
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * sets date
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * gets content
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * sets content
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
