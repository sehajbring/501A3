
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server{

    Socket sock;
    ServerSocket serverSock;
    DataInputStream dataIn;


    Server (int port){
        try{

            serverSock = new ServerSocket(port);
            System.out.println("Server started\nWaiting for connection");
            sock = serverSock.accept();
            System.out.println("New client");
            dataIn = new DataInputStream(new BufferedInputStream (sock.getInputStream()));
            String input ="";
            while(!input.equals("Over")){
                try{
                    input= dataIn.readUTF();
                    System.out.println(input);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Closing connection");
            sock.close();
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