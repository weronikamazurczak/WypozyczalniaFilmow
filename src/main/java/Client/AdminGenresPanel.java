package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

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


    public void onAddGenres(MouseEvent mouseEvent) {
        addGenre("Dodaj gatunek", "Wprowadź nowy gatunek:", this::addNewGenre);
    }

    private void addNewGenre(String newGenre) {
        // Tutaj powinieneś dodać logikę do dodania nowego gatunku
        System.out.println("Dodano nowy gatunek: " + newGenre);
    }

    private void addGenre(String title, String message, Consumer<String> editAction){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String newValue = result.get();
            if (!newValue.isEmpty()) {
                // Edytuj wartość
                editAction.accept(newValue);
            } else {
                showErrorDialog("Nie wprowadzono wartości.");
                addGenre(title, message, editAction);
            }
        }
    }

    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    public void onRemoveGenres(MouseEvent mouseEvent) {
        removeItem("Usuń gatunek", "Czy na pewno chcesz usunąć ten gatunek?", this::chooseGenre, this::removeGenre);
    }

    private void chooseGenre(String newGenre) {
        // Tutaj powinieneś dodać logikę do edycji gatunku filmu
        System.out.println("Wybrano gatunek: " + newGenre);
    }

    private void removeGenre() {
        // Tutaj powinieneś dodać logikę do usunięcia filmu
        System.out.println("Powodzenie usunięcia gatunku.");
    }

    private void removeItem(String title, String message, Consumer<String> chooseGenreAction, Runnable removeAction) {
        // Wybierz nowy gatunek
        List<String> genres = Arrays.asList("Akcja","Przygodowy", "Romans", "Dramat", "Horror", "Obyczajowy", "Dokumentalny", "Dla dzieci", "Przyrodniczy", "Komedia", "Historyczny","Fantasy");
        ChoiceDialog<String> genreDialog = new ChoiceDialog<>("Akcja", genres);
        genreDialog.setTitle(title);
        genreDialog.setHeaderText("Wybierz gatunek do usunięcia:");
        genreDialog.setContentText("Gatunki:");

        String Genre = genreDialog.showAndWait().orElse("");
        if(!Genre.isEmpty()) {
            // Usuń gatunek
            chooseGenreAction.accept(Genre);
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
    }
    public void onManagementButtonMovieDashboardClicked(MouseEvent mouseEvent) {
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
