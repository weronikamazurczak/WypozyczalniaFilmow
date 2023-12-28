package ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // Numer portu, na którym serwer nasłuchuje
        int serverPort = 12345;

        try {
            // Tworzenie gniazda serwera
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Serwer nasłuchuje na porcie " + serverPort);

            // Nasłuchiwanie na połączenia klientów
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nowe połączenie od klienta: " + clientSocket.getInetAddress());

                // Tworzenie nowego wątku do obsługi klienta
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
