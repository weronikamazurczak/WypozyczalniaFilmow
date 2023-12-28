package ClientServer;

import java.io.*;
import java.net.Socket;

public class ClientCommunication {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public ClientCommunication(String serverAddress, int serverPort) {
        try {
            // Nawiązanie połączenia z serwerem
            socket = new Socket(serverAddress, serverPort);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(Request request) {
        try {
            // Wysyłanie obiektu Request do serwera
            outputStream.writeObject(request);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Response receiveResponse() {
        try {
            // Odbieranie obiektu Response od serwera
            return (Response) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection() {
        try {
            // Zamknięcie strumieni i gniazda
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
