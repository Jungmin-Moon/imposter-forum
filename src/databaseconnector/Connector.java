package databaseconnector;
import java.sql.*;


public class Connector {

    Connection connection = null;

    protected Connection establishConnection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/forum",
                    "luckyseven", "L}1h0#40iF40xEjYFB"
            );

            Statement statement = connection.createStatement();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }

        return connection;
    }

    protected void closeConnection() throws SQLException{
        connection.close();
    }
}
