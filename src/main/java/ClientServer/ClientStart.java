package ClientServer;

import BaseClasses.Account;

public class ClientStart {
    public static void main() {
        // Adres i port serwera
        String serverAddress = "127.0.0.1"; // Możesz zastąpić adresem serwera
        int serverPort = 12345; // Możesz zastąpić numerem portu

        // Tworzenie obiektu ClientCommunication i nawiązywanie połączenia
        ClientCommunication clientCommunication = new ClientCommunication(serverAddress, serverPort);

        // Przykładowe żądanie
        Request request = new Request();
        // Ustawienie danych żądania

        // Wysyłanie żądania do serwera
        clientCommunication.sendRequest(request);

        // Odbieranie odpowiedzi od serwera
        Response response = clientCommunication.receiveResponse();
        // Przetwarzanie odpowiedzi

        // Zamykanie połączenia
        clientCommunication.closeConnection();
    }
}
