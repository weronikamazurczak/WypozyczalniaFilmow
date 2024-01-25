package ClientServer.QueryHandler;

import java.sql.*;

public class FavouriteMovieQuery {
    private final Connection dataBaseConnection;
    public FavouriteMovieQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }



    public boolean addFavouriteMovieByAccountAndMovie(int accountId, int movieId) throws SQLException {
        String sql = "INSERT INTO FavouriteMovie (idAccount, idMovie) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);
            preparedStatement.setInt(2, movieId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {

            throw e;
        }
    }


    public boolean deleteFavouriteMovieByAccountAndMovie(int accountId, int movieId) throws SQLException {
        String sql = "DELETE FROM FavouriteMovie WHERE idAccount = ? AND idMovie = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);
            preparedStatement.setInt(2, movieId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw e;
        }
    }
    public boolean deleteAllFavouriteMoviesByUserID(int accountId) throws SQLException {
        String sql = "DELETE FROM FavouriteMovie WHERE idAccount = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw e;
        }
    }


}
