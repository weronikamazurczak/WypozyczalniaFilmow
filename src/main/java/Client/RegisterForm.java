package Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;


import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterForm {
    @FXML
    public TextField registerNameField;
    public TextField registerSurnameField;
    public TextField registerEmailField;
    public PasswordField registerPasswordField;
    public PasswordField registerRepeatPasswordField;
    public Button createAccountButton;
    public void onRegisterButtonClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("imie: " + registerNameField.getText()
                + "\t nazwisko: " + registerSurnameField.getText()
                + "\t email: " + registerEmailField.getText()
                + "\t haslo: " + registerPasswordField.getText()
                + "\t powtorz haslo: " + registerRepeatPasswordField.getText());

        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("LoginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Login");
        PrimaryStageSingleton.INSTANCE.show();
    }
}