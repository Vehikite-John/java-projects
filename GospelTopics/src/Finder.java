/*
 * Name: John Vehikite
 * Class: CS246
 * Program: Ponder 2 - GospelTopics
 * Professor: Brother Falin
 * Collaborators: Matthew McGuff, Mitchell Harvey, Julian Romero
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Finder - searches for keywords in files
 * 
 * @author John Vehikite
 *
 */
public class Finder {
	List<Topic> topics = new ArrayList<Topic>();
	
	/**
	 * reads file
	 * 
	 * if file is chapter, a search for keywords is done and results are outputted
	 * referenced Brother Falin's week 01 ponder code
	 * 
	 * @param filename - either topics file or chapter file
	 * @return true if file is read properly
	 * @throws Exception FileNotFound or IOException
	 */
	public Boolean readFile(String filename) throws Exception {
		
		if (!isGoodFile(filename)) {
			return false;
		}
	
		// Filereader actually reads the file
		// more efficient to wrap FileReader within BufferedReader
		try (BufferedReader buffer = new BufferedReader (new FileReader(filename))) {
			String line;
			
			if (filename.equals("topics.txt")) {
				while ((line = buffer.readLine()) != null) {
					// Create a new topic object
					Topic tempTopic = new Topic();

					// populate Topic's List<String> keywords member variable
					tempTopic = populateTopic(tempTopic, line);

					// add topic to Finder's List<Topic> topics member variable
					topics.add(tempTopic);
				} 
			}
			// read chapter files
			else {
				// Copy topics into temp variable
				List<Topic> tempTopics = new ArrayList<Topic>();
				
				for (Topic topic : topics) {
					tempTopics.add(topic);
				}
				
				// output string
				String output = filename + ": ";
				// for each line
				while ((line = buffer.readLine()) != null) {
					boolean topicFound = false;
					// for each topic
					for (Topic topic : tempTopics) {
						// search for each keyword of topic
						for (int i = 0; i < topic.keywords.size(); i++) {
							// if found, add to output string, remove from tempTopics and break out of inner for
							// used toLowerCase() to catch make sure words match, not word AND case
							if (line.toLowerCase().indexOf(topic.keywords.get(i).toLowerCase()) != -1) {
								output += topic.getTopicName() + ", ";
								// remove topic so we don't search for it on future lines
								tempTopics.remove(tempTopics.indexOf(topic));
								topicFound = true;
								break;
							}
						}
						// if topic was already found, break out of outer for
						if (topicFound == true) {
							break;
						}
						 
					}
					
				}
				
				// print out all except last comma and space
				System.out.println(output.substring(output.indexOf("ch"), output.length() - 2));
			}
		}
		
		catch (FileNotFoundException e) {
			Exception ex = new Exception("Exception while reading file", e);
			throw ex;
		}
		
		catch (IOException excep) {
			Exception ex = new Exception("Exception while reading file", excep);
			throw ex;
		}
		
		return true;
	}
	
	/**
	 * checks if file exists and can be read
	 * 
	 * referenced from Brother Falin's week 01 ponder code
	 * 
	 * @param filename
	 * @return true if it exists and can be read
	 */
	private Boolean isGoodFile(String filename) {
		File theFile = new File(filename);
		
		if (theFile.exists() && theFile.canRead()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * populates List<String> member variable in Topic
	 * 
	 * @param topic empty Topic to be added to topics list
	 * @param line string from topics file
	 * @return Topic now with name and keywords
	 */
	private Topic populateTopic(Topic topic, String line) {
		// find index of colon
		int indexOfColon = line.indexOf(':');
		
		// get keywords after colon
		String[] keywords = line.substring(indexOfColon + 1).split(",");
		
		// topic name is whatever is before the colon
		topic.setTopicName(line.substring(0, indexOfColon));
		
		// enhanced for loop to add keywords to Topic's List<String>
		for (String tempkw: keywords) {
			topic.addKeywords(tempkw);
		}
		return topic;
	}
	
	/**
	 * tests Finder and Topic
	 * 
	 * past versions found method block
	 */
	public void run() {
		// Create new Properties object
		Properties prop = new Properties();
		
		// prerequesite to opening properties file
		InputStream input = null;
		
		try {
			input = new FileInputStream("config.properties");
			// load prop file
			prop.load(input);
			
			// get property values
			readFile(prop.getProperty("topicsFile"));
			
			// code to read all files in a directory
			// reference: http://stackoverflow.com/questions/1844688/read-all-files-in-a-folder
			// solution 2
			String directory = prop.getProperty("directory");
			File path = new File(directory);
			File[] files = path.listFiles();
			
			for (File file: files) {
				if (file.isFile()) {
					String fullPath = directory + file.getName();
					readFile(fullPath);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * past versions of run()
	 * 
	 * v1
	 *  CODE TO TEST CREATING TOPIC OBJECTS
	 *		for (int i = 0; i < topics.size(); i++) {
	 *			Topic tempTopic = new Topic();
	 *			tempTopic = topics.get(i);
	 *			System.out.print(tempTopic.getTopicName() + ":");
	 *			for (int j = 0; j < tempTopic.keywords.size(); j++) {
	 *				System.out.print(tempTopic.keywords.get(j));
	 *				if (j != tempTopic.keywords.size() - 1) {
	 *					System.out.print(",");
	 *				}
	 *			}
	 *			System.out.println();
	 *		}
	 *
	 *v2
	 * CODE TO TEST TOPIC SEARCH
	 *		 readFile("ch01.txt");
	 *
	 *v3
	 * used before prop file was made to add '/' if needed
	 *		if (directory.charAt(directory.length() - 1) != '/') {
	 *			directory += "/";
	 *		}
	 */

	/**
	 * starts GospelTopics program
	 * @param args
	 */
	public static void main(String[] args) {
		// per instructions, instantiate Finder object, then call run()
		Finder finder = new Finder();
		finder.run();
	}
}
