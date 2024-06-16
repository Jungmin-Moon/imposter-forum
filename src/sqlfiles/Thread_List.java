package sqlfiles;

import threadfiles.User_Threads;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Thread_List {

    public static List<User_Threads> getListOfThreads(Connection conn) {
        List<User_Threads> threadList = new ArrayList<>();

        try {
            String query = "Select * from threadlist";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);

            if (!set.isBeforeFirst()) {
                return threadList;
            } else {
                while (set.next()) {
                    LocalDate tempDate = set.getDate(3).toLocalDate();
                    User_Threads tempThread = new User_Threads(set.getString(1), tempDate, set.getString(2));
                    threadList.add(tempThread);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return threadList;
    }

}
