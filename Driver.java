
public class Driver {
	public static void main (String [] args) {
		Server s1 = new Server(4000);
		Serializer d1 = new Serializer();
		d1.addToMap();
	    Client cli = new Client(4000, "127.0.0.1");
	    Deserializer ds = new Deserializer();
	    ds.deserialize();
	    

	}
}
