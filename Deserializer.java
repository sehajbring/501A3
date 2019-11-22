import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.util.*;
import java.io.*;

public class Deserializer {
	List<Element> objectList;
	List <Element> fieldList;
//	org.jdom2.Document document


	public Object deserialize(Document doc) {

		Element docRoot= doc.getRootElement();
		objectList = docRoot.getChildren();
	//		fieldList = new ArrayList <>();
		Object returnObj = null;
		for(Element objects: objectList) {
			Attribute attr = objects.getAttribute("Class");
			
			if (attr.getValue().equals("ObjectA")) {
				objA(objects);
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
		List<Element> li = el.getChildren();
		ObjectA oA = new ObjectA();
		oA.a = 9;
		System.out.println(oA.a);
		oA.a = Integer.parseInt(li.get(0).getValue());
		System.out.println(oA.a);
		
		
	}
	
	public void objB (Element el) {
		
	}
	
	public void objC (Element el) {
		
	}
	
	public void objD (Element el) {
		
	}
	

	
}
