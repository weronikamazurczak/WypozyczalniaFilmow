package BaseClasses.Test;

import BaseClasses.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import BaseClasses.Client;

import java.util.Date;

public class ClientTest {

    private Client client;

    @Before
    public void setUp() {
        client = new Client();
        client.setId(1);
        client.setName("John");
        client.setSurname("Doe");
        client.setEmail("john.doe@example.com");
        client.setPassword("securepassword");
        client.setBirthdate(new Date());
        client.setSex('M');
        client.setAccount(new Account());
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        assertTrue(client.login("john.doe@example.com", "securepassword"));
    }

    @Test
    public void testLoginWithIncorrectEmail() {
        assertFalse(client.login("wrongemail@example.com", "securepassword"));
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        assertFalse(client.login("john.doe@example.com", "wrongpassword"));
    }

    @Test
    public void testLogout() {

        client.logout();
    }
}