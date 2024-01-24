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
                "WHERE R.idAccount = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int movieId = resultSet.getInt("idMovie");
            String title = resultSet.getString("title");

            // Process the movie data as needed, for example, printing out
            System.out.println("Movie ID: " + movieId + " Title: " + title);
        }
    }
    public void getAllFavouriteMoviesByAccountId(int userId) throws SQLException {
        // SQL query to fetch movies rented or marked as favourite by the user
        String sql = "SELECT DISTINCT M.idMovie, M.title " +
                "FROM Movie M " +
                "LEFT JOIN FavouriteMovie FM ON M.idMovie = FM.idMovie " +
                "WHERE  FM.idAccount = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int movieId = resultSet.getInt("idMovie");
            String title = resultSet.getString("title");

            // Process the movie data as needed, for example, printing out
            System.out.println("Movie ID: " + movieId + " Title: " + title);
        }
    }
    public void getMovieByMovieID(int movieId) throws SQLException {
        // SQL query to fetch all the details of a movie by its ID
        String sql = "SELECT * FROM Movie WHERE idMovie = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, movieId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Assuming you want to print all the information
            System.out.println("Movie ID: " + resultSet.getInt("idMovie"));
            System.out.println("Director ID: " + resultSet.getInt("idFilmDirector"));
            System.out.println("Script ID: " + resultSet.getInt("idScript"));
            System.out.println("Title: " + resultSet.getString("title"));
            System.out.println("Description: " + resultSet.getString("description"));
            // ... print other fields as required
        } else {
            System.out.println("No movie found with ID: " + movieId);
        }
    }
}
