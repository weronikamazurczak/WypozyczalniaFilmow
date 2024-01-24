package Client;

import BaseClasses.Account;
import BaseClasses.Movie;
import ClientServer.ClientStart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesPanel {
    Account acc = ClientStart.getAcc();
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

    public void onAddToFavoritesButtonClicked(MouseEvent mouseEvent)
    {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(0,"INDIANA JONES I ARTEFAKT PRZEZNACZENIA","Przygodowy","James Mangold",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.favouriteMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteMovies.add(movie);
        else
            System.out.println("Ten film został już dodany do ulubionych.");
    }

    public void onAddToFavoritesButtonClicked2(MouseEvent mouseEvent)
    {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(1,"WŁADCA PIERŚCIENI: POWRÓT KRÓLA","Przygodowy, Fantasy","Peter Jackson",actors,2003,"");
        boolean test = false;
        for (Movie m:acc.favouriteMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteMovies.add(movie);
        else
            System.out.println("Ten film został już dodany do ulubionych.");
    }

    public void onAddToFavoritesButtonClicked3(MouseEvent mouseEvent)
    {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(2,"GWIEZDNE WOJNY: CZĘŚĆ VI - POWRÓT JEDI","Przygodowy, Sci-Fi","Richard Marquand",actors,1983,"");
        boolean test = false;
        for (Movie m:acc.favouriteMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteMovies.add(movie);
        else
            System.out.println("Ten film został już dodany do ulubionych.");
    }
    public void onAddToFavoritesButtonClicked4(MouseEvent mouseEvent)
    {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(3,"TOY STORY","Animacja, Familijny, Komedia","John Lasseter",actors,1995,"");
        boolean test = false;
        for (Movie m:acc.favouriteMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteMovies.add(movie);
        else
            System.out.println("Ten film został już dodany do ulubionych.");
    }
    public void onRentMovieButtonClicked(MouseEvent mouseEvent) {
        acc.rentMovie("Film 1");
    }

}
