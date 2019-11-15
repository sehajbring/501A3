import java.io.IOException;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.*;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.FileOutputStream;

public class Sender {
    
    /**
     *
     */
    // private static final long serialVersionUID = 1L;
    ObjectOutputStream objectOut;

    public void creatObject(){
        ObjectA oba = new ObjectA();
        serializeObject(oba);
    }

    public void serializeObject(Object obj){
    	
        }

    public static void main(String[] args) {
        Sender s1 = new Sender();
        s1.creatObject();
        // Client serve = new Client(4000, "127.0.0.1");
        
    }
}