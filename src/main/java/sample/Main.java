package sample;

import org.apache.catalina.LifecycleException;
import sample.server.CorbaServer;
import sample.server.TomcatServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        TomcatServer tomcatServer = new TomcatServer();
        tomcatServer.setPort(58080);
        tomcatServer.setRootPath("/");
        executorService.submit(tomcatServer);
        // FIXME EJBで実装すればよかった
        CorbaServer corbaServer = new CorbaServer();

        executorService.submit(corbaServer);
    }
}
