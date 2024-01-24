package Client;

import BaseClasses.Movie;
import ClientServer.ClientStart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javafx.scene.control.Alert.AlertType;
import java.util.Optional;

import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

import java.io.IOException;

public class Settings {
    public void onHomeButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MovieDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("MovieDashboard");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onMoviesButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MoviesPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("MoviesPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onSerialsButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("TVseriesPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("TVseriesPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onGenreButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("GenresPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onSettingsButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("Settings.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Settings");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onLogoutButtonMovieDashboardClicked(MouseEvent mouseEvent)  throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("LoginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Login");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onTopViewMovieImgButtonClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("DescriptionTopViewFilm1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("DescriptionTopViewFilm");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onMidViewMovieImgButtonClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("DescriptionTopViewFilm2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("DescriptionTopViewFilm");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onDownViewMovieImgButtonClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("DescriptionTopViewFilm3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("DescriptionTopViewFilm");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onBuySubscriptionButtonClicked(MouseEvent mouseEvent) {
        // Wybierz formę płatności
        List<String> paymentOptions = Arrays.asList("Karta kredytowa", "PayPal", "Przelew bankowy");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Karta kredytowa", paymentOptions);
        dialog.setTitle("Zakup subskrypcji");
        dialog.setHeaderText("Wybierz formę płatności:");
        dialog.setContentText("Opcje płatności:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            // Potwierdź zakup
            Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
            confirmAlert.setTitle("Potwierdzenie zakupu");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("Czy na pewno chcesz kupić subskrypcję?");

            Optional<ButtonType> confirmResult = confirmAlert.showAndWait();
            if (confirmResult.get() == ButtonType.OK) {
                // Dziękujemy za zakup subskrypcji
                Alert thankYouAlert = new Alert(AlertType.INFORMATION);
                thankYouAlert.setTitle("Zakup subskrypcji");
                thankYouAlert.setHeaderText(null);
                thankYouAlert.setContentText("Dziękujemy za zakup subskrypcji!");

                thankYouAlert.showAndWait();
            }
        }
    }

    public void onAddNewAccountClicked(MouseEvent mouseEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Dodaj nowego użytkownika");
        dialog.setHeaderText(null);
        dialog.setContentText("Wprowadź nazwę użytkownika:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String username = result.get();
            if(!username.isEmpty()) {
                // Dodaj nowego użytkownika do konta
                addUser(username);
            } else {
                showErrorDialog("Nie wprowadzono nazwy użytkownika.");
                onAddNewAccountClicked(mouseEvent);  // Ponownie otwórz okno dialogowe
            }
        }
    }

    public void onRemoveAccountButton1Clicked(MouseEvent mouseEvent) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Usuń użytkownika");
        alert.setHeaderText(null);
        alert.setContentText("Czy na pewno chcesz usunąć to konto?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // Usuń konto użytkownika
            removeUser();
        }
    }

    public void onRemoveAccountButton2Clicked(MouseEvent mouseEvent) {
        // Ta metoda może być użyta do usunięcia konta użytkownika dla dzieci
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Usuń konto dla dzieci");
        alert.setHeaderText(null);
        alert.setContentText("Czy na pewno chcesz usunąć to konto dla dzieci?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // Usuń konto dla dzieci
            removeChildAccount();
        }
    }

    // Metody do implementacji
    private void addUser(String username) {
        // Tutaj powinieneś dodać logikę do dodania nowego użytkownika do konta
        System.out.println("Dodano nowego użytkownika: " + username);
    }

    private void removeUser() {
        // Tutaj powinieneś dodać logikę do usunięcia konta użytkownika
        System.out.println("Usunięto konto użytkownika.");
    }

    private void removeChildAccount() {
        // Tutaj powinieneś dodać logikę do usunięcia konta dla dzieci
        System.out.println("Usunięto konto dla dzieci.");
    }

    public void onViewFavouritesClicked(MouseEvent mouseEvent) {
        // Pobierz listę ulubionych filmów użytkownika


        StringBuilder contentTextBuilder = new StringBuilder();

        for (Movie m : ClientStart.getAcc().favouriteMovies) {
            contentTextBuilder.append(m.title).append("\n");
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ulubione filmy");
        alert.setHeaderText(null);

        if (ClientStart.getAcc().favouriteMovies.isEmpty()) {
            alert.setContentText("Brak ulubionych filmów");
        } else {
            alert.setContentText(contentTextBuilder.toString());
        }

        alert.showAndWait();

    }

    // Metody do implementacji
    private List<String> getFavouriteMovies() {
        // Tutaj powinieneś pobrać listę ulubionych filmów użytkownika z bazy danych lub innego źródła danych
        return Arrays.asList("Film 1", "Film 2", "Film 3");
    }

    public void onChangeEmailButtonClicked(MouseEvent mouseEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Zmiana adresu e-mail");
        dialog.setHeaderText(null);
        dialog.setContentText("Wprowadź nowy adres e-mail:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String newEmail = result.get();
            if(isValidEmail(newEmail)) {
                // Zaktualizuj e-mail w swoim magazynie danych lub bazie danych
                System.out.println("Adres e-mail został zmieniony na: " + newEmail);
            } else {
                showErrorDialog("Nieprawidłowy adres e-mail.");
                onChangeEmailButtonClicked(mouseEvent);  // Ponownie otwórz okno dialogowe
            }
        }
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    public void onPasswordChangeButtonClicked(MouseEvent mouseEvent) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Zmiana hasła");
        dialog.setHeaderText("Wprowadź nowe hasło");
        dialog.setContentText("Hasło musi mieć co najmniej 8 znaków, \nzawierać co najmniej jedną dużą literę, \njedną małą literę i jedną cyfrę.\n");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String newPassword = result.get();
            if(isValidPassword(newPassword)) {
                // Zaktualizuj hasło w swoim magazynie danych lub bazie danych
                System.out.println("Hasło zostało zmienione.");
            } else {
                showErrorDialog("Nieprawidłowe hasło.");
                onPasswordChangeButtonClicked(mouseEvent);  // Ponownie otwórz okno dialogowe
            }
        }
    }
    private boolean isValidPassword(String password) {
        // Przykładowa walidacja hasła: co najmniej 8 znaków, zawiera co najmniej jedną dużą literę, jedną małą literę i jedną cyfrę
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pat = Pattern.compile(passwordRegex);
        return password != null && pat.matcher(password).matches();
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    public void onHistorySectionButtonClicked(MouseEvent mouseEvent) {
        // Pobierz listę wypożyczonych filmów użytkownika

        StringBuilder contentTextBuilder = new StringBuilder();

        for (Movie m : ClientStart.getAcc().rentMovies) {
            contentTextBuilder.append(m.title).append("\n\n");
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Wypozyczone filmy");
        alert.setHeaderText(null);

        if (ClientStart.getAcc().rentMovies.isEmpty()) {
            alert.setContentText("Brak wypozyczonych filmów");
        } else {
            alert.setContentText(contentTextBuilder.toString());
        }
        alert.showAndWait();
    }


    private List<String> getRentedMovies() {
        // Tutaj powinieneś pobrać listę wypożyczonych filmów użytkownika z bazy danych lub innego źródła danych
        return Arrays.asList("Film 4", "Film 5", "Film 6");
    }

    public void onGradeWatchedMoviesButtonClicked(MouseEvent mouseEvent) {
        // Pobierz listę wypożyczonych filmów użytkownika
        List<String> rentedMovies = getRentedMovies();

        // Wybierz film do oceny
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Oceń film");
        dialog.setHeaderText("Wybierz film do oceny z poniższej listy:\n" + String.join(", ", rentedMovies));
        dialog.setContentText("Wprowadź tytuł filmu:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String movieTitle = result.get();
            if(movieTitle.isEmpty()) {
                showErrorDialog("Nie wprowadzono tytułu filmu.");
                onGradeWatchedMoviesButtonClicked(mouseEvent);  // Ponownie otwórz okno dialogowe
            } else if(rentedMovies.contains(movieTitle)) {
                // Wprowadź komentarz
                Dialog<String> commentDialog = new Dialog<>();
                commentDialog.setTitle("Dodaj komentarz");

                GridPane grid = new GridPane();
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(20, 150, 10, 10));

                TextArea commentArea = new TextArea();
                commentArea.setPromptText("Wprowadź swój komentarz tutaj.");

                grid.add(new Label("Komentarz:"), 0, 0);
                grid.add(commentArea, 1, 0);

                commentDialog.getDialogPane().setContent(grid);

                // Dodaj przyciski "Zapisz" i "Anuluj"
                ButtonType saveButtonType = new ButtonType("Zapisz", ButtonBar.ButtonData.OK_DONE);
                commentDialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

                commentDialog.setResultConverter(dialogButton -> {
                    if (dialogButton == saveButtonType) {
                        return commentArea.getText();
                    }
                    return null;
                });

                Optional<String> commentResult = commentDialog.showAndWait();

                // Zapisz komentarz dla wybranego filmu
                if (commentResult.isPresent()) {
                    saveComment(movieTitle, commentResult.get());
                }
            } else {
                showErrorDialog("Wybrany film nie jest na liście wypożyczonych filmów.");
                onGradeWatchedMoviesButtonClicked(mouseEvent);  // Ponownie otwórz okno dialogowe
            }
        }
    }

    private void saveComment(String movieTitle, String comment) {
        // Tutaj powinieneś zapisać komentarz użytkownika dla wybranego filmu w bazie danych lub innym źródle danych
        System.out.println("Komentarz do filmu \"" + movieTitle + "\": " + comment);
    }
}
