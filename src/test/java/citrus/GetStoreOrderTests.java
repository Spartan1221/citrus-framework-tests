package citrus;

import citrus.behaviors.CreateStoreBehavior;
import citrus.behaviors.GetStoreBehavior;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.junit.JUnit4CitrusSupport;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

public class GetStoreOrderTests  extends JUnit4CitrusSupport {

    private static final Integer ID = 10;

    private TestContext context;

    @Test
    @CitrusTest
    @DisplayName("Если вызвать запрос с id существующим в бд, то в ответе вернется статус 200 и корректное тело ")
    public void getTestActions() {
        this.context = citrus.getCitrusContext().createTestContext();
        String shipDate = LocalDateTime.now().plusDays(10).toString();

        run(applyBehavior(new CreateStoreBehavior(ID, 1, 1, shipDate, "Reserved", true, context)));
        run(applyBehavior(new GetStoreBehavior(ID, 1, 1, shipDate, "Reserved", true, context)));
    }

}
