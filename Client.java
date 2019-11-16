import java.net.*;
import java.io.*;

public class Client{

    Socket sock;
    BufferedReader dataIn;
    PrintWriter dataOut;

    Client(int port, String ipAddress){
        try {
            sock = new Socket (ipAddress, port);
            System.out.println("Connected");
            dataIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new FileReader("Output.xml"));
            dataOut = new PrintWriter(sock.getOutputStream(), true);
            String userIn;
            OutputStream outStream = sock.getOutputStream();
            dataIn = new BufferedReader(new InputStreamReader (sock.getInputStream()));
            File fi = new File ("Output.xml");
            InputStream fileIn = new FileInputStream(fi);
            int count;
            byte [] buffer = new byte [8196];
            
            while((count = fileIn.read(buffer)) > 0) {
            	outStream.write(buffer, 0, count);
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            dataIn.close();
            dataOut.close();
            sock.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    
    public void checkResponce() {
    	try {
    		BufferedReader serverResponse = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    		String response;
    		while((response = serverResponse.readLine()) != null) {
    			System.out.println("Response: " + response);
    		}
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }


    public static void main(String [] args){

    Client cli = new Client(4000, "127.0.0.1");

    }
}