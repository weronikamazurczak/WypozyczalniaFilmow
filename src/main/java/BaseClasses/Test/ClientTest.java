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
        client.setName("Jan");
        client.setSurname("Kowalski");
        client.setEmail("jan.k@mail.com");
        client.setPassword("haslohaslo");
        client.setBirthdate(new Date());
        client.setSex('M');
        client.setAccount(new Account());
    }

    @Test
    public void testLoginWithCorrectCredentials() {
        assertTrue(client.login("jan.k@mail.com", "haslohaslo"));
    }

    @Test
    public void testLoginWithIncorrectEmail() {
        assertFalse(client.login("k.jan@mail.com", "haslohaslo"));
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        assertFalse(client.login("jan.k@mail.com", "haslohaslo"));
    }

    @Test
    public void testLogout() {

        client.logout();
    }
}