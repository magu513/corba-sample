package sample;

import org.apache.catalina.LifecycleException;
import sample.model.translate.SourceSample;
import sample.model.translate.TargetSample;
import sample.server.CorbaServer;
import sample.server.TomcatServer;
import sample.util.Util;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        sampleConvert();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        TomcatServer tomcatServer = new TomcatServer();
        tomcatServer.setPort(58080);
        tomcatServer.setRootPath("/");
        executorService.submit(tomcatServer);
        CorbaServer corbaServer = new CorbaServer();

        executorService.submit(corbaServer);
    }

    private static void sampleConvert() {
        SourceSample source = new SourceSample();
        source.setName("hello");
        try {
            TargetSample targetSample = (TargetSample) Util.translate(source);
            System.out.println(targetSample.getFoo());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
