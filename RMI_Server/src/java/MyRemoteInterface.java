import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyRemoteInterface extends Remote {

    public Integer sum(List<Integer> params) throws RemoteException;


}
