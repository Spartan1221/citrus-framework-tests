package citrus.behaviors;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import org.springframework.http.HttpStatus;

import static citrus.behaviors.CreateStoreBehavior.getRequestData;
import static com.consol.citrus.dsl.JsonSupport.json;
import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class GetStoreBehavior implements TestBehavior {

    private TestContext context;
    public String orderId;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

    public GetStoreBehavior(Integer orderId, Integer petId, Integer quantity, String shipDate, String status,
                            Boolean complete, TestContext context) {
        this.context = context;
        this.orderId = String.valueOf(orderId);
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    @Override
    public void apply(TestActionRunner runner) {
        runner.run(http()
                .client("restStoreRequest")
                .send()
                .get("store/order/{orderId}".replace("{orderId}", orderId))
        );

        runner.run(http()
                .client("restStoreRequest")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(getRequestData(Integer.valueOf(orderId), petId, quantity, shipDate, status, complete)
                        , "objectMapper"))
                .validate(json().ignore("$.shipDate")));
    }
}
