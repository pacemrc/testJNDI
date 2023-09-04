import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void BindRemoteObj() throws RemoteException, AlreadyBoundException{
        Registry registry = LocateRegistry.createRegistry(1099);
        //绑定远程对象
        MyRemoteObject myRemoteObj = new MyRemoteObject();
        registry.bind("RemoteObj",myRemoteObj);
    }

    public static void BindRefRemoteObj() throws RemoteException, NamingException, AlreadyBoundException, MalformedURLException {

        Registry registry = LocateRegistry.createRegistry(1099);
        Reference reference = new Reference("calc", "calc", "http://127.0.0.1:8000/");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("exp",referenceWrapper);

    }


    public static void main(String[] args) throws AlreadyBoundException, RemoteException, NamingException, MalformedURLException {
        BindRemoteObj();
//        BindRefRemoteObj();

    }
}
