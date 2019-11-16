
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.Document;

import jdk.internal.org.xml.sax.InputSource;

import java.io.*;

public class Server{

    Socket clientSocket;
    ServerSocket serverSock;
    BufferedReader dataIn;
    Document xmlDoc;

    Server (int port){
        try{

            serverSock = new ServerSocket(port);
            System.out.println("Server started\nWaiting for connection");
            clientSocket = serverSock.accept();
            System.out.println("New client");
          
            dataIn = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));
            File fi = new File ("Output.xml");
            InputStream fileIn = new FileInputStream(fi);
            long length = fi.length();
            int count;
            byte [] buffer = new byte [8196];
            
            while((count = fileIn.read(buffer)) > 0) {
            	outStream.write(buffer, 0, count);
            }
            
            String input;
//            pw.println("recived");
            while((input = dataIn.readLine()) != null) {
            	System.out.println(input);
            }

            System.out.println("Closing connection");
            clientSocket.close();
            dataIn.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main (String [] args){
        Server ser = new Server(4000);

    }
}