package scenes;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import sqlfiles.Login;
import userfile.User;

import java.sql.*;

public class Login_Scene {



    public static Scene createLoginScene(Stage stage, Connection conn) {
        User user = null;

        GridPane login = new GridPane();

        login.setAlignment(Pos.CENTER);
        login.setHgap(10);
        login.setVgap(10);
        login.setPadding(new Insets(25, 25, 25, 25));

        Label userNameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        TextField userNameField = new TextField();
        TextField passwordField = new PasswordField();

        Button loginUser = new Button("Login");
        Button registerUser = new Button("Register new account");

        Text errorText = new Text("");

        login.addRow(0, userNameLabel, userNameField);
        login.addRow(2, passwordLabel, passwordField);
        login.addRow(4, loginUser);
        login.addRow(6, registerUser);
        login.addRow(8, errorText);

        loginUser.setOnAction(e -> {
            String getUserName = Login.loginUser(userNameField.getText(), passwordField.getText(), conn);

            if (getUserName.contains("incorrect")) {
                errorText.setText("getUserName");
            } else {
                login(getUserName, user, stage, conn);
            }
        });

        registerUser.setOnAction(e -> {
            Registration_Scene.createRegistrationScene(stage, conn);
        });

        Scene loginScene = new Scene(login, 700, 700);
        return loginScene;

    }


    public static void login(String uname, User user, Stage pStage, Connection conn) {
        user = new User(uname);
        pStage.setScene(Thread_List_Scene.createThreadListScene(user, pStage, conn));
    }

}
