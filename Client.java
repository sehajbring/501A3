import java.net.*;
import java.io.*;

public class Client{

    private Socket sock;
    private BufferedReader dataIn;
    private DataOutputStream dataOut;

    Client(int port, String ipAddress, String inFile){
        try {
            sock = new Socket (ipAddress, port);
            System.out.println("Connected");
            dataIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            DataOutputStream dataOut = new DataOutputStream(sock.getOutputStream());
            dataOut.writeBytes(inFile);
            dataOut.flush();
            dataOut.close();
            // String userIn;
            // OutputStream outStream = sock.getOutputStream();
            // dataIn = new BufferedReader(new InputStreamReader (sock.getInputStream()));
            // // InputStream fileIn = new FileInputStream(fi);
            // int count;
            // byte [] buffer = new byte [8196];
            
            // while((count = fileIn.read(buffer)) > 0) {
            // 	outStream.write(buffer, 0, count);
            // }
            

            
        } catch (Exception e) {
            System.out.println("HERE:");
            e.printStackTrace();
        }
        try{
            // dataIn.close();
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


    // public static void main(String [] args){
    //     Client c1 = new Client(4321, "192.168.56.1", "Output.xml");
    // }



}