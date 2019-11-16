import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.util.*;
import java.io.*;

public class Deserializer {
	List<Element> objectList;
	List <Element> fieldList;
//	org.jdom2.Document document
	public Object deserialize() {
		SAXBuilder saxBuild = new SAXBuilder();
		File inFile = new File ("Output");
		Document doc = null;
		try {
			doc = saxBuild.build(inFile);
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element docRoot= doc.getRootElement();
		objectList = docRoot.getChildren();
//		fieldList = new ArrayList <>();
		Object returnObj = null;
		for(Element objects: objectList) {
			Attribute attr = objects.getAttribute("Class");
			
			if (attr.getValue().equals("ObjectA")) {
			}
			else if(attr.getValue().equals("ObjectB")) {
				
				
				System.out.println("HERE2");
			}
			else if(attr.getValue().equals("ObjectC")) {
				System.out.println("HERE3");
			}
			else if(attr.getValue().equals("ObjectD")) {
				System.out.println("HERE4");
			}
		}
		return null;
	}
	
	public void objA (Element el) {
		ObjectA oA = new ObjectA();
	}
	
	public void objB (Element el) {
		
	}
	
	public void objC (Element el) {
		
	}
	
	public void objD (Element el) {
		
	}
	
	public static void main (String [] args) {
		Deserializer ds = new Deserializer();
		ds.deserialize();
	}
	
}
