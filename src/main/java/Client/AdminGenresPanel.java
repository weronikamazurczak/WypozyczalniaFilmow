package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class AdminGenresPanel {
    public void onHomeButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("AdminMovieDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("AdminMovieDashboard");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onMoviesButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("AdminMoviesPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("AdminMoviesPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onSerialsButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("AdminTVseriesPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("AdminTVseriesPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onGenreButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("AdminGenresPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("AdminGenresPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onSettingsButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("AdminSettings.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("AdminSettings");
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

    public void onManagementButtonMovieDashboardClicked(MouseEvent mouseEvent) {
    }

    public void onEditFlim2Button(MouseEvent mouseEvent) {
        editItem("Edytuj film", "Wprowadź nową nazwę filmu:", this::editMovieTitle, this::updateMoviePoster, this::editMovieGenre);
    }

    public void onRemoveFilm2Button(MouseEvent mouseEvent) {
        removeItem("Usuń film", "Czy na pewno chcesz usunąć ten film?", this::removeMovie);
    }


    public void onEditFlim3Button(MouseEvent mouseEvent) {
        editItem("Edytuj film", "Wprowadź nową nazwę filmu:", this::editMovieTitle, this::updateMoviePoster, this::editMovieGenre);
    }

    public void onRemoveFilm3Button(MouseEvent mouseEvent) {
        removeItem("Usuń film", "Czy na pewno chcesz usunąć ten film?", this::removeMovie);
    }

    public void onEditFlim4Button(MouseEvent mouseEvent) {
        editItem("Edytuj film", "Wprowadź nową nazwę filmu:", this::editMovieTitle, this::updateMoviePoster, this::editMovieGenre);
    }

    public void onRemoveFilm4Button(MouseEvent mouseEvent) {
        removeItem("Usuń film", "Czy na pewno chcesz usunąć ten film?", this::removeMovie);
    }

    // Metody do implementacji
    private void editMovieTitle(String newTitle) {
        // Tutaj powinieneś dodać logikę do edycji nazwy filmu
        System.out.println("Zmieniono nazwę filmu na: " + newTitle);
    }

    // Metoda do implementacji
    private void updateMoviePoster(File file) {
        // Tutaj powinieneś dodać logikę do aktualizacji plakatu filmu
        System.out.println("Zaktualizowano plakat filmu: " + file.getAbsolutePath());
    }

    private void editMovieGenre(String newGenre) {
        // Tutaj powinieneś dodać logikę do edycji gatunku filmu
        System.out.println("Zmieniono gatunek filmu na: " + newGenre);
    }

    private void removeMovie() {
        // Tutaj powinieneś dodać logikę do usunięcia filmu
        System.out.println("Usunięto film.");
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    // Ogólna metoda do usuwania elementów
    private void removeItem(String title, String message, Runnable removeAction) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // Usuń element
            removeAction.run();
        }
    }

    // Ogólna metoda do edycji elementów
    private void editItem(String title, String message, Consumer<String> editAction, Consumer<File> updatePosterAction, Consumer<String> editGenreAction) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String newValue = result.get();
            if(!newValue.isEmpty()) {
                // Edytuj wartość
                editAction.accept(newValue);

                // Wybierz nowy plakat
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Wybierz nowy plakat");
                File file = fileChooser.showOpenDialog(null);
                if (file != null) {
                    // Zaktualizuj plakat
                    updatePosterAction.accept(file);
                }

                // Wybierz nowy gatunek
                List<String> genres = Arrays.asList("Komedia", "Dramat", "Akcja", "Horror");
                ChoiceDialog<String> genreDialog = new ChoiceDialog<>("Komedia", genres);
                genreDialog.setTitle(title);
                genreDialog.setHeaderText("Wybierz nowy gatunek:");
                genreDialog.setContentText("Gatunki:");

                String newGenre = genreDialog.showAndWait().orElse("");
                if(!newGenre.isEmpty()) {
                    // Edytuj gatunek
                    editGenreAction.accept(newGenre);
                }

                // Potwierdź zmiany
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText("Zmiany zostały zapisane.");

                alert.showAndWait();
            } else {
                showErrorDialog("Nie wprowadzono wartości.");
                editItem(title, message, editAction, updatePosterAction, editGenreAction);  // Ponownie otwórz okno dialogowe
            }
        }
    }

    public void actionButton(ActionEvent actionEvent) {
    }

    public void onActionButtonClicked(MouseEvent mouseEvent) {
    }

    public void onDramaButtonClicked(MouseEvent mouseEvent) {
    }

    public void onDocumentaryButtonClicked(MouseEvent mouseEvent) {
    }

    public void onComedyButtonClicked(MouseEvent mouseEvent) {
    }

    public void adventureButton(ActionEvent actionEvent) {
    }

    public void onAdventureButtonClicked(MouseEvent mouseEvent) {
    }

    public void onHorrorButtonClicked(MouseEvent mouseEvent) {
    }

    public void onKidsButtonClicked(MouseEvent mouseEvent) {
    }

    public void historyButton(ActionEvent actionEvent) {
    }

    public void onHistoryButtonClciked(MouseEvent mouseEvent) {
    }

    public void onRomanceButtonClicked(MouseEvent mouseEvent) {
    }

    public void onCommedyOfMannersButtonClicked(MouseEvent mouseEvent) {
    }

    public void onNatureButtonClciked(MouseEvent mouseEvent) {
    }

    public void onFantasyButtonClicked(MouseEvent mouseEvent) {
    }
}
