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
import sqlfiles.Registration;

public class Registration_Scene {
    public static void createRegistrationScene(Stage stage, Connection conn) {

        GridPane registration = new GridPane();
        registration.setAlignment(Pos.CENTER);
        registration.setHgap(10);
        registration.setVgap(10);
        registration.setPadding(new Insets(25, 25, 25, 25));

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

        registration.addRow(0, username, usernameText);
        registration.addRow(2, password, passwordText);
        registration.addRow(4, passwordAgain, passwordAgainText);
        registration.addRow(6, email, emailText);
        registration.addRow(8, registerNewUser, goBack);

        goBack.setOnAction(e -> Login_Scene.createLoginScene(stage, conn));

        registerNewUser.setOnAction(e -> {
            if (passwordText.getText().equalsIgnoreCase(passwordAgainText.getText()))
                resultText.setText(Registration.registerUser(usernameText.getText(), passwordText.getText(), emailText.getText(), conn));
            else {
                resultText.setText("The passwords do not match.");
            }
        });
    }
}
