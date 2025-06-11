package sample.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import sample.client.CorbaClient;
import sample.corba.Hello;
import sample.corba.HelloPackage.Argument;
import sample.model.servlet.HelloRequest;
import sample.model.servlet.HelloResponse;
import sample.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class ToCorbaServlet extends HttpServlet {
    private CorbaClient client;
    public ToCorbaServlet() {
        this.client = new CorbaClient();
    }

    // 疑似的にcorba→restを実行する用
    // corbaの実行結果はそのまま表示する
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hello callable = getCallable();
        Argument arg = new Argument();
        arg.name = "call_corba";
        String result = callable.transmitSayHello(arg);
        resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        HelloRequest helloRequest = JSONUtil.toObject(body, HelloRequest.class);
        HelloResponse helloResponse = new HelloResponse();
        Hello callable = getCallable();
        Argument arg = new Argument();
        arg.name = helloRequest.getName();

        String result = callable.sayHello(arg);

        // 本来はデータ形式へ変換したり、必要なデータを追加したりする。
        // 今回はサボって結果に適当な文字列を追加した。
        helloResponse.setResult(result + "Welcome CORBA Sample.");
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(JSONUtil.toJson(helloResponse));
    }

    private Hello getCallable() {
        return client.fetchHelloImpl();
    }
}
