package scenes;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main_Starter extends Application {
    public void start(Stage primaryStage) {
        primaryStage.setScene(Login_Scene.createLoginScene(primaryStage));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(Main_Starter.class, args);
    }
}
