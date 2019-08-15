package estimate.builder.frontend.scenes;


import estimate.builder.util.Status;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignIn {

    static Scene getSignInPage(Stage window) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label nameLabel = new Label("UserName:");
        GridPane.setConstraints(nameLabel, 0, 0);

        // Name Input.
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        // Password Input.
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Login");

        loginButton.setOnAction(actionEvent -> {
            // Credentials here.
            System.out.println("Input is " + passInput.getText());
            if (true) {
                window.setScene(Menu.getMenu(window));
            }
        });

        GridPane.setConstraints(loginButton, 1, 2);

        gridPane.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
        // Actual Scene.
        return new Scene(gridPane, 300, 200);
    }
}
