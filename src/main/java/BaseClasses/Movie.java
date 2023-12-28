package BaseClasses;

import java.util.List;
import java.util.ArrayList;

// Klasa reprezentująca film
class Movie {
    public int id;
    public String title;
    public String genre;
    public String director;
    public List<String> actors;
    public int year;
    public String description;

    public Movie() {
        this.actors = new ArrayList<>();
        this.id = 0;
        this.title = "";
        this.genre = "";
        this.director = "";
        this.year = 0;
        this.description = "";
    }
}