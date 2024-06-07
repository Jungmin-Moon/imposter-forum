package sqlfiles;
import com.mysql.cj.protocol.Resultset;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Registration {

    protected String registerUser(String userName, String password, String email, Connection conn) {
        if (alreadyExists(userName, conn)) {
            return "This user is already registered.";
        } else {
            addToTable(userName, password, email, conn);

            if (checkAdded(userName, conn)) {
                return "Successfully registered to the forum not forum.";
            }

            return "Something went wrong.";
        }
    }

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

    protected void addToTable(String userName, String password, String email, Connection conn) {
        try {
            LocalDate currentDate = LocalDate.now();
            String modDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
            String securePass = Password_Validation.generatePasswordHash(password);
            String query = "Insert into user(username, password, email, datejoined) values ('" +
                    userName + "', '" + securePass + "', '" + email + "', '" + modDate + "');";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean checkAdded(String userName, Connection conn) {

        try {
            String query = "Select * from user where username = '" + userName + "';";
            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery(query);

            if (rSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
