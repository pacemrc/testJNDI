import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MyRemoteObject extends UnicastRemoteObject implements MyRemoteInterface {

    protected MyRemoteObject() throws RemoteException {

    }

    @Override
    public Integer sum(List<Integer> params) throws RemoteException {
        Integer sum = 0;
        for (Integer param : params) {
            sum += param;
        }
        return sum;
    }

}
