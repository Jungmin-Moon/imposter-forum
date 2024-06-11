package scenes;

import javafx.stage.Stage;
import java.sql.Connection;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Registration_Scene {
    public static void createRegistrationScene(Stage stage, Connection conn) {

        Label username = new Label("Username:");
        Label password = new Label("Password:");
        Label passwordAgain = new Label("Enter your password again:");
        Label email = new Label("Enter your email:");

        Text resultText = new Text();

        TextField usernameText = new TextField();
        TextField passwordText = new PasswordField();
        TextField passwordAgainText = new PasswordField();
        TextField emailText = new TextField();

        Button registerNewUser = new Button("Register");
        Button goBack = new Button("Back to Login");

        goBack.setOnAction(e -> Login_Scene.createLoginScene(stage, conn));

        registerNewUser.setOnAction(e -> {

        });
    }
}
