package ClientServer.QueryHandler;

import java.sql.*;

public class RentQuery {
    private final Connection dataBaseConnection;
    public RentQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }
    public boolean addRentByAccountAndMovie(int accountId, int movieId, Timestamp rentTimeStart, Timestamp rentTimeEnd) throws SQLException {
        String sql = "INSERT INTO Rent (idAccount, idMovie, rentTimeStart, rentTimeEnd) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);
            preparedStatement.setInt(2, movieId);
            preparedStatement.setTimestamp(3, rentTimeStart);
            preparedStatement.setTimestamp(4, rentTimeEnd);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {

            throw e;
        }
    }


    public boolean deleteRentByAccountAndMovie(int accountId, int movieId) throws SQLException {
        String sql = "DELETE FROM Rent WHERE idAccount = ? AND idMovie = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);
            preparedStatement.setInt(2, movieId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw e;
        }
    }
    public boolean deleteRentByUserID(int accountId) throws SQLException {
        String sql = "DELETE FROM Rent WHERE idAccount = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, accountId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {

            throw e;
        }
    }
}
