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

    public Movie(int id, String title, String genre, String director, List<String> actors, int year, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.year = year;
        this.description = description;
    }
}