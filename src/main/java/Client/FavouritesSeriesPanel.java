package Client;

import BaseClasses.Movie;
import ClientServer.ClientStart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;


public class FavouritesSeriesPanel {


    @FXML
    private Label Description= new Label();

    @FXML
    private Label Director= new Label();

    @FXML
    private Label Genre= new Label();

    @FXML
    private ImageView Photo = new ImageView();

    @FXML
    private Text Year = new Text();

    @FXML
    private Button genreButtonMovieDashboard;

    @FXML
    private Button homeButtonMovieDashboard;

    @FXML
    private Button logoutButtonMovieDashboard;

    @FXML
    private Button moviesButtonMovieDashboard;

    @FXML
    private Button serialsButtonMovieDashboard;

    @FXML
    private Button settingsButtonMovieDashboard;
    @FXML
    private Label Title = new Label();
    @FXML
    private Button GoLeft = new Button();

    @FXML
    private Button GoRight = new Button();
    @FXML
    private Button DeleteFromFavourites = new Button();
    @FXML
    private Label YearLaber = new Label();


    @FXML
    private Label directorLabel= new Label();
    @FXML
    private Label genreLabel= new Label();
    int current = 0;
    public void showPhoto(int id)
    {

        if(id == 0)
        {
            Image image = new Image(getClass().getResourceAsStream("/img/serial1.jpg"));
            Photo.setImage(image);
        }
        else if(id == 1)
        {
            Image image = new Image(getClass().getResourceAsStream("/img/serial2.jpg"));
            Photo.setImage(image);

        }
        else if(id == 2)
        {
            Image image = new Image(getClass().getResourceAsStream("/img/plakat-stranger-things.jpg"));
            Photo.setImage(image);
        }
        else if(id == 3)
        {
            Image image = new Image(getClass().getResourceAsStream("/img/graotron.jpg"));
            Photo.setImage(image);
        }
    }
    public void setUp()
    {
        List<Movie> movieList = ClientStart.getAcc().favouriteTVseries;
        if(movieList.isEmpty())
        {
            Description.setVisible(false);
            Director.setVisible(false);
            Genre.setVisible(false);
            Photo.setVisible(false);
            Year.setVisible(false);
            Title.setText("No favourites series");
            GoLeft.setVisible(false);
            GoRight.setVisible(false);
            DeleteFromFavourites.setVisible(false);
            YearLaber.setVisible(false);
            directorLabel.setVisible(false);
            genreLabel.setVisible(false);
        }
        else
        {
            Description.setText(ClientStart.getAcc().favouriteTVseries.get(current).description);
            Director.setText(ClientStart.getAcc().favouriteTVseries.get(current).director);
            Genre.setText(ClientStart.getAcc().favouriteTVseries.get(current).genre);
            Year.setText(String.valueOf(ClientStart.getAcc().favouriteTVseries.get(current).year));
            Title.setText(ClientStart.getAcc().favouriteTVseries.get(current).title);
            showPhoto(ClientStart.getAcc().favouriteTVseries.get(current).id);
        }
    }
    public FavouritesSeriesPanel()
    {
        setUp();
    }
    @FXML
    void onAddToFavoritesButtonClicked(MouseEvent event)
    {
        ClientStart.getAcc().favouriteTVseries.remove(current);
        current = 0;
        setUp();
    }

    @FXML
    public void onGenreButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("GenresPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("GenresPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    @FXML
    public void onHomeButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MovieDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("MovieDashboard");
        PrimaryStageSingleton.INSTANCE.show();
    }

    @FXML
    public void onLogoutButtonMovieDashboardClicked(MouseEvent mouseEvent)  throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("LoginForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Login");
        PrimaryStageSingleton.INSTANCE.show();
    }

    @FXML
    public void onMoviesButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("MoviesPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("MoviesPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    @FXML
    public void onSerialsButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("TVseriesPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("TVseriesPanel");
        PrimaryStageSingleton.INSTANCE.show();
    }

    @FXML
    public void onSettingsButtonMovieDashboardClicked(MouseEvent mouseEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(LoginForm.class.getResource("Settings.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PrimaryStageSingleton.INSTANCE.setScene(scene);
        PrimaryStageSingleton.INSTANCE.setTitle("Settings");
        PrimaryStageSingleton.INSTANCE.show();
    }

    @FXML
    void onRight(ActionEvent event)
    {
        if(current < ClientStart.getAcc().favouriteTVseries.size()-1)
            current++;
        setUp();
    }
    @FXML
    void onLeft(ActionEvent event)
    {
        if(current > 0)
            current --;
        setUp();
    }

}
