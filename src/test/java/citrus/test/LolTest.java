package citrus.test;

import com.consol.citrus.annotations.CitrusEndpoint;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.dsl.junit.jupiter.CitrusExtension;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.http.client.HttpClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;

@ExtendWith(CitrusExtension.class)
public class LolTest {

    @CitrusEndpoint
    private HttpClient httpClient;

    @CitrusResource
    private TestRunner runner;

    @Test
    @CitrusTest
    public void test() {
        runner.http(action -> action.client(httpClient)
                .send()
                .get("/hello"));

        runner.http(action -> action.client(httpClient)
                .receive()
                .response(HttpStatus.OK));
    }
}