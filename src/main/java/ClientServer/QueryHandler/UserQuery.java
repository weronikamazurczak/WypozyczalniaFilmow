package ClientServer.QueryHandler;

import java.sql.*;

public class UserQuery {
    private Connection dataBaseConnection;
    public UserQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }
    public boolean createUser(String nameAccount, String surnameAccount, String password, int roleAccount, String birthdayAccount,
                              int blockedAccount, int idCard) throws SQLException {
        String sql = "INSERT INTO Account(idAccount, nameAccount, surnameAccount, password, roleAccount, birthdayAccount, blockedAccount, idCard) " +
                "VALUES (idAccount_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
        if (checkIfNameAccountExists(nameAccount)) {
            PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);

            preparedStatement.setString(1, nameAccount);
            preparedStatement.setString(2, surnameAccount);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, roleAccount);
            preparedStatement.setDate(5, Date.valueOf(birthdayAccount)); // Assuming the format is YYYY-MM-DD
            preparedStatement.setInt(6, blockedAccount);
            preparedStatement.setInt(7, idCard);


            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } else {
            return false;
        }
    }


    private boolean checkIfNameAccountExists(String nameAccount) throws SQLException {
        // Zapytanie SQL sprawdzające, czy nameAccount już istnieje
        String sql = "SELECT COUNT(*) FROM Account WHERE nameAccount = ?";


        PreparedStatement preparedStatement = dataBaseConnection.prepareStatement(sql);

        preparedStatement.setString(1, nameAccount);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Zwraca true, jeśli istnieje przynajmniej jedno konto o podanej wartości nameAccount
        }
        return false;
    }
}
