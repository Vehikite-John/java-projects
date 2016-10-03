/*
 * Name: John Vehikite
 * Class: CS246
 * Program: Ponder 3 - Scripture Journal
 * Professor: Brother Falin
 * Collaborators: Thomas Nichols, Kevin Kingdon
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * creates object representing a Scripture Journal
 * 
 * @author John Vehikite
 *
 */
public class Journal {
	
	List<Entry> entries = new ArrayList<Entry>();
	
	/**
	 * tests program
	 * 
	 * past versions in comment blocks below
	 * 
	 * @param fileName
	 */
	public void run(String fileName) {
		// v3 - complete program
		Document doc = parse(fileName);
		setEntries(doc);
		displayEntries();
		
		// v2 - expected outcomes
		// 1. parse file
		// 2. populate entries with date and content
		// 3. display
		
		// v1 - expected outcomes
		// 1. parse file
		// 2. for each entry, output "Entry" and date
		// Document doc = parse(fileName);
//		NodeList entryList = doc.getElementsByTagName("entry");
//		for (int i = 0; i < entryList.getLength(); i++) {
//			//entries.add(((Element)entryList.item(i)).getAttribute("date"));
//			Node node = entryList.item(i);
//			String entry = node.getNodeName();
//			System.out.println(entry.substring(0, 1).toUpperCase() + entry.substring(1));
//			Element element = (Element)node;
//			System.out.println(element.getAttribute("date"));
//		}
	}
	
	/**
	 * populates entries member variable
	 * 
	 * @param doc
	 */
	private void setEntries(Document doc) {
		NodeList entryList = doc.getElementsByTagName("entry");
		NodeList contentList = doc.getElementsByTagName("content");
		
		for (int i = 0; i < entryList.getLength(); i++) {
			// create temp Entry object
			Entry entry = new Entry();
			
			// create nodes from nodelists
			Node entryNode = entryList.item(i);
			Node contentNode = contentList.item(i);
			
			// cast entryNode to type Element to be able to call getAttribute() and getElementsByTagName()
			Element element = (Element)entryNode;
			
			// assign value to entry's member variables
			entry.setDate(element.getAttribute("date"));
			entry.setContent(contentNode.getTextContent());
			entry.setScriptures((element.getElementsByTagName("scripture")));
			entry.setTopics((element.getElementsByTagName("topic")));
			
			// add entry to journal's entries member variable
			entries.add(entry);
		}
	}

	/**
	 * displays each entry to user
	 */
	private void displayEntries() {
		for (int i = 0; i < entries.size(); i++) {
			// create temp list of Annotation objects
			List<Annotation> annotations = new ArrayList<Annotation>();
			
			// output
			System.out.println("\n-----");
			System.out.println("Entry");
			
			// begin getting info from entries
			System.out.println("Date: " + entries.get(i).getDate());
			System.out.println("Content:\n" + entries.get(i).getContent());
			annotations = entries.get(i).getAnnotations();
			System.out.println("Annotations:");
			for (Annotation annotation : annotations) {
				System.out.println(annotation.getDisplayText());
			}
		}
	}

	/**
	 * parses xml file using DOM method
	 * 
	 * @param fileName
	 * @return parsed doc
	 */
	private Document parse(String fileName) {
		File file = new File(fileName);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		Document doc = null;
		
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(file);
		}
		catch (ParserConfigurationException | SAXException | IOException ex) {
			System.out.println("Problem parsing '" + fileName + "': " + ex.getMessage());
		}
		
		// Normalize XML
		doc.getDocumentElement().normalize();
		
		return doc;
	}

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java Conference fileName");
			System.exit(1);
		}
		Journal journal = new Journal();
		journal.run(args[0]);
	}

}
