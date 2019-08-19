package builder.client;

import builder.Backend.data.IconData;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    private DataWrapper window;

    @FXML
    TextField first, last, username, password, email;
    void setData(DataWrapper window) {
        this.window = window;
    }

    public void signUp(ActionEvent event) {
        Status status = saveData();
        if (status.isOk()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signIn.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                // TODO(Edd1e234) Error message, CRITICAL ERROR.
            }

            SignIn signIn = loader.getController();

            //TODO(Edd1e234): Once database is going this needs to change. Or make it part of the
            // same window so the data is updated in real time.
            // Setting new data.
            Status signInStatus = signIn.saveData(this.window);

            // Using the same scene.
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(loader.getRoot()));
            stage.show();
        } else {
            System.out.println(status.getMessage());
        }
        // TODO(Edd1e234): Need to set up a label that sends an error message.
    }

    private Status saveData() {
        IconData iconData = new IconData();
        try {
            iconData.setFirstName(first.getText());
        } catch (Exception e) {
            return StatusMessage.InvalidArgumentError("First name is invalid");
        }
        try {
            iconData.setLastName(last.getText());
        } catch (Exception e) {
            return StatusMessage.InvalidArgumentError("Last name is invalid");
        }
        try {
            iconData.setEmail(email.getText());
        } catch (Exception e) {
            return StatusMessage.InvalidArgumentError("Email is invalid");
        }
        try {
            iconData.setUsername(username.getText());
        } catch (Exception e) {
            return StatusMessage.InvalidArgumentError("Username is invalid");
        }
        try {
            iconData.setPassword(password.getText());
        } catch (Exception e ) {
            return StatusMessage.InvalidArgumentError("Password is invalid");
        }

        window.getAllData().addUser(iconData);
        System.out.println("Data saved");
        return StatusMessage.okStatus();
    }
}
