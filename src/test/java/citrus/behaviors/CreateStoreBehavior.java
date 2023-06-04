package citrus.behaviors;

import citrus.pojo.StoreRequest;
import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.builder.ObjectMappingPayloadBuilder;
import org.springframework.http.HttpStatus;

import static com.consol.citrus.dsl.JsonSupport.json;
import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class CreateStoreBehavior implements TestBehavior {
    private TestContext context;

    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private Boolean complete;

    public CreateStoreBehavior(Integer id, Integer petId, Integer quantity, String shipDate, String status, Boolean complete,
                               TestContext context) {
        this.context = context;
        this.id = id;
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
                .post("store/order")
                .message()
                .body(new ObjectMappingPayloadBuilder(getRequestData(id, petId, quantity, shipDate, status, complete),
                        "objectMapper"))
        );

        runner.run(http()
                .client("restStoreRequest")
                .receive()
                .response(HttpStatus.OK)
                .message()
                .type("application/json")
                .body(new ObjectMappingPayloadBuilder(getRequestData(id, petId, quantity, shipDate, status, complete)
                        , "objectMapper"))
                .validate(json().ignore("$.shipDate")));
    }

    public static StoreRequest getRequestData(Integer id, Integer petId, Integer quantity, String shipDate, String status,
                                       Boolean complete){
        return StoreRequest.builder()
                .id(id)
                .petId(petId)
                .quantity(quantity)
                .shipDate(shipDate)
                .status(status)
                .complete(complete)
                .build();
    }
}
