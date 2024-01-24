package ClientServer.QueryHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class RentQuery {
    private Connection dataBaseConnection;
    public RentQuery(Connection dataBaseConnection) throws SQLException {
        this.dataBaseConnection=dataBaseConnection;
    }


}
