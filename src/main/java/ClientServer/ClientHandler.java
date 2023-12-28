package ClientServer;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            // Tworzenie strumieni do komunikacji z klientem
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
