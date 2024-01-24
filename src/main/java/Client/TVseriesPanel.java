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

public class TVseriesPanel {
    Account acc = ClientStart.getAcc();
    public void onFilterButtonRatingClicked(MouseEvent mouseEvent) {
    }

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

    public void onRentMovieButton1Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(0,"PRZYJACIELE","Komedia","David Crane, Marta Kauffman",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.rentTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypozyczony.");
    }

    public void addToFavoritesButton1Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(0,"PRZYJACIELE","Komedia","David Crane, Marta Kauffman",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.favouriteTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }

    public void onSeeReviewUsersButton1Clicked(MouseEvent mouseEvent) {
    }

    public void onRentMovieButton2Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(1,"PSI PATROL","Animacja, Komedia, Przygodowy, Dla dzieci","Spin Master Entertainment Nickelodeon Productions",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.rentTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypozyczony.");
    }

    public void onAddToFavoritesButton2Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(1,"PSI PATROL","Animacja, Komedia, Przygodowy, Dla dzieci","Spin Master Entertainment Nickelodeon Productions",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.favouriteTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }

    public void onSeeReviewUsersButton2Clicked(MouseEvent mouseEvent) {
    }

    public void onRentMovieButton3Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(2,"STRANGER THINGS","Horror, Fantasy","Matt Duffer i Ross Duffer",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.rentTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypozyczony.");
    }

    public void onAddToFavoritesButton3Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(2,"STRANGER THINGS","Horror, Fantasy","Matt Duffer i Ross Duffer",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.favouriteTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }

    public void onRentMovieButton4Clicked(MouseEvent mouseEvent) {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(3,"GRA O TRON","Fantasy, Dramat, Przygodowy","David Benioff i Dan Weiss",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.rentTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypozyczony.");

    }

    public void onAddToFavoritesButton4Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(3,"GRA O TRON","Fantasy, Dramat, Przygodowy","David Benioff i Dan Weiss",actors,1981,"");
        boolean test = false;
        for (Movie m:acc.favouriteTVseries) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }
}
