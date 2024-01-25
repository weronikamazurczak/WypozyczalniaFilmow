package Client;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
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
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Akcja");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/film6.png").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("NA SKRAJU JUTRA");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2014");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);

        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onDramaButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Dramat");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/film4.png").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("BARBIE");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2023");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);


        // Dodaj dodatkowy Pane
        Pane additionalPane2 = new Pane();
        additionalPane2.setLayoutX(200.0);
        additionalPane2.setLayoutY(50.0);
        additionalPane2.setPrefHeight(200.0);
        additionalPane2.setPrefWidth(127.0);
        additionalPane2.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button2 = new Button();
        button2.setId("popularFilm1");
        button2.setLayoutX(3.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(150.0);
        button2.setPrefWidth(90.0);
        button2.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView2 = new ImageView();
        imageView2.setId("topViewButton1");
        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setLayoutX(5.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        Image image2 = new Image(getClass().getResource("/img/topView3.jpg").toExternalForm());
        imageView2.setImage(image2);

        // Dodaj Label
        Label label12 = new Label();
        label12.setLayoutX(10.0);
        label12.setLayoutY(158.0);
        label12.setPrefHeight(17.0);
        label12.setPrefWidth(107.0);
        label12.setText("ZIELONA MILA");
        Font font12 = new Font("Constantia Bold", 12.0);
        label12.setFont(font12);

        // Dodaj kolejny Label
        Label label22 = new Label();
        label22.setLayoutX(10.0);
        label22.setLayoutY(178.0);
        label22.setPrefHeight(17.0);
        label22.setPrefWidth(107.0);
        label22.setText("1999");
        Font font22 = new Font("Constantia Bold", 12.0);
        label22.setFont(font22);

        // Dodaj elementy do dodatkowego Pane
        additionalPane2.getChildren().addAll(button2, imageView2, label12, label22);




        // Dodaj dodatkowy Pane
        Pane additionalPane3 = new Pane();
        additionalPane3.setLayoutX(350.0);
        additionalPane3.setLayoutY(50.0);
        additionalPane3.setPrefHeight(200.0);
        additionalPane3.setPrefWidth(127.0);
        additionalPane3.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button3 = new Button();
        button3.setId("popularFilm1");
        button3.setLayoutX(3.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(150.0);
        button3.setPrefWidth(90.0);
        button3.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView3 = new ImageView();
        imageView3.setId("topViewButton1");
        imageView3.setFitHeight(150.0);
        imageView3.setFitWidth(200.0);
        imageView3.setLayoutX(15.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        Image image3 = new Image(getClass().getResource("/img/topView1.jpg").toExternalForm());
        imageView3.setImage(image3);

        // Dodaj Label
        Label label13 = new Label();
        label13.setLayoutX(10.0);
        label13.setLayoutY(158.0);
        label13.setPrefHeight(17.0);
        label13.setPrefWidth(107.0);
        label13.setText("SKAZANI NA SHAWSHANK");
        Font font13 = new Font("Constantia Bold", 12.0);
        label13.setFont(font13);

        // Dodaj kolejny Label
        Label label23 = new Label();
        label23.setLayoutX(10.0);
        label23.setLayoutY(178.0);
        label23.setPrefHeight(17.0);
        label23.setPrefWidth(107.0);
        label23.setText("1994");
        Font font23 = new Font("Constantia Bold", 12.0);
        label23.setFont(font23);

        // Dodaj elementy do dodatkowego Pane
        additionalPane3.getChildren().addAll(button3, imageView3, label13, label23);





        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane, additionalPane2, additionalPane3);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onDocumentaryButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();
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
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Komedia");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/film4.png").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("BARBIE");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2023");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);


        // Dodaj dodatkowy Pane
        Pane additionalPane2 = new Pane();
        additionalPane2.setLayoutX(200.0);
        additionalPane2.setLayoutY(50.0);
        additionalPane2.setPrefHeight(200.0);
        additionalPane2.setPrefWidth(127.0);
        additionalPane2.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button2 = new Button();
        button2.setId("popularFilm1");
        button2.setLayoutX(3.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(150.0);
        button2.setPrefWidth(90.0);
        button2.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView2 = new ImageView();
        imageView2.setId("topViewButton1");
        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setLayoutX(10.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        Image image2 = new Image(getClass().getResource("/img/7322795.6.jpg").toExternalForm());
        imageView2.setImage(image2);

        // Dodaj Label
        Label label12 = new Label();
        label12.setLayoutX(10.0);
        label12.setLayoutY(158.0);
        label12.setPrefHeight(17.0);
        label12.setPrefWidth(107.0);
        label12.setText("TOY STORY");
        Font font12 = new Font("Constantia Bold", 12.0);
        label12.setFont(font12);

        // Dodaj kolejny Label
        Label label22 = new Label();
        label22.setLayoutX(10.0);
        label22.setLayoutY(178.0);
        label22.setPrefHeight(17.0);
        label22.setPrefWidth(107.0);
        label22.setText("1995");
        Font font22 = new Font("Constantia Bold", 12.0);
        label22.setFont(font22);

        // Dodaj elementy do dodatkowego Pane
        additionalPane2.getChildren().addAll(button2, imageView2, label12, label22);




        // Dodaj dodatkowy Pane
        Pane additionalPane3 = new Pane();
        additionalPane3.setLayoutX(350.0);
        additionalPane3.setLayoutY(50.0);
        additionalPane3.setPrefHeight(200.0);
        additionalPane3.setPrefWidth(127.0);
        additionalPane3.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button3 = new Button();
        button3.setId("popularFilm1");
        button3.setLayoutX(3.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(150.0);
        button3.setPrefWidth(90.0);
        button3.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView3 = new ImageView();
        imageView3.setId("topViewButton1");
        imageView3.setFitHeight(150.0);
        imageView3.setFitWidth(200.0);
        imageView3.setLayoutX(15.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        Image image3 = new Image(getClass().getResource("/img/serial1.jpg").toExternalForm());
        imageView3.setImage(image3);

        // Dodaj Label
        Label label13 = new Label();
        label13.setLayoutX(10.0);
        label13.setLayoutY(158.0);
        label13.setPrefHeight(17.0);
        label13.setPrefWidth(107.0);
        label13.setText("PRZYJACIELE");
        Font font13 = new Font("Constantia Bold", 12.0);
        label13.setFont(font13);

        // Dodaj kolejny Label
        Label label23 = new Label();
        label23.setLayoutX(10.0);
        label23.setLayoutY(178.0);
        label23.setPrefHeight(17.0);
        label23.setPrefWidth(107.0);
        label23.setText("1994");
        Font font23 = new Font("Constantia Bold", 12.0);
        label23.setFont(font23);

        // Dodaj elementy do dodatkowego Pane
        additionalPane3.getChildren().addAll(button3, imageView3, label13, label23);





        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane, additionalPane2, additionalPane3);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onAdventureButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Przygodowy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/7885578.6.jpg").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("STAR WARS");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("1983");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);


        // Dodaj dodatkowy Pane
        Pane additionalPane2 = new Pane();
        additionalPane2.setLayoutX(200.0);
        additionalPane2.setLayoutY(50.0);
        additionalPane2.setPrefHeight(200.0);
        additionalPane2.setPrefWidth(127.0);
        additionalPane2.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button2 = new Button();
        button2.setId("popularFilm1");
        button2.setLayoutX(3.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(150.0);
        button2.setPrefWidth(90.0);
        button2.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView2 = new ImageView();
        imageView2.setId("topViewButton1");
        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setLayoutX(10.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        Image image2 = new Image(getClass().getResource("/img/film1.jpg").toExternalForm());
        imageView2.setImage(image2);

        // Dodaj Label
        Label label12 = new Label();
        label12.setLayoutX(10.0);
        label12.setLayoutY(158.0);
        label12.setPrefHeight(17.0);
        label12.setPrefWidth(107.0);
        label12.setText("REBEL MOON");
        Font font12 = new Font("Constantia Bold", 12.0);
        label12.setFont(font12);

        // Dodaj kolejny Label
        Label label22 = new Label();
        label22.setLayoutX(10.0);
        label22.setLayoutY(178.0);
        label22.setPrefHeight(17.0);
        label22.setPrefWidth(107.0);
        label22.setText("2023");
        Font font22 = new Font("Constantia Bold", 12.0);
        label22.setFont(font22);

        // Dodaj elementy do dodatkowego Pane
        additionalPane2.getChildren().addAll(button2, imageView2, label12, label22);




        // Dodaj dodatkowy Pane
        Pane additionalPane3 = new Pane();
        additionalPane3.setLayoutX(350.0);
        additionalPane3.setLayoutY(50.0);
        additionalPane3.setPrefHeight(200.0);
        additionalPane3.setPrefWidth(127.0);
        additionalPane3.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button3 = new Button();
        button3.setId("popularFilm1");
        button3.setLayoutX(3.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(150.0);
        button3.setPrefWidth(90.0);
        button3.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView3 = new ImageView();
        imageView3.setId("topViewButton1");
        imageView3.setFitHeight(150.0);
        imageView3.setFitWidth(200.0);
        imageView3.setLayoutX(15.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        Image image3 = new Image(getClass().getResource("/img/film2.jpg").toExternalForm());
        imageView3.setImage(image3);

        // Dodaj Label
        Label label13 = new Label();
        label13.setLayoutX(10.0);
        label13.setLayoutY(158.0);
        label13.setPrefHeight(17.0);
        label13.setPrefWidth(107.0);
        label13.setText("INDIANA JONES");
        Font font13 = new Font("Constantia Bold", 12.0);
        label13.setFont(font13);

        // Dodaj kolejny Label
        Label label23 = new Label();
        label23.setLayoutX(10.0);
        label23.setLayoutY(178.0);
        label23.setPrefHeight(17.0);
        label23.setPrefWidth(107.0);
        label23.setText("2023");
        Font font23 = new Font("Constantia Bold", 12.0);
        label23.setFont(font23);

        // Dodaj elementy do dodatkowego Pane
        additionalPane3.getChildren().addAll(button3, imageView3, label13, label23);





        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane, additionalPane2, additionalPane3);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onHorrorButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Horror");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/plakat-stranger-things.jpg").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("STRANGER THINGS");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2016");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);

        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onKidsButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Dla dzieci");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/serial2.jpg").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("PSI PATROL");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2021");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);


        // Dodaj dodatkowy Pane
        Pane additionalPane2 = new Pane();
        additionalPane2.setLayoutX(200.0);
        additionalPane2.setLayoutY(50.0);
        additionalPane2.setPrefHeight(200.0);
        additionalPane2.setPrefWidth(127.0);
        additionalPane2.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button2 = new Button();
        button2.setId("popularFilm1");
        button2.setLayoutX(3.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(150.0);
        button2.setPrefWidth(90.0);
        button2.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView2 = new ImageView();
        imageView2.setId("topViewButton1");
        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setLayoutX(10.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        Image image2 = new Image(getClass().getResource("/img/7322795.6.jpg").toExternalForm());
        imageView2.setImage(image2);

        // Dodaj Label
        Label label12 = new Label();
        label12.setLayoutX(10.0);
        label12.setLayoutY(158.0);
        label12.setPrefHeight(17.0);
        label12.setPrefWidth(107.0);
        label12.setText("TOY STORY");
        Font font12 = new Font("Constantia Bold", 12.0);
        label12.setFont(font12);

        // Dodaj kolejny Label
        Label label22 = new Label();
        label22.setLayoutX(10.0);
        label22.setLayoutY(178.0);
        label22.setPrefHeight(17.0);
        label22.setPrefWidth(107.0);
        label22.setText("1995");
        Font font22 = new Font("Constantia Bold", 12.0);
        label22.setFont(font22);

        // Dodaj elementy do dodatkowego Pane
        additionalPane2.getChildren().addAll(button2, imageView2, label12, label22);



        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane, additionalPane2);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onHistoryButtonClciked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();
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
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Romans");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(10.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/film3.png").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("BIEDNE ISTOTY");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2023");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);

        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onCommedyOfMannersButtonClicked(MouseEvent mouseEvent)  throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Obyczajowy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(10.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/serial1.jpg").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("PRZYJACIELE");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("1994");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);

        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }

    public void onNatureButtonClciked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        Pane genresContainer = (Pane) root.lookup("#GenresContent");
        genresContainer.getChildren().clear();
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
        genresContainer.getChildren().clear();

        // Dodaj tekst
        Text text = new Text("Fantasy");
        text.setLayoutX(30);
        text.setLayoutY(30);

        // Dodaj dodatkowy Pane
        Pane additionalPane = new Pane();
        additionalPane.setLayoutX(50.0);
        additionalPane.setLayoutY(50.0);
        additionalPane.setPrefHeight(200.0);
        additionalPane.setPrefWidth(127.0);
        additionalPane.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button = new Button();
        button.setId("popularFilm1");
        button.setLayoutX(3.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(150.0);
        button.setPrefWidth(90.0);
        button.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView = new ImageView();
        imageView.setId("topViewButton1");
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(10.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        Image image = new Image(getClass().getResource("/img/7494142.3.jpg").toExternalForm());
        imageView.setImage(image);

        // Dodaj Label
        Label label1 = new Label();
        label1.setLayoutX(10.0);
        label1.setLayoutY(158.0);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(107.0);
        label1.setText("WŁADCA PIERŚCIENI");
        Font font1 = new Font("Constantia Bold", 12.0);
        label1.setFont(font1);

        // Dodaj kolejny Label
        Label label2 = new Label();
        label2.setLayoutX(10.0);
        label2.setLayoutY(178.0);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(107.0);
        label2.setText("2003");
        Font font2 = new Font("Constantia Bold", 12.0);
        label2.setFont(font2);

        // Dodaj elementy do dodatkowego Pane
        additionalPane.getChildren().addAll(button, imageView, label1, label2);


        // Dodaj dodatkowy Pane
        Pane additionalPane2 = new Pane();
        additionalPane2.setLayoutX(200.0);
        additionalPane2.setLayoutY(50.0);
        additionalPane2.setPrefHeight(200.0);
        additionalPane2.setPrefWidth(127.0);
        additionalPane2.setStyle("-fx-background-color: #fff;");

        // Dodaj elementy do dodatkowego Pane
        Button button2 = new Button();
        button2.setId("popularFilm1");
        button2.setLayoutX(3.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(150.0);
        button2.setPrefWidth(90.0);
        button2.setStyle("-fx-background-color: #fff;");

        // Dodaj grafikę do Button
        ImageView imageView2 = new ImageView();
        imageView2.setId("topViewButton1");
        imageView2.setFitHeight(150.0);
        imageView2.setFitWidth(200.0);
        imageView2.setLayoutX(5.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        Image image2 = new Image(getClass().getResource("/img/graotron.jpg").toExternalForm());
        imageView2.setImage(image2);

        // Dodaj Label
        Label label12 = new Label();
        label12.setLayoutX(10.0);
        label12.setLayoutY(158.0);
        label12.setPrefHeight(17.0);
        label12.setPrefWidth(107.0);
        label12.setText("GRA O TRON");
        Font font12 = new Font("Constantia Bold", 12.0);
        label12.setFont(font12);

        // Dodaj kolejny Label
        Label label22 = new Label();
        label22.setLayoutX(10.0);
        label22.setLayoutY(178.0);
        label22.setPrefHeight(17.0);
        label22.setPrefWidth(107.0);
        label22.setText("2011");
        Font font22 = new Font("Constantia Bold", 12.0);
        label22.setFont(font22);

        // Dodaj elementy do dodatkowego Pane
        additionalPane2.getChildren().addAll(button2, imageView2, label12, label22);


        // Dodaj tekst i dodatkowe Pane do genresContainer
        if (genresContainer != null) {
            genresContainer.getChildren().addAll(text, additionalPane, additionalPane2);
            PrimaryStageSingleton.INSTANCE.setScene(scene);
            PrimaryStageSingleton.INSTANCE.show();
        }
    }
}
