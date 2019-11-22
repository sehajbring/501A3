
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import jdk.internal.org.xml.sax.InputSource;

import java.io.*;

public class Server{

    Socket clientSocket;
    ServerSocket serverSock;
    DataInputStream dataIn;
    Document xmlDoc;

    Server (int port){
        try{

            serverSock = new ServerSocket(port);
            System.out.println("Server started\nWaiting for connection");
            clientSocket = serverSock.accept();
            System.out.println("New client");
          
            dataIn = new DataInputStream (clientSocket.getInputStream());
            SAXBuilder doc = new SAXBuilder();
            System.out.println("got something");
            Document netDoc = doc.build(dataIn);
            
            XMLOutputter serial = new XMLOutputter(Format.getPrettyFormat());
			serial.output(netDoc, System.out);
			serial.output(netDoc, new FileOutputStream("OutputBetter.xml"));

//            
//            while((count = fileIn.read(buffer)) > 0) {
////            	outStream.write(buffer, 0, count);
//            }
            
//            String input;
////            pw.println("recived");
//            while((input = dataIn.readLine()) != null) {
//            	System.out.println(input);
//            }

            System.out.println("Closing connection");
            clientSocket.close();
            dataIn.close();
            Deserializer d1 = new Deserializer();

        }
        catch(IOException e ){
            e.printStackTrace();
        }
        catch (JDOMException e) {
        	
        }
    }

    public static void main (String [] args){
        Server ser = new Server(4321);

    }
}