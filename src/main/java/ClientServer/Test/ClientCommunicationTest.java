package ClientServer.Test;

import ClientServer.ClientCommunication;
import ClientServer.Request;
import ClientServer.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientCommunicationTest {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private ClientCommunication clientCommunication;

    @Before
    public void setUp() {
        clientCommunication = new ClientCommunication(SERVER_ADDRESS, SERVER_PORT);
    }

    @Test
    public void sendRequest_shouldNotThrowException() {
        Request request = new Request(/*...*/);

        clientCommunication.sendRequest(request);
    }

    @Test
    public void closeConnection_shouldNotThrowException() {
        clientCommunication.closeConnection();
    }
    @Test
    public void sendRequest_receiveResponse_shouldNotThrowException() {
        Request request = new Request(/*...*/);

        clientCommunication.sendRequest(request);
        Response response = clientCommunication.receiveResponse();
    }

    @After
    public void tearDown() {
        clientCommunication.closeConnection();
    }
}