import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest extends BaseTest {
    @Test
    public void testSelectQuery() throws SQLException {
        String sqlPattern = "SELECT * FROM public.students WHERE id >?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);

        preparedStatement.setInt(1, 1);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.printf("Student: %s %s \n", rs.getString("first_name"), rs.getString("last_name"));
        }
    }

    @Test
    public void testInsertQuery() throws SQLException {
        String sqlPattern = "INSERT INTO public.students VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Mykola");
        preparedStatement.setInt(2, 5);
        preparedStatement.setString(3, "Kovalchuk");

        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows added", rows);
    }

    @Test
    public void testUpdateQuery() throws SQLException {
        String sqlPattern = "UPDATE public.students SET first_name=? WHERE last_name=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Anton");
        preparedStatement.setString(2, "Kovalchuk");

        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows updated", rows);
    }

    @Test
    public void testDeleteQuery() throws SQLException {
        String sqlPattern = "DELETE FROM public.students WHERE last_name=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sqlPattern);
        preparedStatement.setString(1, "Kovalchuk");

        int rows = preparedStatement.executeUpdate();
        System.out.printf("%d rows deleted", rows);
    }
}
