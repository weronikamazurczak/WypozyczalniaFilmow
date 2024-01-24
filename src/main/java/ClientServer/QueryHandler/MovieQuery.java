package ClientServer.QueryHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieQuery {
    private Connection dataBaseConnection;
    public MovieQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }

    public void getAllMoviesByAccountId(int userId) throws SQLException {
        // SQL query to fetch movies rented or marked as favourite by the user
        String sql = "SELECT DISTINCT M.idMovie, M.title " +
                "FROM Movie M " +
                "LEFT JOIN Rent R ON M.idMovie = R.idMovie " +
                "LEFT JOIN FavouriteMovie FM ON M.idMovie = FM.idMovie " +
                "WHERE R.idAccount = ? OR FM.idAccount = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int movieId = resultSet.getInt("idMovie");
            String title = resultSet.getString("title");

            // Process the movie data as needed, for example, printing out
            System.out.println("Movie ID: " + movieId + " Title: " + title);
        }
    }
}
