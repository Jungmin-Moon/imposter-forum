package sqlfiles;
import userfile.User;

import java.sql.*;

public class Login {


    public String loginUser(String userName, String password, Connection conn) {
        boolean checkName = validateUserName(userName, conn);
        boolean pass = validatePassword(password, conn);

        if (checkName) {
            if (pass) {
                return userName;
            } else {
                return "The password is incorrect.";
            }
        } else {
            return "The username is incorrect.";
        }

    }


    public boolean validateUserName(String userName, Connection conn) {
        boolean correctUser = false;

        try {
            String checkUser = "Select * from user where username = '" + userName + "';";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(checkUser);

            while (set.next()) {
                correctUser = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return correctUser;
    }

    public boolean validatePassword(String password, Connection conn) {
        boolean correctPass = false;

        try {
            String checkPass = "Select * from user where password = '" + password + "';";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(checkPass);

            while (set.next()) {
                correctPass = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return correctPass;
    }
}
