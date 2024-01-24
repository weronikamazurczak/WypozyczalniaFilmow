package ClientServer.QueryHandler;

import java.sql.Connection;

public class ReviewQuery {
    private Connection dataBaseConnection;
    ReviewQuery(Connection dataBaseConnection){
        this.dataBaseConnection=dataBaseConnection;
    }
}
