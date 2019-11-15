import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
        try{
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);
            objectOut.flush();
            objectOut.close();
            fileOut.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        }

    public static void main(String[] args) {
        Sender s1 = new Sender();
        s1.creatObject();
        // Client serve = new Client(4000, "127.0.0.1");
        
    }
}