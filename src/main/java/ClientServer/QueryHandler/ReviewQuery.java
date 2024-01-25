package ClientServer.QueryHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class ReviewQuery {
    private Connection dataBaseConnection;
    ReviewQuery(Connection dataBaseConnection){
        this.dataBaseConnection=dataBaseConnection;
    }
    public boolean addReviewByUserAndMovie(int accountId, int movieId, String title, String description, double rate, Timestamp timeRecession) throws SQLException {



        dataBaseConnection.setAutoCommit(false);

        try {

            String sqlInsertReview = "INSERT INTO Review (idAccount, title, description, rate, timeRecession) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementReview = dataBaseConnection.prepareStatement(sqlInsertReview, Statement.RETURN_GENERATED_KEYS);

            preparedStatementReview.setInt(1, accountId);
            preparedStatementReview.setString(2, title);
            preparedStatementReview.setString(3, description);
            preparedStatementReview.setDouble(4, rate);
            preparedStatementReview.setTimestamp(5, timeRecession);

            int reviewRowsAffected = preparedStatementReview.executeUpdate();


            if (reviewRowsAffected > 0) {
                ResultSet generatedKeys = preparedStatementReview.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int reviewId = generatedKeys.getInt(1);


                    String sqlInsertMovieReview = "INSERT INTO MovieReview (idMovie, idReviews) VALUES (?, ?)";
                    PreparedStatement preparedStatementMovieReview = dataBaseConnection.prepareStatement(sqlInsertMovieReview);

                    preparedStatementMovieReview.setInt(1, movieId);
                    preparedStatementMovieReview.setInt(2, reviewId);

                    int movieReviewRowsAffected = preparedStatementMovieReview.executeUpdate();


                    if (movieReviewRowsAffected > 0) {
                        dataBaseConnection.commit();
                       return true;
                    } else {

                        dataBaseConnection.rollback();
                    }
                } else {
                    dataBaseConnection.rollback();
                }
            } else {
                dataBaseConnection.rollback();
            }
        } catch (SQLException e) {

            dataBaseConnection.rollback();
            throw e;
        } finally {

            dataBaseConnection.setAutoCommit(true);
        }

        return false;
    }

    public boolean deleteReviewByUserAndMovie(int accountId, int movieId) throws SQLException {



        dataBaseConnection.setAutoCommit(false);

        try {

            String sqlDeleteMovieReview = "DELETE FROM MovieReview WHERE idMovie = ? AND idReviews IN (SELECT idReview FROM Review WHERE idAccount = ?)";
            PreparedStatement preparedStatementMovieReview = dataBaseConnection.prepareStatement(sqlDeleteMovieReview);

            preparedStatementMovieReview.setInt(1, movieId);
            preparedStatementMovieReview.setInt(2, accountId);

            int movieReviewRowsAffected = preparedStatementMovieReview.executeUpdate();


            String sqlDeleteReview = "DELETE FROM Review WHERE idAccount = ? AND idReview IN (SELECT idReviews FROM MovieReview WHERE idMovie = ?)";
            PreparedStatement preparedStatementReview = dataBaseConnection.prepareStatement(sqlDeleteReview);

            preparedStatementReview.setInt(1, accountId);
            preparedStatementReview.setInt(2, movieId);

            int reviewRowsAffected = preparedStatementReview.executeUpdate();


            if (movieReviewRowsAffected > 0 && reviewRowsAffected > 0) {
                dataBaseConnection.commit();
                return true;
            } else {

                dataBaseConnection.rollback();
            }
        } catch (SQLException e) {

            dataBaseConnection.rollback();
            throw e;
        } finally {

            dataBaseConnection.setAutoCommit(true);
        }

        return false;
    }

    public boolean editReviewByUserAndMovie(int accountId, int movieId, String newTitle, String newDescription, double newRate, Timestamp newTimeRecession) throws SQLException {

        String sqlUpdateReview = "UPDATE Review SET title = ?, description = ?, rate = ?, timeRecession = ? " +
                "WHERE idAccount = ? AND idReview IN (SELECT idReviews FROM MovieReview WHERE idMovie = ?)";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sqlUpdateReview);

        preparedStatement.setString(1, newTitle);
        preparedStatement.setString(2, newDescription);
        preparedStatement.setDouble(3, newRate);
        preparedStatement.setTimestamp(4, newTimeRecession);
        preparedStatement.setInt(5, accountId);
        preparedStatement.setInt(6, movieId);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    }

}
