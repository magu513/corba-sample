package sample.server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import sample.model.corba.Hello;
import sample.model.corba.HelloHelper;
import sample.model.corba.impl.HelloImpl;

public class CorbaServer implements Runnable {
    private ORB orb;

    public void start() {
        try {
            String[] args = new String[]{
                    "-ORBInitialPort", "1050",
                    // 文字コード指定が動作しているか分からない
                    // 日本語のレスポンスを返そうとして失敗した。
                    "-CodeSetEncoding", "UTF8"
            };
//            Properties properties = new Properties();
//            properties.setProperty("CodeSetEncoding", "UTF8=UTF16");
            orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            HelloImpl helloImpl = new HelloImpl(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello href = HelloHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Hello";
            NameComponent[] path = ncRef.to_name(name);
            ncRef.rebind(path, href);
            orb.run();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void run() {
        this.start();
    }

    @Override
    protected void finalize() throws Throwable {
        // 実際の動作時には終了を待つほうが安全
        orb.shutdown(false);
        super.finalize();
    }
}
