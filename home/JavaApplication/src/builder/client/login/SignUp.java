package builder.client.login;

import builder.Backend.data.IconData;
import builder.client.DataWrapper;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

    public void signUp() throws IOException {
        if (saveData().isOk()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signIn.fxml"));

            loader.load();

            Parent root = loader.getRoot();
            Stage stage = new Stage();

            stage.setScene(new Scene(root));
            stage.show();
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
