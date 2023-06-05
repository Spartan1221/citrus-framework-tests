package citrus.behaviors;

import citrus.pojo.NumberToDollars;
import citrus.pojo.NumberToDollarsResponse;
import citrus.util.PojoToXML;
import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;

import java.math.BigDecimal;

import static com.consol.citrus.ws.actions.SoapActionBuilder.soap;


public class ConvertDateToTextBehavior implements TestBehavior {

    private TestContext context;

    private Integer sendData;
    private String getData;

    public ConvertDateToTextBehavior(TestContext context, Integer sendData, String getData) {
        this.context = context;
        this.sendData = sendData;
        this.getData = getData;
    }

    @Override
    public void apply(TestActionRunner runner) {
        PojoToXML<Class<NumberToDollars>> convRequest = new PojoToXML<>();
        PojoToXML<Class<NumberToDollarsResponse>> convResponse = new PojoToXML<>();

        runner.run(soap()
                .client("soapHelperClient")
                .send()
                .message()
                .body(convRequest.convert(NumberToDollars.class, getNumberToDollarsRequest(sendData), "http://www.dataaccess.com/webservicesserver/", "NumberToDollars" )).build());

        runner.run(soap()
                .client("soapHelperClient")
                .receive()
                .message()
                .validate()

                .body(convResponse.convert(NumberToDollarsResponse.class, getNumberToDollarsResponse(getData), "http://www.dataaccess.com/webservicesserver/", "NumberToDollarsResponse")));

    }

    public NumberToDollars getNumberToDollarsRequest(Integer sendData) {
        NumberToDollars numberToDollars = new NumberToDollars();
        numberToDollars.setDNum(new BigDecimal(Integer.valueOf(sendData)));
        return numberToDollars;
    }

    public NumberToDollarsResponse getNumberToDollarsResponse(String getData) {
        NumberToDollarsResponse numberToDollarsResponse = new NumberToDollarsResponse();
        numberToDollarsResponse.setNumberToDollarsResult(getData);
        return numberToDollarsResponse;
    }
}
