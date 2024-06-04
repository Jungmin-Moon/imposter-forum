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



        return correctUser;
    }

    public boolean validatePassword(String password, Connection conn) {
        boolean correctPass = false;



        return correctPass;
    }
}
