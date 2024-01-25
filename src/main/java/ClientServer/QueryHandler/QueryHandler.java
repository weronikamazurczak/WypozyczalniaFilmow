package ClientServer.QueryHandler;

import java.sql.*;

public class QueryHandler {

   private final UserQuery userQuery;
   private final MovieQuery movieQuery;
   private final ReviewQuery reviewQuery;
   private final RentQuery rentQuery;
   private final FavouriteMovieQuery favouriteMovieQuery;
   private final FilmDirectorQuery filmDirectorQuery;

   public QueryHandler(Connection dataBaseConnection) throws SQLException {

       this.userQuery = new UserQuery(dataBaseConnection);
       this.movieQuery = new MovieQuery(dataBaseConnection);
       this.reviewQuery = new ReviewQuery(dataBaseConnection);
       this.rentQuery = new RentQuery(dataBaseConnection);
       this.favouriteMovieQuery = new FavouriteMovieQuery(dataBaseConnection);
       this.filmDirectorQuery = new FilmDirectorQuery(dataBaseConnection);
   }
   public void testQuery() throws SQLException {
      movieQuery.getAllMoviesByAccountId(2);
      movieQuery.getMovieByMovieID(1);
      movieQuery.getAllFavouriteMoviesByAccountId(1);
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

   public FilmDirectorQuery getFilmDirectoryQuery() {
      return filmDirectorQuery;
   }
}
