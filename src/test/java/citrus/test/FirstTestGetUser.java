package citrus.test;


import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.dsl.junit.jupiter.CitrusExtension;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.message.MessageType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

@ExtendWith({CitrusExtension.class})
public class FirstTestGetUser {

    @CitrusResource
    private TestContext context;

    @CitrusResource
    private TestRunner runner;

    @CitrusResource
    private TestDesigner designer;

    @Autowired
    private HttpClient restClientRequest;

    @Test
    @CitrusTest
    @DisplayName("Получение информации о пользователе")
    public void getTestActions() {
        context.setVariable("value", "superValue");
        runner.echo("Property value = " + context.getVariable("value"));

        runner.echo("We have userId = " + context.getVariable("userId"));
        runner.echo("We have userId = ${userId}");

        runner.run(http()
                .client("restClientRequest")
                .send()
                .get("users/" + context.getVariable("userId")));

        runner.run(http().client("restClientRequest")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type(MessageType.JSON));
    }

}
