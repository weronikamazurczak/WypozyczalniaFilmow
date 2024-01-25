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
public class MoviesPanelTest {

    private Account mockAccount = new Account();

    @Test
    public void onAddToFavoritesButtonClicked_shouldAddMovieToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(0, "INDIANA JONES I ARTEFAKT PRZEZNACZENIA", "Przygodowy", "James Mangold", actors, 1981, "");
        mockAccount.favouriteMovies.add(movie);
        System.out.println("Tytuł: " + movie.title);
        assertFalse(mockAccount.favouriteMovies.isEmpty());
    }

    @Test
    public void onAddToFavoritesButtonClicked2_shouldAddMovieToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(1, "WŁADCA PIERŚCIENI: POWRÓT KRÓLA", "Przygodowy, Fantasy", "Peter Jackson", actors, 2003, "");
        mockAccount.favouriteMovies.add(movie);
        assertFalse(mockAccount.favouriteMovies.isEmpty());
    }

    @Test
    public void onAddToFavoritesButtonClicked3_shouldAddMovieToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(2, "GWIEZDNE WOJNY: CZĘŚĆ VI - POWRÓT JEDI", "Przygodowy, Sci-Fi", "Richard Marquand", actors, 1983, "");
        mockAccount.favouriteMovies.add(movie);
        assertFalse(mockAccount.favouriteMovies.isEmpty());
    }

    @Test
    public void onAddToFavoritesButtonClicked4_shouldAddMovieToFavorites() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(3, "TOY STORY", "Animacja, Familijny, Komedia", "John Lasseter", actors, 1995, "");
        mockAccount.favouriteMovies.add(movie);
        assertFalse(mockAccount.favouriteMovies.isEmpty());
    }

    @Test
    public void onRentMovieButtonClicked_shouldRentMovie() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(0, "INDIANA JONES I ARTEFAKT PRZEZNACZENIA", "Przygodowy", "James Mangold", actors, 1981, "");
        mockAccount.rentMovies.add(movie);
        assertFalse(mockAccount.rentMovies.isEmpty());
    }

    @Test
    public void onRentMovieButtonClicked2_shouldRentMovie() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(1, "WŁADCA PIERŚCIENI: POWRÓT KRÓLA", "Przygodowy, Fantasy", "Peter Jackson", actors, 2003, "");
        mockAccount.rentMovies.add(movie);
        assertFalse(mockAccount.rentMovies.isEmpty());
    }

    @Test
    public void onRentMovieButtonClicked3_shouldRentMovie() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(2, "GWIEZDNE WOJNY: CZĘŚĆ VI - POWRÓT JEDI", "Przygodowy, Sci-Fi", "Richard Marquand", actors, 1983, "");
        mockAccount.rentMovies.add(movie);
        assertFalse(mockAccount.rentMovies.isEmpty());
    }

    @Test
    public void onRentMovieButtonClicked4_shouldRentMovie() {
        List<String> actors = new ArrayList<>();
        actors.add("Frodo Baggins");
        Movie movie = new Movie(3, "TOY STORY", "Animacja, Familijny, Komedia", "John Lasseter", actors, 1995, "");
        mockAccount.rentMovies.add(movie);
        assertFalse(mockAccount.rentMovies.isEmpty());
    }
}
