import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
public interface IRemote extends Remote {

    public Integer sum(List<Integer> params) throws RemoteException;

    public Object getObject() throws RemoteException;
}