package Client.Test;

import BaseClasses.Account;
import javafx.scene.input.MouseEvent;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import BaseClasses.Movie;
public class TVseriesPanelTest {

    private Account mockAccount = new Account();
    @Test
    public void onRentMovieButton2Clicked_shouldRentTVSeries() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(1, "PSI PATROL", "Animacja, Komedia, Przygodowy, Dla dzieci", "Spin Master Entertainment Nickelodeon Productions", actors, 1981, "");
        boolean test = false;
        for (Movie m : mockAccount.rentTVseries) {
            if (m.id == movie.id) {
                test = true;
                break;
            }
        }
        if (!test)
            mockAccount.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypożyczony.");
    }

    @Test
    public void onAddToFavoritesButton2Clicked_shouldAddTVSeriesToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(1, "PSI PATROL", "Animacja, Komedia, Przygodowy, Dla dzieci", "Spin Master Entertainment Nickelodeon Productions", actors, 1981, "");
        boolean test = false;
        for (Movie m : mockAccount.favouriteTVseries) {
            if (m.id == movie.id) {
                test = true;
                break;
            }
        }
        if (!test)
            mockAccount.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }

    @Test
    public void onRentMovieButton3Clicked_shouldRentTVSeries() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(2, "STRANGER THINGS", "Horror, Fantasy", "Matt Duffer i Ross Duffer", actors, 1981, "");
        boolean test = false;
        for (Movie m : mockAccount.rentTVseries) {
            if (m.id == movie.id) {
                test = true;
                break;
            }
        }
        if (!test)
            mockAccount.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypożyczony.");
    }

    @Test
    public void onAddToFavoritesButton3Clicked_shouldAddTVSeriesToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(2, "STRANGER THINGS", "Horror, Fantasy", "Matt Duffer i Ross Duffer", actors, 1981, "");
        boolean test = false;
        for (Movie m : mockAccount.favouriteTVseries) {
            if (m.id == movie.id) {
                test = true;
                break;
            }
        }
        if (!test)
            mockAccount.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }

    @Test
    public void onRentMovieButton4Clicked_shouldRentTVSeries() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(3, "GRA O TRON", "Fantasy, Dramat, Przygodowy", "David Benioff i Dan Weiss", actors, 1981, "");
        boolean test = false;
        for (Movie m : mockAccount.rentTVseries) {
            if (m.id == movie.id) {
                test = true;
                break;
            }
        }
        if (!test)
            mockAccount.rentTVseries.add(movie);
        else
            System.out.println("Ten serial został już wypożyczony.");
    }

    @Test
    public void onAddToFavoritesButton4Clicked_shouldAddTVSeriesToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(3, "GRA O TRON", "Fantasy, Dramat, Przygodowy", "David Benioff i Dan Weiss", actors, 1981, "");
        boolean test = false;
        for (Movie m : mockAccount.favouriteTVseries) {
            if (m.id == movie.id) {
                test = true;
                break;
            }
        }
        if (!test)
            mockAccount.favouriteTVseries.add(movie);
        else
            System.out.println("Ten serial został już dodany do ulubionych.");
    }
}
