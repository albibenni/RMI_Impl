import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer {
    public static void main(String[] args) {
        try {
            AdderRemote obj = new AdderRemote();
            Adder stub = (Adder) UnicastRemoteObject.exportObject(obj, 3939);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("rmiImpl", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
