package sample.web.servlet;

import sample.client.CorbaClient;
import sample.model.corba.Hello;
import sample.model.corba.HelloPackage.Argument;
import sample.model.servlet.HelloRequest;
import sample.model.servlet.HelloResponse;
import sample.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

// 一旦Servletで実装
// RestAPIを簡単に使うのであれば、jax-rsのほうがいいかも
public class HelloServlet extends HttpServlet {
    private final CorbaClient client;

    public HelloServlet() {
        this.client = new CorbaClient();
    }

    // CORBAでの呼び出しサンプル用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hello hello = client.fetchHelloImpl();
        Argument argument = new Argument();
        argument.name = "Corba";
        String result = hello.sayHello(argument);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        HelloRequest helloRequest = JSONUtil.toObject(body, HelloRequest.class);
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setResult("Hi " + helloRequest.getName() + ".");
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(JSONUtil.toJson(helloResponse));
    }
}
