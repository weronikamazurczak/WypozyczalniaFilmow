package ClientServer.QueryHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class ScriptQuery {
    private final Connection dataBaseConnection;
    public ScriptQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }
    public boolean addScript(String title, String author, Date writtenDate, String genre) throws SQLException {
        String sql = "INSERT INTO Script (title, author, writtenDate, genre) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setDate(3, writtenDate);
            preparedStatement.setString(4, genre);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw e;
        }
    }
    public boolean editScript(int scriptId, String newTitle, String newAuthor, Date newWrittenDate, String newGenre) throws SQLException {
        String sql = "UPDATE Script SET title = ?, author = ?, writtenDate = ?, genre = ? WHERE idScript = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, newAuthor);
            preparedStatement.setDate(3, newWrittenDate);
            preparedStatement.setString(4, newGenre);
            preparedStatement.setInt(5, scriptId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw e;
        }
    }
    public boolean deleteScriptByIdScript(int scriptId) throws SQLException {
        String sql = "DELETE FROM Script WHERE idScript = ?";
        if (deleteMoviesAndRelatedEntriesByScriptId(scriptId)) {
            try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
                preparedStatement.setInt(1, scriptId);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                throw e;
            }
        }
        return false;
        }

    public void getScriptByIdScript(int scriptId) throws SQLException {
        String sql = "SELECT * FROM Script WHERE idScript = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, scriptId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Script ID: " + resultSet.getInt("idScript"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Author: " + resultSet.getString("author"));
                // Extract other script details as needed
            } else {
                System.out.println("No script found with ID: " + scriptId);
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean deleteMoviesAndRelatedEntriesByScriptId(int idScript) throws SQLException {

        dataBaseConnection.setAutoCommit(false);

        try {

            String sqlDeleteRent = "DELETE FROM Rent WHERE idMovie IN (SELECT idMovie FROM Movie WHERE idScript = ?)";
            try (PreparedStatement preparedStatementRent = dataBaseConnection.prepareStatement(sqlDeleteRent)) {
                preparedStatementRent.setInt(1, idScript);
                preparedStatementRent.executeUpdate();
            }


            String sqlDeleteFavouriteMovie = "DELETE FROM FavouriteMovie WHERE idMovie IN (SELECT idMovie FROM Movie WHERE idScript = ?)";
            try (PreparedStatement preparedStatementFavouriteMovie = dataBaseConnection.prepareStatement(sqlDeleteFavouriteMovie)) {
                preparedStatementFavouriteMovie.setInt(1, idScript);
                preparedStatementFavouriteMovie.executeUpdate();
            }


            String sqlDeleteMovie = "DELETE FROM Movie WHERE idScript = ?";
            try (PreparedStatement preparedStatementMovie = dataBaseConnection.prepareStatement(sqlDeleteMovie)) {
                preparedStatementMovie.setInt(1, idScript);
                int rowsAffected = preparedStatementMovie.executeUpdate();


                if (rowsAffected > 0) {
                    dataBaseConnection.commit();
                    return true;
                } else {
                    dataBaseConnection.rollback();
                }
            }
        } catch (SQLException e) {

            dataBaseConnection.rollback();
            throw e;
        } finally {
            // Reset the default commit behavior
            dataBaseConnection.setAutoCommit(true);
        }

        return false;
    }

}
