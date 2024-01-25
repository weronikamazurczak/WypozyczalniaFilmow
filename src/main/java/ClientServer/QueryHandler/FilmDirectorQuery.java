package ClientServer.QueryHandler;

import java.sql.*;

public class FilmDirectorQuery {
    private final Connection dataBaseConnection;
    public FilmDirectorQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }



    public void addFilmDirector(int idFilmDirector, String name) throws SQLException {
        String sql = "INSERT INTO FilmDirector (idFilmDirector,name) VALUES (?,?)";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idFilmDirector);
            preparedStatement.setString(2, name);


            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean editFilmDirector(int directorId, String newName, String newSurname, Date newBirthdate, String newNationality) throws SQLException {
        String sql = "UPDATE FilmDirector SET name = ?, surname = ?, birthdate = ?, nationality = ? WHERE idFilmDirector = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newSurname);
            preparedStatement.setDate(3, newBirthdate);
            preparedStatement.setString(4, newNationality);
            preparedStatement.setInt(5, directorId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {

            throw e;
        }
    }

    public boolean deleteFilmDirector(int directorId) throws SQLException {
        String sql = "DELETE FROM FilmDirector WHERE idFilmDirector = ?";
    if(deleteMoviesAndRelatedEntriesByFilmDirectorId(directorId)){
        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, directorId);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // True if the deletion was successful
        } catch (SQLException e) {
            // Log this exception to your logging framework
            throw e;
        }
    }
        return false;



    }


    public boolean deleteMoviesAndRelatedEntriesByFilmDirectorId(int directorId) throws SQLException {

        dataBaseConnection.setAutoCommit(false);

        try {

            String sqlDeleteRent = "DELETE FROM Rent WHERE idMovie IN (SELECT idMovie FROM Movie WHERE idFilmDirector = ?)";
            try (PreparedStatement preparedStatementRent = dataBaseConnection.prepareStatement(sqlDeleteRent)) {
                preparedStatementRent.setInt(1, directorId);
                preparedStatementRent.executeUpdate();
            }


            String sqlDeleteFavouriteMovie = "DELETE FROM FavouriteMovie WHERE idMovie IN (SELECT idMovie FROM Movie WHERE idFilmDirector = ?)";
            try (PreparedStatement preparedStatementFavouriteMovie = dataBaseConnection.prepareStatement(sqlDeleteFavouriteMovie)) {
                preparedStatementFavouriteMovie.setInt(1, directorId);
                preparedStatementFavouriteMovie.executeUpdate();
            }


            String sqlDeleteMovie = "DELETE FROM Movie WHERE idFilmDirector = ?";
            try (PreparedStatement preparedStatementMovie = dataBaseConnection.prepareStatement(sqlDeleteMovie)) {
                preparedStatementMovie.setInt(1, directorId);
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

    public void getDirectorByIdDirector(int directorId) throws SQLException {
        String sql = "SELECT * FROM FilmDirector WHERE idFilmDirector = ?";

        try (PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql)) {
            preparedStatement.setInt(1, directorId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Director ID: " + resultSet.getInt("idFilmDirector"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Surname: " + resultSet.getString("surname"));

            } else {
                System.out.println("No director found with ID: " + directorId);
            }
        } catch (SQLException e) {

            throw e;
        }
    }


}
