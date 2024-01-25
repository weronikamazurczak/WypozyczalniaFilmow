package ClientServer.QueryHandler;

import java.sql.*;

public class QueryHandler {

   private final UserQuery userQuery;
   private final MovieQuery movieQuery;
   private final ReviewQuery reviewQuery;
   private final RentQuery rentQuery;
   private final FavouriteMovieQuery favouriteMovieQuery;
   private final FilmDirectorQuery filmDirectorQuery;
   private final ScriptQuery scriptQuery;

   public QueryHandler(Connection dataBaseConnection) throws SQLException {

       this.userQuery = new UserQuery(dataBaseConnection);
       this.movieQuery = new MovieQuery(dataBaseConnection);
       this.reviewQuery = new ReviewQuery(dataBaseConnection);
       this.rentQuery = new RentQuery(dataBaseConnection);
       this.favouriteMovieQuery = new FavouriteMovieQuery(dataBaseConnection);
       this.filmDirectorQuery = new FilmDirectorQuery(dataBaseConnection);
       this.scriptQuery = new ScriptQuery(dataBaseConnection);
   }
   public void testQuery() throws SQLException {
      System.out.println("dodanie scenarzysty\n");
      scriptQuery.addScript(1,"scenarzysta");
      System.out.println("dodanie rezyser\n");
      filmDirectorQuery.addFilmDirector(1,"rezyser1");
      System.out.println("wyswietlenie filmow dla id uzytkownika 1\n");
      movieQuery.getAllMoviesByAccountId(1);
      System.out.println("wyswietlenie filmow dla id flmu 1 \n");
      movieQuery.getMovieByMovieID(1);
      System.out.println("wyswietlenie ulubionych filmow dla id flmu 1 \n");
      movieQuery.getAllFavouriteMoviesByAccountId(1);
      System.out.println("dodanie filmu \n");
      movieQuery.addNewMovie(1,"gdzie jest nemo","produkcja"
              ,"Disney","Komedia","20-11-2019",
              "20-11-2020","nemoIMG",1,
              "20-11-2023",1,1);
      movieQuery.getMovieByMovieID(1);
     // movieQuery.getAllMoviesByAccountId(3);
   }

   public UserQuery getUserQuery() {
      return userQuery;
   }

   public MovieQuery getMovieQuery() {
      return movieQuery;
   }

   public ReviewQuery getReviewQuery() {
      return reviewQuery;
   }

   public RentQuery getRentQuery() {
      return rentQuery;
   }

   public FavouriteMovieQuery getFavouriteMovieQuery() {
      return favouriteMovieQuery;
   }
   public ScriptQuery getScriptQuery() {
      return scriptQuery;
   }
   public FilmDirectorQuery getFilmDirectoryQuery() {
      return filmDirectorQuery;
   }



}
