/**
 * creates Topic Annotation object
 * 
 * @author John Vehikite
 *
 */
public class Topic implements Annotation {

	private String topic;
	
	/* (non-Javadoc)
	 * @see Annotation#getDisplayText()
	 */
	public String getDisplayText() {
		String output = "-" + topic;
		return output;
	}
	
	/**
	 * gets topic
	 * 
	 * @return topic
	 */
	public String getTopic() {
		return topic;
	}
	
	/**
	 * sets topic
	 * 
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
}
