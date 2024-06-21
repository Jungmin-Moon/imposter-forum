package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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

        Scene threadScene = new Scene(threadPane, 600, 600);

        threadPane.setCenter(threadsMiddle);

        Label placeHolder = new Label();

        Label sceneTitle = new Label();

        Text spacing = new Text("          ");

        Hyperlink title = null;


        if (listOfThreads.isEmpty()) {
            placeHolder.setText("There are currently no threads.");
            placeHolder.setAlignment(Pos.CENTER);
        } else {
            sceneTitle.setText("====================Threads====================");
            sceneTitle.setAlignment(Pos.CENTER);
            for (int i = 0; i < listOfThreads.size(); i++) {
                title = new Hyperlink(listOfThreads.get(i).getName());
                Text madeByUser = new Text(listOfThreads.get(i).getWhoStarted());
                Text dateMade = new Text(listOfThreads.get(i).getDateCreated().toString());
                threadsMiddle.addRow(i, madeByUser, spacing, title, spacing, dateMade);
            }


        }


        Button createThread = new Button("Create new thread");
        GridPane bottomPane = new GridPane();

        bottomPane.addRow(0, createThread);

        createThread.setOnAction(e -> threadPane.setCenter(createThreadPane(threadPane, threadsMiddle, conn)));


        return threadScene;
    }

    public static Pane createThreadPane(BorderPane tPane, GridPane threads, Connection conn) {
        GridPane creatingThread = new GridPane();

        Label title = new Label("Title of thread");
        Label body = new Label("Enter text here:");

        TextField titleField = new TextField();
        TextArea post = new TextArea();

        Button submitThread = new Button("Submit");

        Text space = new Text(" ");

        post.setTextFormatter(new TextFormatter<String>(change ->
                            change.getControlNewText().length() <= 400 ? change : null));

        creatingThread.addRow(0, title, space, titleField);
        creatingThread.addRow(3, body);
        creatingThread.addRow(4, post);
        creatingThread.addRow(6, submitThread);

        submitThread.setOnAction(e -> tPane.setCenter(threads));

        return creatingThread;
    }

}
