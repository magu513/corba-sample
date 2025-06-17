package sample.client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import sample.model.corba.Hello;
import sample.model.corba.HelloHelper;

public class CorbaClient {
    private final ORB orb;
    private final NamingContextExt ncRef;

    public CorbaClient() {
        try {
            // TODO 外出ししたい
            String[] args = new String[]{
                    "-ORBInitialPort", "1050",
                    "-CodeSetEncoding", "UTF8"
            };
            orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            ncRef = NamingContextExtHelper.narrow(objRef);
        } catch (InvalidName e) {
            throw new RuntimeException(e);
        }
    }

    public Hello fetchHelloImpl() {
        try {
            Hello hello = HelloHelper.narrow(ncRef.resolve_str("Hello"));
            return hello;
        } catch (NotFound e) {
            throw new RuntimeException(e);
        } catch (CannotProceed e) {
            throw new RuntimeException(e);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            throw new RuntimeException(e);
        }
    }
}
