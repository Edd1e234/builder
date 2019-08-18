package builder.frontend;

import builder.Backend.data.IconData;
import builder.client.DataWrapper;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class SignUp {
    static Scene displaySignUp(DataWrapper window) {
        window.getWindow().setTitle("Sign Up");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setPadding(new Insets(5, 25, 25, 25));

        // Label list, more readable.
        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();

        labels.add(new Label("First Name: "));
        GridPane.setConstraints(labels.get(0), 1, 1);

        textFields.add(new TextField());
        textFields.get(0).prefWidth(15);
        GridPane.setConstraints(textFields.get(0), 2, 1);

        labels.add(new Label("Last Name: "));
        GridPane.setConstraints(labels.get(1), 1, 2);

        textFields.add(new TextField());
        textFields.get(1).prefWidth(15);
        GridPane.setConstraints(textFields.get(1), 2, 2);

        labels.add(new Label("Email: "));
        GridPane.setConstraints(labels.get(2), 1, 3);

        textFields.add(new TextField());
        textFields.get(2).prefWidth(15);
        GridPane.setConstraints(textFields.get(2), 2, 3);

        labels.add(new Label("UserName: "));
        GridPane.setConstraints(labels.get(3), 1, 4);

        textFields.add(new TextField());
        textFields.get(3).prefWidth(15);
        GridPane.setConstraints(textFields.get(3), 2, 4);

        labels.add(new Label("Password: "));
        GridPane.setConstraints(labels.get(4), 1, 5);

        textFields.add(new TextField());
        textFields.get(4).prefWidth(15);
        GridPane.setConstraints(textFields.get(4), 2, 5);

        Button backButton = new Button("Back");
        backButton.setOnAction(actionEvent -> {
            window.getWindow().setScene(SignIn.displaySignIn(window));
        });

        Button saveButton = new Button("Save");
        saveButton.setOnAction(actionEvent -> {
            Status status = saveButton(window, textFields);

            if (status.isOk()) {
                window.getWindow().setScene(SignIn.displaySignIn(window));
            }
        });
        GridPane.setConstraints(backButton, 0, 0);
        GridPane.setConstraints(saveButton, 1, 6);
        gridPane.getChildren().addAll(labels);
        gridPane.getChildren().addAll(textFields);
        gridPane.getChildren().addAll(backButton, saveButton);

        return new Scene(gridPane, 600, 200);
    }

    /**
     * TODO(Edd1e234): Add additional checks here. This barely works. Making sure the same user does
     * not create duplicate accounts, passwords will be kept simple for now, make sure there is no
     * number in First or last name fields.
     * <p>
     * Creates the new account.
     *
     * @param window     Window contains the actual data.
     * @param textFields
     * @return
     */
    private static Status saveButton(DataWrapper window, ArrayList<TextField> textFields) {
        IconData newData = new IconData();

        newData.setFirstName(textFields.get(0).getText());
        newData.setLastName(textFields.get(1).getText());
        newData.setEmail(textFields.get(2).getText());
        newData.setUsername(textFields.get(3).getText());
        newData.setPassword(textFields.get(4).getText());

        window.getAllData().addUser(newData);
        System.out.println("Data has been saved at index " + window.getUserData().getIndex());
        System.out.println(window.getAllData().toString());
        return StatusMessage.okStatus();
    }
}
