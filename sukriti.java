package com.sukriti.core;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class sukriti {

	public static void main(String argv[]) {

	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Library");
		doc.appendChild(rootElement);

		// rollno elements
		Element rollno = doc.createElement("RollNo");
		rootElement.appendChild(rollno);

		// set attribute torollno element
		Attr attr = doc.createAttribute("rollno");
		attr.setValue("1");
		rollno.setAttributeNode(attr);

		
		

		// firstname elements
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("sukriti"));
		rollno.appendChild(firstname);

		// lastname elements
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("kakkar"));
		rollno.appendChild(lastname);

		// author elements
		Element book = doc.createElement("book_author");
		book.appendChild(doc.createTextNode("Paulo Coehlo"));
		rollno.appendChild(book);

		// publish date elements
		Element publish = doc.createElement("publish_date");
		publish.appendChild(doc.createTextNode("2/3/15"));
		rollno.appendChild(publish);

		//  content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\world.xml"));

		// Output to console for testing
		StreamResult res = new StreamResult(System.out);

		transformer.transform(source, res);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}