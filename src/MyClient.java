import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {

    public static void main(String[] args) {
        String host = (args.length<1)?null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Adder stub = (Adder) registry.lookup("rmiImpl");

            System.out.println(stub.add(34,4));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
