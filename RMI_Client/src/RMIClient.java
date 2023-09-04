import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class RMIClient {

    public static void getRemoteObj() throws IOException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        MyRemoteInterface remoteObj = (MyRemoteInterface) registry.lookup("RemoteObj");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Integer sum = remoteObj.sum(list);
        System.out.println(sum);

    }

    public static void getRemoteRefObj() throws NamingException {

        InitialContext context = new InitialContext();
        context.lookup("rmi://localhost:1099/exp");
    }

    public static void main(String[] args) throws IOException, NotBoundException, NamingException {
        getRemoteObj();
//        getRemoteRefObj();
    }
}
