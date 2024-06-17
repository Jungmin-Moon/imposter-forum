package scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sqlfiles.Thread_List;
import threadfiles.User_Threads;
import userfile.User;

import javafx.scene.control.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Thread_List_Scene {
    public static Scene createThreadListScene(User user, Stage pStage, Connection conn) {

        List<User_Threads> listOfThreads = Thread_List.getListOfThreads(conn);

        BorderPane threadPane = new BorderPane();
        GridPane threadsMiddle = new GridPane();

        threadPane.setCenter(threadsMiddle);

        Text placeHolder = new Text();

        Text sceneTitle = new Text();
        Label threadText = new Label();
        StringBuilder list = new StringBuilder();

        if (listOfThreads.isEmpty()) {
            placeHolder.setText("There are currently no threads.");
        } else {
            sceneTitle.setText("====================Threads====================");
            for (int i = 0; i < listOfThreads.size(); i++) {
                list.append(listOfThreads.get(i).getWhoStarted())
                        .append("============")
                        .append(listOfThreads.get(i).getName())
                        .append("============")
                        .append(listOfThreads.get(i).getDateCreated());
            }

            threadText.setText(list.toString());
        }

        return new Scene(threadPane, 600, 600);

    }
}
