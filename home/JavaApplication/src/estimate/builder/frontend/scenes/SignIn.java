package estimate.builder.frontend.scenes;


import estimate.builder.Backend.data.IconData;
import estimate.builder.Backend.data.IconDataUtil;
import estimate.builder.util.Status;
import estimate.builder.util.StatusMessage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

class SignIn {

     static Scene displaySignIn(DataWrapper window) {
         window.getWindow().setTitle("Sign In");
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
            IconData userData = new IconData();
            if (window.getAllData().getData(nameInput.getText(), passInput.getText(), userData).isOk()) {
                System.out.println(userData.getFirstName());
                window.getWindow().setScene(Menu.displayMenu(window));
            } else {
                System.out.println("Try Again");
            }
        });

        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(actionEvent -> {
            System.out.println("Sign in page");

            window.getWindow().setScene(SignUp.displaySignUp(window));
        });

        GridPane.setConstraints(loginButton, 1, 2);

        gridPane.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);
        // Actual Scene.
        return new Scene(gridPane, 300, 200);
    }

//    private static Status Validate(String username, String password, IconData userData) {
//         return IconDataUtil.getData(username, password, userData);
//     }
}
