package citrus.behaviors;

import citrus.pojo.StoreRequest;
import com.consol.citrus.TestAction;
import com.consol.citrus.TestCase;
import com.consol.citrus.TestCaseMetaInfo;
import com.consol.citrus.actions.*;
import com.consol.citrus.container.AbstractActionContainer;
import com.consol.citrus.container.Template;
import com.consol.citrus.container.Wait;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.dsl.builder.*;
import com.consol.citrus.dsl.runner.ApplyTestBehaviorAction;
import com.consol.citrus.dsl.runner.TestBehavior;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.script.GroovyAction;
import com.consol.citrus.server.Server;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;

import java.util.Date;

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
    public void apply(TestRunner runner) {
        http(httpActionBuilder -> httpActionBuilder
                .client("restStoreRequest")
                .send()
                .post("store/order")
                .payload(getRequestData(id, petId, quantity, shipDate, status, complete),
                        "objectMapper"));

        http(httpActionBuilder -> httpActionBuilder
                .client("restStoreRequest")
                .receive()
                .response(HttpStatus.OK)
                .contentType("application/json")
                .payload(getRequestData(id, petId, quantity, shipDate, status, complete),
                        "objectMapper"));

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

    @Override
    public TestCase getTestCase() {
        return null;
    }

    @Override
    public void testClass(Class<?> type) {

    }

    @Override
    public void name(String name) {

    }

    @Override
    public void description(String description) {

    }

    @Override
    public void author(String author) {

    }

    @Override
    public void packageName(String packageName) {

    }

    @Override
    public void status(TestCaseMetaInfo.Status status) {

    }

    @Override
    public void creationDate(Date date) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public <T> T variable(String name, T value) {
        return null;
    }

    @Override
    public <T extends TestAction> T run(T testAction) {
        return null;
    }

    @Override
    public ApplyTestBehaviorAction applyBehavior(TestBehavior behavior) {
        return null;
    }

    @Override
    public <T extends AbstractActionContainer> AbstractTestContainerBuilder<T> container(T container) {
        return null;
    }

    @Override
    public CreateVariablesAction createVariable(String variableName, String value) {
        return null;
    }

    @Override
    public AntRunAction antrun(BuilderSupport<AntRunBuilder> configurer) {
        return null;
    }

    @Override
    public EchoAction echo(String message) {
        return null;
    }

    @Override
    public ExecutePLSQLAction plsql(BuilderSupport<ExecutePLSQLBuilder> configurer) {
        return null;
    }

    @Override
    public ExecuteSQLAction sql(BuilderSupport<ExecuteSQLBuilder> configurer) {
        return null;
    }

    @Override
    public ExecuteSQLQueryAction query(BuilderSupport<ExecuteSQLQueryBuilder> configurer) {
        return null;
    }

    @Override
    public ReceiveTimeoutAction receiveTimeout(BuilderSupport<ReceiveTimeoutBuilder> configurer) {
        return null;
    }

    @Override
    public FailAction fail(String message) {
        return null;
    }

    @Override
    public InputAction input(BuilderSupport<InputActionBuilder> configurer) {
        return null;
    }

    @Override
    public LoadPropertiesAction load(String filePath) {
        return null;
    }

    @Override
    public TestAction purgeQueues(BuilderSupport<PurgeJmsQueuesBuilder> configurer) {
        return null;
    }

    @Override
    public PurgeMessageChannelAction purgeChannels(BuilderSupport<PurgeChannelsBuilder> configurer) {
        return null;
    }

    @Override
    public PurgeEndpointAction purgeEndpoints(BuilderSupport<PurgeEndpointsBuilder> configurer) {
        return null;
    }

    @Override
    public ReceiveMessageAction receive(BuilderSupport<ReceiveMessageBuilder> configurer) {
        return null;
    }

    @Override
    public SendMessageAction send(BuilderSupport<SendMessageBuilder> configurer) {
        return null;
    }

    @Override
    public SleepAction sleep() {
        return null;
    }

    @Override
    public SleepAction sleep(long milliseconds) {
        return null;
    }

    @Override
    public Wait waitFor(BuilderSupport<WaitBuilder> configurer) {
        return null;
    }

    @Override
    public WaitBuilder waitFor() {
        return null;
    }

    @Override
    public StartServerAction start(Server... servers) {
        return null;
    }

    @Override
    public StartServerAction start(Server server) {
        return null;
    }

    @Override
    public StopServerAction stop(Server... servers) {
        return null;
    }

    @Override
    public StopServerAction stop(Server server) {
        return null;
    }

    @Override
    public StopTimeAction stopTime() {
        return null;
    }

    @Override
    public StopTimeAction stopTime(String id) {
        return null;
    }

    @Override
    public StopTimeAction stopTime(String id, String suffix) {
        return null;
    }

    @Override
    public TraceVariablesAction traceVariables() {
        return null;
    }

    @Override
    public TraceVariablesAction traceVariables(String... variables) {
        return null;
    }

    @Override
    public GroovyAction groovy(BuilderSupport<GroovyActionBuilder> configurer) {
        return null;
    }

    @Override
    public TransformAction transform(BuilderSupport<TransformActionBuilder> configurer) {
        return null;
    }

    @Override
    public AssertExceptionBuilder assertException() {
        return null;
    }

    @Override
    public CatchExceptionBuilder catchException() {
        return null;
    }

    @Override
    public AssertSoapFaultBuilder assertSoapFault() {
        return null;
    }

    @Override
    public ConditionalBuilder conditional() {
        return null;
    }

    @Override
    public IterateBuilder iterate() {
        return null;
    }

    @Override
    public ParallelBuilder parallel() {
        return null;
    }

    @Override
    public RepeatOnErrorBuilder repeatOnError() {
        return null;
    }

    @Override
    public RepeatBuilder repeat() {
        return null;
    }

    @Override
    public SequenceBuilder sequential() {
        return null;
    }

    @Override
    public AsyncBuilder async() {
        return null;
    }

    @Override
    public TimerBuilder timer() {
        return null;
    }

    @Override
    public StopTimerAction stopTimer(String timerId) {
        return null;
    }

    @Override
    public StopTimerAction stopTimers() {
        return null;
    }

    @Override
    public TestAction docker(BuilderSupport<DockerActionBuilder> configurer) {
        return null;
    }

    @Override
    public TestAction kubernetes(BuilderSupport<KubernetesActionBuilder> configurer) {
        return null;
    }

    @Override
    public TestAction selenium(BuilderSupport<SeleniumActionBuilder> configurer) {
        return null;
    }

    @Override
    public TestAction http(BuilderSupport<HttpActionBuilder> configurer) {
        return null;
    }

    @Override
    public TestAction soap(BuilderSupport<SoapActionBuilder> configurer) {
        return null;
    }

    @Override
    public TestAction camel(BuilderSupport<CamelRouteActionBuilder> configurer) {
        return null;
    }

    @Override
    public TestAction zookeeper(BuilderSupport<ZooActionBuilder> configurer) {
        return null;
    }

    @Override
    public Template applyTemplate(BuilderSupport<TemplateBuilder> configurer) {
        return null;
    }

    @Override
    public FinallySequenceBuilder doFinally() {
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
