package BaseClasses;

import java.util.List;
import java.util.ArrayList;

// Klasa reprezentująca film
public class Movie {
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

    public Movie(int id1, String title1, String genre1, String director1, List<String> actors1, int year1, String description1) {
        this.actors = actors1;
        this.id = id1;
        this.title = title1;
        this.genre = genre1;
        this.director = director1;
        this.year = year1;
        this.description = description1;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }
}