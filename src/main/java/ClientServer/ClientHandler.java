package ClientServer;

import ClientServer.QueryHandler.QueryHandler;

import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
//pole połączenia z bazą danych
    Connection dataBaseConnection = null;
    QueryHandler queryHandler = null;
    public Connection getDataBaseConnection() {
        return dataBaseConnection;
    }

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            // Tworzenie strumieni do komunikacji z klientem
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            String dbURL2 = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "test";
            String password = "test";
            dataBaseConnection = DriverManager.getConnection(dbURL2, username, password);
            if (dataBaseConnection != null) {
                System.out.println("Connected with connection #");
                queryHandler = new QueryHandler(dataBaseConnection);
                queryHandler.getMovieQuery().getAllMoviesByAccountId(1);
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            // Odbieranie żądania od klienta
            Request request = (Request) inputStream.readObject();

            // Przetwarzanie żądania (tutaj dodaj logikę obsługi żądań)

            // Przygotowanie odpowiedzi
            Response response = new Response();
            // Ustawienie danych odpowiedzi

            // Wysyłanie odpowiedzi do klienta
            outputStream.writeObject(response);
            outputStream.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Zamknięcie strumieni i gniazda
            try {
                inputStream.close();
                outputStream.close();
                clientSocket.close();
                if(!dataBaseConnection.isClosed() && dataBaseConnection != null) {
                    dataBaseConnection.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
