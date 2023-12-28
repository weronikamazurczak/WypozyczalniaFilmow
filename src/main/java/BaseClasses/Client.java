package BaseClasses;

import java.util.Date;

// Klasa reprezentująca klienta
public class Client {
    int id;
    String name;
    String surname;
    String email = "student";
    String password = "student";
    Date birthdate;
    char sex;
    Account account;

    void register() {
        // Implementacja rejestracji klienta
    }

    public boolean login(String enteredEmail, String enteredPassword) {
        if (enteredEmail.equals(email) && enteredPassword.equals(password)) {
            System.out.println("Login successful for client: " + email);
            return true;
        } else {
            System.out.println("Login failed for client: " + email);
            return false;
        }
    }

    void logout() {
        // Implementacja wylogowywania klienta
    }
}