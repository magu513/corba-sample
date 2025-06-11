package sample.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// 時間がないので、REST APIのjax-rsでの実装はあきらめる
@Path("/foo")
public class FooController {
    @GET
    public DataFoo get() {
        DataFoo foo = new DataFoo();
        foo.setName("my name is foo");

        return foo;
    }

    class DataFoo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
