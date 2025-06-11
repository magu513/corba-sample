package sample.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.nio.file.Paths;

public class TomcatServer implements Runnable {
    private Tomcat tomcat;
    private int port = 8080;
    private String rootPath = "/";

    public TomcatServer() {
        this.tomcat = new Tomcat();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String toAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().toString();
    }

    public void start() throws LifecycleException {
        tomcat.addWebapp(rootPath, toAbsolutePath("src/main/webapp"));
        tomcat.setPort(port);
        tomcat.start();
        tomcat.getServer().await();
    }

    @Override
    public void run() {
        try {
            this.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
