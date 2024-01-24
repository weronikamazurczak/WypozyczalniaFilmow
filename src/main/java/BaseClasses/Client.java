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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

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

    public void logout() {
        // Implementacja wylogowywania klienta
    }
}