import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.lang.reflect.*;
public class Serializer {
	
	public org.jdom2.Document serialize (Object obj){
		Class <?> cl = obj.getClass();
		Field arr[] = cl.getDeclaredFields();
		Document document = new Document ();
		document.setRootElement(new Element ("Serialized"));
		Element el = new Element ("Object");
		System.out.println(arr.length);
		el.setAttribute("Class" , cl.getName());

		for(Field fi : arr) {
			try {
				fi.setAccessible(true);
				el.addContent(new Element (fi.getName()).setText(fi.get(obj).toString()));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		document.getRootElement().addContent(el);
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
	    //output xml to console for debugging
	    try {
			xmlOutputter.output(document, System.out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}
	
	public static void main (String [] args) {
		Serializer s1 = new Serializer();
		s1.serialize(new ObjectA());
	}
	
}
