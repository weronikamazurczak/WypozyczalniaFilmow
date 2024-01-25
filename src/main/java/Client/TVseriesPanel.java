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
        Movie movie = new Movie(0,"PRZYJACIELE","Komedia","David Crane, Marta Kauffman",actors,1981,"Pełen humoru serial opowiadający o szóstce przyjaciół mieszkających w Nowym Jorku: Monica - ma obsesję na punkcie czystości i bycia najlepszym, Rachel - rozpuszczona dziewczyna z bogatego domu, która uczy się samodzielności, Phoebe - trudno zrozumieć jej abstrakcyjne poglądy i zachowanie, Joey - niezbyt inteligentny podrywacz, Chandler - żartuje ze wszystkiego, swoje wypowiedzi zabarwione humorem wtrąca przy każdej okazji oraz Ross - jest paleontologiem, fascynuje się nauką i ma pecha do kobiet.");
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
        Movie movie = new Movie(0,"PRZYJACIELE","Komedia","David Crane, Marta Kauffman",actors,1990,"Pełen humoru serial opowiadający o szóstce przyjaciół mieszkających w Nowym Jorku: Monica - ma obsesję na punkcie czystości i bycia najlepszym, Rachel - rozpuszczona dziewczyna z bogatego domu, która uczy się samodzielności, Phoebe - trudno zrozumieć jej abstrakcyjne poglądy i zachowanie, Joey - niezbyt inteligentny podrywacz, Chandler - żartuje ze wszystkiego, swoje wypowiedzi zabarwione humorem wtrąca przy każdej okazji oraz Ross - jest paleontologiem, fascynuje się nauką i ma pecha do kobiet.");
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

    public void onRentMovieButton2Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(1,"PSI PATROL","Animacja, Komedia, Przygodowy, Dla dzieci","Spin Master Entertainment Nickelodeon Productions",actors,1999,"\"Psi Patrol\" to serial ukazujący perypetie sześciorga bohaterskich szczeniąt: Marshalla, Chase’a, Rocky’ego, Zumy, Rubble’a i Skye, które pod przywództwem dziesięcioletniego Rydera wyruszają na ratunek potrzebującym. Żadna praca nie jest zbyt duża, a żaden psiak zbyt mały, aby ruszyć do akcji, kiedy ktoś prosi o pomoc.");
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
        Movie movie = new Movie(1,"PSI PATROL","Animacja, Komedia, Przygodowy, Dla dzieci","Spin Master Entertainment Nickelodeon Productions",actors,2010,"W tajemniczym miasteczku Hawkins w Indianie, grupa dzieciaków – Mike, Eleven, Dustin i Lucas – przypadkowo wpada na mroczny świat, gdzie znikają ludzie, a tajemnicze zjawiska nadprzyrodzone stają się rzeczywistością. Wraz z przyjaciółmi, spragnionymi przygód naukowcami i dziwaczną dziewczynką o nadzwyczajnych mocach, próbują rozwikłać zagadkę tajemniczego eksperymentu rządowego i uratować swoje miasto przed złowieszczymi istotami z innego wymiaru.");
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

    public void onRentMovieButton3Clicked(MouseEvent mouseEvent) {

        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(2,"STRANGER THINGS","Horror, Fantasy","Matt Duffer i Ross Duffer",actors,2015,"W tajemniczym miasteczku Hawkins w Indianie, grupa dzieciaków – Mike, Eleven, Dustin i Lucas – przypadkowo wpada na mroczny świat, gdzie znikają ludzie, a tajemnicze zjawiska nadprzyrodzone stają się rzeczywistością. Wraz z przyjaciółmi, spragnionymi przygód naukowcami i dziwaczną dziewczynką o nadzwyczajnych mocach, próbują rozwikłać zagadkę tajemniczego eksperymentu rządowego i uratować swoje miasto przed złowieszczymi istotami z innego wymiaru.");
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
        Movie movie = new Movie(2,"STRANGER THINGS","Horror, Fantasy","Matt Duffer i Ross Duffer",actors,2009,"\"Psi Patrol\" to serial ukazujący perypetie sześciorga bohaterskich szczeniąt: Marshalla, Chase’a, Rocky’ego, Zumy, Rubble’a i Skye, które pod przywództwem dziesięcioletniego Rydera wyruszają na ratunek potrzebującym. Żadna praca nie jest zbyt duża, a żaden psiak zbyt mały, aby ruszyć do akcji, kiedy ktoś prosi o pomoc.");
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
        Movie movie = new Movie(3,"GRA O TRON","Fantasy, Dramat, Przygodowy","David Benioff i Dan Weiss",actors,2017,"W królestwie Westeros, gdzie intrygi, zdrada i walka o władzę są na porządku dziennym, siedem rodzin szlacheckich zmaga się o kontrolę nad Żelaznym Tronem. W epicznej grze o władzę pojawiają się bohaterowie o różnych motywacjach – od honorowych rycerzy po sprytne intrygantki. Wśród nich znajduje się Jon Snow, nieślubny syn Starka, Daenerys Targaryen, ostatnia przedstawicielka rodu smoków, i Tyrion Lannister, błyskotliwy imp, którego dowcipne riposty są równie ostry jak jego umysł. W międzyczasie zbliża się zima, a wraz z nią nadciąga zagrożenie ze Strefy Północy, gdzie obudziły się mityczne istoty zmarłe i tajemniczy Nocny Król dąży do zniszczenia świata.");
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
        Movie movie = new Movie(3,"GRA O TRON","Fantasy, Dramat, Przygodowy","David Benioff i Dan Weiss",actors,2005,"W królestwie Westeros, gdzie intrygi, zdrada i walka o władzę są na porządku dziennym, siedem rodzin szlacheckich zmaga się o kontrolę nad Żelaznym Tronem. W epicznej grze o władzę pojawiają się bohaterowie o różnych motywacjach – od honorowych rycerzy po sprytne intrygantki. Wśród nich znajduje się Jon Snow, nieślubny syn Starka, Daenerys Targaryen, ostatnia przedstawicielka rodu smoków, i Tyrion Lannister, błyskotliwy imp, którego dowcipne riposty są równie ostry jak jego umysł. W międzyczasie zbliża się zima, a wraz z nią nadciąga zagrożenie ze Strefy Północy, gdzie obudziły się mityczne istoty zmarłe i tajemniczy Nocny Król dąży do zniszczenia świata.");
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
