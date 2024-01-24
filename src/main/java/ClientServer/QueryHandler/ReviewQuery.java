package ClientServer.QueryHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReviewQuery {
    private Connection dataBaseConnection;
    ReviewQuery(Connection dataBaseConnection){
        this.dataBaseConnection=dataBaseConnection;
    }

    public boolean addReviewByUserIdAndMovieId(int userId, int movieId, String title, String description, int rate) throws SQLException {
        // SQL query to insert a new review into the Review table
        String sql = "INSERT INTO Review (idAccount, idMovie, title, description, rate) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);

        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, movieId);
        preparedStatement.setString(3, title);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, rate);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0; // Return true if the insert was successful
    }

    public boolean addReviewByUserId(int userId, String title, String description, int rate) throws SQLException {
        // SQL query to insert a new review into the Review table
        String sql = "INSERT INTO Review (idAccount, title, description, rate) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);

        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, title);
        preparedStatement.setString(3, description);
        preparedStatement.setInt(4, rate);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0; // Return true if the insert was successful
    }
}
