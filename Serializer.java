import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Serializer {
    Map<String, Integer> objectMap = new HashMap<>();
	int idNumber;
//	Client c1;
	String output;
    
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

    	Document doc = serialize(objB);
    	doc = serialize(objB);
//    	c1 = new Client (4321, "192.168.56.1", output);
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
				
				else if (fi.getType().isPrimitive() == true || !fi.getType().toString().equals("java.lang.String")|| (fi.getType().equals("[I") )) {
				
					
				}
				else {
				}
		
				parentElement.addContent(childElement);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
		change();
		document.getRootElement().addContent(parentElement);
		
		//output xml to console for debugging
		try {
			xmlOutputter.output(document, System.out);
			xmlOutputter.output(document, new FileOutputStream("Output.xml"));
			output = xmlOutputter.outputString(document);
			Client c1 = new Client(4321, "192.168.56.1", output);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Deserializer d1 = new Deserializer();
		d1.deserialize(document);
		
		
		
	    
		return document;
	}
	
	public void change() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to change anything before continuing (y/n): ");
		String x = sc.nextLine();
		x.toLowerCase();
		if(x.equals("y")){
			
		}
		else if (x.equals("n")) {
			
		}
		else {
			System.out.println("invalid input");
			System.exit(0);
		}
	}
	
	public static void main (String [] args) {
		Serializer s1 = new Serializer();
		s1.addToMap();
		
	}
	
}
