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
        Movie movie = new Movie(0,"INDIANA JONES I ARTEFAKT PRZEZNACZENIA","Przygodowy","James Mangold",actors,1981,"Jest rok 1969. Dwa najpotężniejsze mocarstwa świata - Stany Zjednoczone Ameryki Północnej i Związek Radziecki - rywalizują w wyścigu o podbój kosmosu. Emerytowany poszukiwacz przygód Indiana Jones (Harrison Ford) jest zaniepokojony obrotem spraw, gdy dowiaduje się, że rząd USA werbuje byłych nazistów do pomocy w przedsięwzięciu. Niedługo po tym Jones wraz ze swoją chrześnicą Heleną (Phoebe Waller-Bridge) stawia czoła Vollerowi (Mads Mikkelsen) i jego nazistowskiej organizacji. Grupa ta pragnie zdobyć legendarny artefakt, za pomocą którego chce podporządkować sobie świat według wyznawanych wartości.");
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
        Movie movie = new Movie(1,"WŁADCA PIERŚCIENI: POWRÓT KRÓLA","Przygodowy, Fantasy","Peter Jackson",actors,2003,"Wyprawa Drużyny dobiega końca. Armie Saurona zaatakowały stolicę Gondoru, Minas Tirith. Patrząc na upadające królestwo ludzkości, wydaje się, że nigdy nie potrzebowało króla bardziej niż teraz. Ale czy Aragorn (Viggo Mortensen) znajdzie w sobie dość sił, by sięgnąć po należny mu z urodzenia tytuł i by podołać swemu przeznaczeniu?Gandalf (Ian McKellen) desperacko próbuje zebrać rozbite siły Gondoru, podczas gdy Théoden (Bernard Hill) jednoczy wojowników Rohanu. Jednak siły ludzi nie są wystarczające, aby oprzeć się uzbrojonym legionom wroga, które powoli zalewają kraj. Każde zwycięstwo pociąga za sobą dużo ofiar.");
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
        Movie movie = new Movie(2,"GWIEZDNE WOJNY: CZĘŚĆ VI - POWRÓT JEDI","Przygodowy, Sci-Fi","Richard Marquand",actors,1983,"W niezwykle widowiskowym, finałowym rozdziale sagi Gwiezdnych Wojen, Luke Skywalker i Księżniczka Leia ratują Hana Solo uwięzionego na Tatooine przez najbardziej odrażającego gangstera w galaktyce zwanego Jabba the Hutt. Rebelianci wraz z plemieniem Ewoków walczą z siłami Imperium na zalesionym księżycu Endor. W tym samym czasie Imperator i Darth Vader próbują znaleźć sposób, by przeciągnąć Luke'a na ciemną stronę, a z kolei młody Skywalker desperacko stara się obudzić w swym ojcu dawno uśpionego ducha Jedi. ");
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
        Movie movie = new Movie(3,"TOY STORY","Animacja, Familijny, Komedia","John Lasseter",actors,1995,"Bohaterami tego filmu są zabawki z dziecięcego pokoju. Zabawki, które ożywają, gdy tylko ludzie odwrócą od nich wzrok. Zabawki nie tylko mówią, myślą i czują, ale tak samo się kłócą, śmieją, boją, są zazdrosne, oszukują i romansują, czy wręcz mają kłopoty z tożsamością. Prym wśród zabawek wiedzie kowboj Chudy , ulubiona zabawka Andy'ego. Ale w dniu urodzin chłopca w pokoju zabaw pojawi się ktoś nowy. Jego przybycie zburzy panujące tam porządki, sprowadzając ze sobą sporo zamieszania i nowych kłopotów.");
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
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(0,"INDIANA JONES I ARTEFAKT PRZEZNACZENIA","Przygodowy","James Mangold",actors,1981,"Jest rok 1969. Dwa najpotężniejsze mocarstwa świata - Stany Zjednoczone Ameryki Północnej i Związek Radziecki - rywalizują w wyścigu o podbój kosmosu. Emerytowany poszukiwacz przygód Indiana Jones (Harrison Ford) jest zaniepokojony obrotem spraw, gdy dowiaduje się, że rząd USA werbuje byłych nazistów do pomocy w przedsięwzięciu. Niedługo po tym Jones wraz ze swoją chrześnicą Heleną (Phoebe Waller-Bridge) stawia czoła Vollerowi (Mads Mikkelsen) i jego nazistowskiej organizacji. Grupa ta pragnie zdobyć legendarny artefakt, za pomocą którego chce podporządkować sobie świat według wyznawanych wartości.");
        boolean test = false;
        for (Movie m:acc.rentMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentMovies.add(movie);
        else
            System.out.println("Ten film został już wypozyczony.");
    }
    public void onRentMovieButtonClicked2(MouseEvent mouseEvent) {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(1,"WŁADCA PIERŚCIENI: POWRÓT KRÓLA","Przygodowy, Fantasy","Peter Jackson",actors,2003,"Wyprawa Drużyny dobiega końca. Armie Saurona zaatakowały stolicę Gondoru, Minas Tirith. Patrząc na upadające królestwo ludzkości, wydaje się, że nigdy nie potrzebowało króla bardziej niż teraz. Ale czy Aragorn (Viggo Mortensen) znajdzie w sobie dość sił, by sięgnąć po należny mu z urodzenia tytuł i by podołać swemu przeznaczeniu?Gandalf (Ian McKellen) desperacko próbuje zebrać rozbite siły Gondoru, podczas gdy Théoden (Bernard Hill) jednoczy wojowników Rohanu. Jednak siły ludzi nie są wystarczające, aby oprzeć się uzbrojonym legionom wroga, które powoli zalewają kraj. Każde zwycięstwo pociąga za sobą dużo ofiar. ");
        boolean test = false;
        for (Movie m:acc.rentMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentMovies.add(movie);
        else
            System.out.println("Ten film został już wypozyczony.");
    }
    public void onRentMovieButtonClicked3(MouseEvent mouseEvent) {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(2,"GWIEZDNE WOJNY: CZĘŚĆ VI - POWRÓT JEDI","Przygodowy, Sci-Fi","Richard Marquand",actors,1983,"W niezwykle widowiskowym, finałowym rozdziale sagi Gwiezdnych Wojen, Luke Skywalker i Księżniczka Leia ratują Hana Solo uwięzionego na Tatooine przez najbardziej odrażającego gangstera w galaktyce zwanego Jabba the Hutt. Rebelianci wraz z plemieniem Ewoków walczą z siłami Imperium na zalesionym księżycu Endor. W tym samym czasie Imperator i Darth Vader próbują znaleźć sposób, by przeciągnąć Luke'a na ciemną stronę, a z kolei młody Skywalker desperacko stara się obudzić w swym ojcu dawno uśpionego ducha Jedi. ");
        boolean test = false;
        for (Movie m:acc.rentMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentMovies.add(movie);
        else
            System.out.println("Ten film został już wypozyczony.");
    }
    public void onRentMovieButtonClicked4(MouseEvent mouseEvent) {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(3,"TOY STORY","Animacja, Familijny, Komedia","John Lasseter",actors,2003,"Bohaterami tego filmu są zabawki z dziecięcego pokoju. Zabawki, które ożywają, gdy tylko ludzie odwrócą od nich wzrok. Zabawki nie tylko mówią, myślą i czują, ale tak samo się kłócą, śmieją, boją, są zazdrosne, oszukują i romansują, czy wręcz mają kłopoty z tożsamością. Prym wśród zabawek wiedzie kowboj Chudy , ulubiona zabawka Andy'ego. Ale w dniu urodzin chłopca w pokoju zabaw pojawi się ktoś nowy. Jego przybycie zburzy panujące tam porządki, sprowadzając ze sobą sporo zamieszania i nowych kłopotów.");
        boolean test = false;
        for (Movie m:acc.rentMovies) {
            if(m.id == movie.id) {
                test = true;
                break;
            }
        }
        if(!test)
            acc.rentMovies.add(movie);
        else
            System.out.println("Ten film został już wypozyczony.");
    }
}
