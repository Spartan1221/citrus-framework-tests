package citrus.test;

import citrus.behaviors.ConvertDateToTextBehavior;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.junit.JUnit4CitrusTestRunner;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class DateConvertTests  extends JUnit4CitrusTestRunner {

    private TestContext context;

    @Test
    @CitrusTest
    @DisplayName("Если вызвать запрос с id существующим в бд, то в ответе вернется статус 200 и корректное тело ")
    public void getTestActions() {
        this.context = citrus.createTestContext();

        run(applyBehavior(new ConvertDateToTextBehavior(context, 15, "fifteen dollars")));
    }
}
