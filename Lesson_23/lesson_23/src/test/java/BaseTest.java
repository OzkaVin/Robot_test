import org.testng.annotations.AfterSuite;

import java.sql.Connection;
import java.sql.SQLException;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static final String dbAdderss = "jdbc:postgresql://localhost:5432/postgres";
    public static final String dbUser = "postgres";
    public static final String dbPassword = "Test1234";

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    protected Connection getConnection() throws SQLException {
        return DBConnection.getInstance(dbAdderss, dbUser, dbPassword).getConnection();
    }

    @AfterSuite
    public void tearDown() {
        try {
            DBConnection.closeConnection();
        } catch (SQLException e) {
            log.error("Failed to close connection {}", e.getMessage());
        }
    }
}
