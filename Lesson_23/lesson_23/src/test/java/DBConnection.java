import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBConnection {
    private static DBConnection instance;
    private final Connection dbConnection;
    private final String dbUser;
    private static final Logger log = LogManager.getLogger(DBConnection.class);

    private DBConnection(String url, String dbUser, String dbPassword) throws SQLException {
        this.dbConnection = DriverManager.getConnection(url, dbUser, dbPassword);
        this.dbUser = dbUser;
    }

    public static DBConnection getInstance(String url, String dbUser, String dbPassword) throws SQLException {
        if (instance == null) {
            instance = new DBConnection(url, dbUser, dbPassword);
        } else if (!instance.dbUser.equals(dbUser)) {
            log.warn("Connection is open with different credentials");
        }
        return instance;
    }

    public static void closeConnection() throws SQLException {
        if (instance != null) {
            instance.getConnection().close();
        }
    }

    public Connection getConnection() {
        return this.dbConnection;
    }


}
