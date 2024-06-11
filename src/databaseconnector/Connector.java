package databaseconnector;
import java.sql.*;


public class Connector {

    Connection connection = null;

    public Connection establishConnection() {
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

    public void closeConnection() throws SQLException{
        connection.close();
    }
}
