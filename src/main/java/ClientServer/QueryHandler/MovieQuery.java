package ClientServer.QueryHandler;

import java.sql.*;

public class MovieQuery {
    private final Connection dataBaseConnection;
    public MovieQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }

    public void getAllMoviesByAccountId(int userId) throws SQLException {

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


            System.out.println("Movie ID: " + movieId + " Title: " + title);
        }
    }
    public void getAllFavouriteMoviesByAccountId(int userId) throws SQLException {

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


            System.out.println("Movie ID: " + movieId + " Title: " + title);
        }
    }
    public void getMovieByMovieID(int movieId) throws SQLException {

        String sql = "SELECT * FROM Movie WHERE idMovie = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, movieId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {

            System.out.println("Movie ID: " + resultSet.getInt("idMovie"));
            System.out.println("Director ID: " + resultSet.getInt("idFilmDirector"));
            System.out.println("Script ID: " + resultSet.getInt("idScript"));
            System.out.println("Title: " + resultSet.getString("title"));
            System.out.println("Description: " + resultSet.getString("description"));

        } else {
            System.out.println("No movie found with ID: " + movieId);
        }
    }
    public boolean addNewMovie(String title, String description, String production, String genre,
                               String worldPremiereTime, String polandPremiereTime, String imgTitle,
                               int numberOfEpisodes, int idFilmDirector, int idScript) throws SQLException {

        String sql = "INSERT INTO Movie (title, description, production, genre, worldPremiereTime, " +
                "polandPremiereTime, imgTitle, numberOfEpisodes, idFilmDirector, idScript) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);

        preparedStatement.setString(1, title);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, production);
        preparedStatement.setString(4, genre);
        preparedStatement.setString(5, worldPremiereTime);
        preparedStatement.setString(6, polandPremiereTime);
        preparedStatement.setString(7, imgTitle);
        preparedStatement.setInt(8, numberOfEpisodes);
        preparedStatement.setInt(9, idFilmDirector);
        preparedStatement.setInt(10, idScript);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    }

    public boolean deleteMovieByID(int movieId) throws SQLException {
        boolean isSuccess = false;

        dataBaseConnection.setAutoCommit(false);

        try {

            if (!deleteReviewAndMovieReviewByMovieId(movieId)) {
                dataBaseConnection.rollback();
                return false;
            }


            if (!deleteAllRentByMovieID(movieId)) {
                dataBaseConnection.rollback();
                return false;
            }


            if (!deleteAllFavouriteMovieByID(movieId)) {
                dataBaseConnection.rollback();
                return false;
            }


            String sqlDeleteMovie = "DELETE FROM Movie WHERE idMovie = ?";
            PreparedStatement stmtDeleteMovie = dataBaseConnection.prepareStatement(sqlDeleteMovie);
            stmtDeleteMovie.setInt(1, movieId);
            int affectedRows = stmtDeleteMovie.executeUpdate();


            if (affectedRows > 0) {
                dataBaseConnection.commit();
                isSuccess = true;
            } else {

                dataBaseConnection.rollback();
            }
        } catch (SQLException e) {

            dataBaseConnection.rollback();
            throw e;
        } finally {

            dataBaseConnection.setAutoCommit(true);
        }

        return isSuccess;
    }


    public boolean editMovie(int movieId, String newTitle, String newDescription, String newProduction,
                             String newGenre, String newWorldPremiereTime, String newPolandPremiereTime,
                             String newImgTitle, int newNumberOfEpisodes, int newIdFilmDirector,
                             int newIdScript) throws SQLException {

        String sql = "UPDATE Movie SET title = ?, description = ?, production = ?, genre = ?, " +
                "worldPremiereTime = ?, polandPremiereTime = ?, imgTitle = ?, numberOfEpisodes = ?, " +
                "idFilmDirector = ?, idScript = ? WHERE idMovie = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);

        preparedStatement.setString(1, newTitle);
        preparedStatement.setString(2, newDescription);
        preparedStatement.setString(3, newProduction);
        preparedStatement.setString(4, newGenre);
        preparedStatement.setString(5, newWorldPremiereTime);
        preparedStatement.setString(6, newPolandPremiereTime);
        preparedStatement.setString(7, newImgTitle);
        preparedStatement.setInt(8, newNumberOfEpisodes);
        preparedStatement.setInt(9, newIdFilmDirector);
        preparedStatement.setInt(10, newIdScript);
        preparedStatement.setInt(11, movieId);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    }


    public boolean deleteAllFavouriteMovieByID(int movieId) throws SQLException {

        String sql = "DELETE FROM FavouriteMovie WHERE idMovie = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, movieId);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    }

    public boolean deleteAllRentByMovieID(int movieId) throws SQLException {

        String sql = "DELETE FROM Rent WHERE idMovie = ?";

        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);
        preparedStatement.setInt(1, movieId);

        int rowsAffected = preparedStatement.executeUpdate();

        return rowsAffected > 0;
    }

    public boolean deleteReviewAndMovieReviewByMovieId(int movieId) throws SQLException {



        dataBaseConnection.setAutoCommit(false);

        try {

            String sqlDeleteMovieReview = "DELETE FROM MovieReview WHERE idMovie = ?";
            PreparedStatement preparedStatementMovieReview = dataBaseConnection.prepareStatement(sqlDeleteMovieReview);

            preparedStatementMovieReview.setInt(1, movieId);
            int movieReviewRowsAffected = preparedStatementMovieReview.executeUpdate();


            if (movieReviewRowsAffected > 0) {
                String sqlDeleteReview = "DELETE FROM Review WHERE idReview IN (SELECT idReviews FROM MovieReview WHERE idMovie = ?)";
                PreparedStatement preparedStatementReview = dataBaseConnection.prepareStatement(sqlDeleteReview);

                preparedStatementReview.setInt(1, movieId);
                int reviewRowsAffected = preparedStatementReview.executeUpdate();


                if (reviewRowsAffected > 0) {
                    dataBaseConnection.commit();
                    return true;
                } else {

                    dataBaseConnection.commit();
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
}
