package ClientServer.QueryHandler;

import java.sql.*;

public class QueryHandler {
   //private Connection dataBaseConnection;
   private final UserQuery userQuery;
   private final MovieQuery movieQuery;
   private final ReviewQuery reviewQuery;
   public QueryHandler(Connection dataBaseConnection) throws SQLException {
//      this.dataBaseConnection = dataBaseConnection;
      this.userQuery = new UserQuery(dataBaseConnection);
      this.movieQuery = new MovieQuery(dataBaseConnection);
       this.reviewQuery = new ReviewQuery(dataBaseConnection);
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
}