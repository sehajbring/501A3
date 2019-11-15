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
            dataOut = new PrintWriter(sock.getOutputStream(), true);
            String userIn ="";
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Here");
            while((userIn = input.readLine()) != null);{
                try {
                    dataOut.println((userIn));
                    System.out.println("echo: " + dataIn.readLine());

                } catch (Exception e) {
                    //TODO: handle exception
                }
                userIn = "Over";
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


    // public static void main(String [] args){

    //     Client cli = new Client(4000, "127.0.0.1");

    // }
}