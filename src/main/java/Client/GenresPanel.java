package Client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class GenresPanel {
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

    public void onActionButtonClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Akcja");
        text.setLayoutX(30);
        text.setLayoutY(30);

            if (genresContainer != null) {
                genresContainer.getChildren().add(text);
                PrimaryStageSingleton.INSTANCE.setScene(scene);
                PrimaryStageSingleton.INSTANCE.show();
            }
    }

    public void onDramaButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Dramat");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onDocumentaryButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Dokumentalny");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onComedyButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Komedia");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onAdventureButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Przygodowy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onHorrorButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Horror");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onKidsButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Dla dzieci");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onHistoryButtonClciked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Historyczny");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onRomanceButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Romans");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onCommedyOfMannersButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Obyczajowy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onNatureButtonClciked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Przyrodniczy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onFantasyButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        Text text = new Text("Fantasy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        if (genresContainer != null) {
            genresContainer.getChildren().add(text);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }
}
