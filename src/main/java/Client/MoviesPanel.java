package Client;

import BaseClasses.Account;
import BaseClasses.Movie;
import ClientServer.ClientStart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesPanel {
    List<Movie> moviesList = generateSampleData();
    Account acc = ClientStart.getAcc();
    private Pane createObjectPane(Movie movie) {
        Pane pane = new Pane();
        pane.setPrefSize(271, 160);

        Label ratingLabel = new Label(String.valueOf(11));
        ratingLabel.setLayoutX(197);
        ratingLabel.setLayoutY(116);
        ratingLabel.setFont(new Font("System Bold", 20));

//            ImageView starImageView = new ImageView(new Image("@..resources/img/star.png"));
//            starImageView.setFitHeight(36);
//            starImageView.setFitWidth(25);
//
//            ratingLabel.setGraphic(starImageView);

        Button movieButton = new Button();
//        movieButton.setStyle("-fx-background-color: #fff;");
//            ImageView movieImageView = new ImageView(new Image("../img/topView2.jpg"));
//            movieImageView.setFitHeight(150);
//            movieImageView.setFitWidth(200);
//
//            movieButton.setGraphic(movieImageView);
        //movieButton.setOnMouseClicked(event -> onMidViewMovieImgButtonClicked());

        Label titleLabel = new Label(movie.getTitle());
        titleLabel.setLayoutX(123);
        titleLabel.setLayoutY(26);
        titleLabel.setFont(new Font("System Bold", 14));

        Label genreLabel = new Label("gatunek: " + movie.getGenre());
        genreLabel.setLayoutX(123);
        genreLabel.setLayoutY(62);

        // Dodaj pozostałe kontrolki według potrzeb

        pane.getChildren().addAll(ratingLabel, movieButton, titleLabel, genreLabel);

        return pane;
    }
    private List<Movie> generateSampleData() {
        List<String> actors1 = new ArrayList<>();
        actors1.add("Cillian Murphy");
        actors1.add("Emily Blunt");
        actors1.add("Matt Damon");
        actors1.add("Robert Downey JR");

        List<Movie> data = new ArrayList<>();
        data.add(new Movie(1, "Oppenheimer", "dramat", "Christopher Nolan", actors1, 2023, "Historia amerykańskiego naukowca J. Roberta Oppenheimera i jego roli w stworzeniu bomby atomowej. "));
        data.add(new Movie(2, "Oppenheimer", "dramat", "Christopher Nolan", actors1, 2023, "Historia amerykańskiego naukowca J. Roberta Oppenheimera i jego roli w stworzeniu bomby atomowej. "));
        data.add(new Movie(3, "Oppenheimer", "dramat", "Christopher Nolan", actors1, 2023, "Historia amerykańskiego naukowca J. Roberta Oppenheimera i jego roli w stworzeniu bomby atomowej. "));
        data.add(new Movie(4, "Oppenheimer", "dramat", "Christopher Nolan", actors1, 2023, "Historia amerykańskiego naukowca J. Roberta Oppenheimera i jego roli w stworzeniu bomby atomowej. "));
        data.add(new Movie(5, "Oppenheimer", "dramat", "Christopher Nolan", actors1, 2023, "Historia amerykańskiego naukowca J. Roberta Oppenheimera i jego roli w stworzeniu bomby atomowej. "));
        return data;
    }
    public void onHomeButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MovieDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("MovieDashboard");
        PrimaryStageSingleton.INSTANCE.show();
    }

    public void onMoviesButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MoviesPanel.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        PrimaryStageSingleton.INSTANCE.setScene(scene);
//        PrimaryStageSingleton.INSTANCE.setTitle("MoviesPanel");
//        PrimaryStageSingleton.INSTANCE.show();
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MoviesPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        System.out.println("test");

        ScrollPane moviesContainer = (ScrollPane) root.lookup("#ScrollPaneM");
        VBox newContentVBox = new VBox();

        // Iteracja przez listę i generowanie Pane dla każdego obiektu
        double yOffset = 0;
        for (Movie m : moviesList) {
            Pane objectPane = createObjectPane(m);
            objectPane.setLayoutY(yOffset);
            yOffset += 30; // Odstęp między kolejnymi Panes

            // Wyszukaj kontener w korzeniu pliku FXML o id "MoviesContainerPane"

            if (moviesContainer != null) {
                newContentVBox.getChildren().add(objectPane);
                System.out.println("ScrollPaneM found");
            } else {
                System.out.println("ScrollPaneM not found in FXML");
            }

//            Pane moviesContainer = (Pane) root.lookup("#MoviesContainerPane");
//            if (moviesContainer != null) {
//                moviesContainer.getChildren().add(objectPane);
//            } else {
//                System.out.println("MoviesContainerPane not found in FXML");
//                System.out.println("Root children count: " + root.getChildren().size());
//                for (Node node : root.getChildren()) {
//                    System.out.println("Child id: " + node.getId());
//                }
//            }
        }


        moviesContainer.setContent(newContentVBox);

//        // Tworzenie kontenera, który będzie dodany do ScrollPane
//        VBox contentVBox = new VBox();
//        // Dodanie dziecka do contentVBox
//        contentVBox.getChildren().add(yourChildNode);
//
//        // Tworzenie ScrollPane i ustawienie go jako kontentu
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(contentVBox);
//
//
//
//
//        if (currentContent instanceof VBox) {
//            // Dodawanie nowego dziecka do VBox
//            ((VBox) currentContent).getChildren().add(yourChildNode);
//        } else {
//            // Jeśli aktualny kontent nie jest VBox, możesz stworzyć nowy VBox i ustawić go jako kontent
//            VBox newContentVBox = new VBox();
//            newContentVBox.getChildren().add(yourChildNode);
//            scrollPane.setContent(newContentVBox);
//        }




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

    public void onAddToFavoritesButtonClicked(MouseEvent mouseEvent) {
        acc.addToFavorites("Film 1");
    }

    public void onRentMovieButtonClicked(MouseEvent mouseEvent) {
        acc.rentMovie("Film 1");
    }

}
