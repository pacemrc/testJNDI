import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.NamingManager;


public class JNDIClient {

    public static void main(String[] args) throws NamingException {

        InitialContext context = new InitialContext();
//        context.lookup("rmi://127.0.0.1:1099/calc");
        context.lookup("ldap://127.0.0.1:1389/calc");

    }
}
