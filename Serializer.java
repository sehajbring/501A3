import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
public class Serializer {
    Map<String, Integer> objectMap = new HashMap<>();
	int idNumber;
	Client c1;
    
    public void addToMap() {
    	idNumber = 0;
    	Object objA = new ObjectA();
    	ObjectB objB = new ObjectB();
    	ObjectC objC = new ObjectC();
    	ObjectD objD = new ObjectD();
    	objectMap.put(objA.getClass().getName(), ++idNumber);
    	objectMap.put(objB.getClass().getName(), ++idNumber);
    	objectMap.put(objC.getClass().getName(), ++idNumber);
    	objectMap.put(objD.getClass().getName(), ++idNumber);

    	Document doc = serialize(objA);
    	doc = serialize(objB);
    	c1 = new Client (4000, "127.0.0.1");
    }
    
	public org.jdom2.Document serialize (Object obj){
		Class <?> cl = obj.getClass();
		Field arr[] = cl.getDeclaredFields();
		Document document = new Document ();
		document.setRootElement(new Element ("Serialized"));
		Element parentElement = new Element ("Object").setAttribute("Class" , cl.getName()).setAttribute("id" , objectMap.get(obj.getClass().getName()).toString());
		
		for(Field fi : arr) {
			try {
				fi.setAccessible(true);
				Element childElement = new Element("Field").setAttribute("Name" , fi.getName()).setAttribute("DeclearingClass", fi.getDeclaringClass().getName());
				System.out.println(fi.getType().getName());
				if(fi.getType().isPrimitive()) {
					fi.setAccessible(true);
					childElement.addContent(new Element ("Value").setText(fi.get(obj).toString()));
				}
				
				else if (fi.getType().isPrimitive() == true || !fi.getType().toString().equals("java.lang.String")|| (fi.getType().isArray()) == false ) {
				
					System.out.println("here");
				}
				else {
				}
		
				parentElement.addContent(childElement);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		document.getRootElement().addContent(parentElement);
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
	    //output xml to console for debugging
	    try {
			xmlOutputter.output(document, System.out);
			xmlOutputter.output(document, new FileOutputStream("Output.xml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return document;
	}
	
	public static void main (String [] args) {
		Serializer s1 = new Serializer();
		s1.addToMap();
	}
	
}
