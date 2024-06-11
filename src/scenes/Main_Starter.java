package scenes;

import databaseconnector.Connector;
import javafx.application.Application;
import javafx.stage.Stage;
import userfile.User;

import java.sql.*;

public class Main_Starter extends Application {

     Connector connecter = new Connector();

     Connection connection = connecter.establishConnection();


    public void start(Stage primaryStage) {
        primaryStage.setScene(Login_Scene.createLoginScene(primaryStage, connection));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(Main_Starter.class, args);
    }
}
