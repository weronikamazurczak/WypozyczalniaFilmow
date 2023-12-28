package Client;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import ClientServer.ClientStart;

import java.io.IOException;


public class LoginForm extends Application {
    @FXML
    public TextField loginEmailField;
    public PasswordField loginPasswordField;
    public Button loginButton;
    public Button goToRegisterButton;
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("LoginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Login");
        PrimaryStageSingleton.INSTANCE.show();
    }
    public static Stage getPrimaryStage(){
        return primaryStage;
    }
    public static void main(String[] args) {
        launch();
    }

    public void onLoginButtonClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MovieDashboard.fxml"));
        if (loginEmailField.getText().equals("student") && loginPasswordField.getText().equals("student")) {
            ClientStart.main();
            Scene scene = new Scene(fxmlLoader.load());
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.setTitle("MovieDashboard");
            PrimaryStageSingleton.INSTANCE.show();
        } else {
            //TU TRZEBA USTAWIC JAKIES POLE CO MOWI ZE ZLE DANE
        }
    }

    public void onRegisterButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("RegisterForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Register");
        PrimaryStageSingleton.INSTANCE.show();
    }
}

