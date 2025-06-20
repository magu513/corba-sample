package sample.model.corba.impl;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.omg.CORBA.ORB;
import sample.model.corba.HelloPOA;
import sample.model.corba.HelloPackage.Argument;
import sample.util.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloImpl extends HelloPOA {
    private final ORB orb;

    public HelloImpl(ORB orb) {
        this.orb = orb;
    }


    @Override
    public String sayHello(Argument arg) {
        return "Hello " + arg.name + ".";
    }

    @Override
    public String transmitSayHello(Argument arg) {
        // web apiの実行
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://localhost:58080/hello");
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", arg.name);
        try {
            StringEntity entity = new StringEntity(Util.toJson(requestBody));
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());

            // なんか変換処理をしたい
            // 今回は適当に前後に文字を挿入した
            return "```" + result + "```";
        } catch (IOException e) {
            System.err.println(e);
            return "caused error.";
        }
    }

    @Override
    public void shutdown() {
        orb.shutdown(false);
    }
}
