package BaseClasses;

import java.util.ArrayList;
import java.util.List;

// Klasa reprezentująca konto klienta
public class Account {
    int id;
    String type;
    Card creditCard;
    private List<Movie> availableMovies;
    Rent[] rentHistory;
    boolean blocked;

    public void rentMovie(String movie) {
        System.out.println("Wypożyczono film " + movie);
        // Implementacja wypożyczania filmu
    }

   public List<Movie> favouriteMovies = new ArrayList<>();
    public List<Movie> rentMovies = new ArrayList<>();
    public void addToFavorites(String movie) {
        System.out.println("Dodano do ulubionych film " + movie);
    }

    void returnMovie(Movie movie) {
        // Implementacja zwracania filmu
    }

    void addAccount() {
        // Implementacja dodawania konta
    }

    void assignClient() {
        // Implementacja przypisywania klienta do konta
    }

    void checkHistory() {
        // Implementacja sprawdzania historii wypożyczeń
    }

    public Rent[] getRentHistory() {
        return rentHistory;
    }

    public Account(boolean blocked, List<Movie> availableMovies, Rent[] rentHistory) {
        this.blocked = blocked;
        this.availableMovies = availableMovies;
        this.rentHistory = rentHistory;
    }
    public Account(){

    }
}