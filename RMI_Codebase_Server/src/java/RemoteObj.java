import java.rmi.RemoteException;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;
public class RemoteObj extends UnicastRemoteObject implements IRemote {

    public RemoteObj() throws RemoteException {}

    public Integer sum(List<Integer> params) throws RemoteException {
        Integer sum = 0;
        for (Integer param : params) {
            sum += param;
        }
        return sum;
    }

    @Override
    public Object getObject() {
        return new Payload2();
    }
}