package citrus;


import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.junit.JUnit4CitrusSupport;
import com.consol.citrus.message.MessageType;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.HttpStatus;

import static com.consol.citrus.actions.EchoAction.Builder.echo;
import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class FirstTestGetUser extends JUnit4CitrusSupport {

    private TestContext context;

    @Test
    @CitrusTest
    @DisplayName("Получение информации о пользователе")
    public void getTestActions() {
        this.context = citrus.getCitrusContext().createTestContext();

        context.setVariable("value", "superValue");
        run(echo("Property value = " + context.getVariable("value")));

        run(echo("We have userId = " + context.getVariable("userId")));
        run(echo("We have userId = ${userId}"));

        run(http()
                .client("restClientRequest")
                .send()
                .get("users/" + context.getVariable("userId")));

        run(http().client("restClientRequest")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type(MessageType.JSON));
    }
}
