package scenes;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sqlfiles.Thread_List;
import threadfiles.User_Threads;
import userfile.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Thread_List_Scene {
    public static Scene createThreadListScene(User user, Stage pStage, Connection conn) {

        List<User_Threads> listOfThreads = Thread_List.getListOfThreads(conn);

        GridPane threadPane = new GridPane();



        return new Scene(threadPane, 600, 600);

    }
}
