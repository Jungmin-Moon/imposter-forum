package sqlfiles;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Registration {

    protected boolean alreadyExists(String userName, Connection conn) {
        boolean exist = false;

        try {
            String query = "Select * from users where username = '" + userName + "';";

            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery(query);

            if (rSet.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exist;
    }

    //create user table
}
