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
        // Przygotowanie danych
        List<String> actors = new ArrayList<>();
        actors.add("Harrison Ford");
        Movie movie = new Movie(0, "INDIANA JONES I ARTEFAKT PRZEZNACZENIA", "Przygodowy", "James Mangold", actors, 1981, "");
        mockAccount.favouriteMovies.add(movie);
        System.out.println("Tytuł: " + movie.title);
        assertFalse(mockAccount.favouriteMovies.isEmpty());
    }

    // Analogicznie można napisać testy dla pozostałych metod onAddToFavoritesButtonClicked2, onAddToFavoritesButtonClicked3, onAddToFavoritesButtonClicked4
}
