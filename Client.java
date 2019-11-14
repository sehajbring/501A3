import java.net.*;
import java.io.*;

public class Client{

    Socket sock;
    BufferedReader dataIn;
    DataOutputStream dataOut;

    Client(int port, String ipAddress){
        try {
            sock = new Socket (ipAddress, port);
            System.out.println("Connected");
            dataIn = new BufferedReader(new InputStreamReader(System.in));
            dataOut = new DataOutputStream(sock.getOutputStream());
            String line ="";
            System.out.println("Here");
            while(!line.equals("Over"));{
                try {
                    line = dataIn.readLine();
                    dataOut.writeUTF(line);

                } catch (Exception e) {
                    //TODO: handle exception
                }
                line = "Over";
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


    public static void main(String [] args){

        Client cli = new Client(4000, "127.0.0.1");

    }
}