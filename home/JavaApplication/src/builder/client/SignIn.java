package builder.client;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import builder.client.menu.Menu;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {
    // This window will contain all the data.
    private DataWrapper window;
    @FXML
    private TextField username, password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO(Edd1e234): Program should try to open database here.
        IconData iconData = new IconData();
        IconDataUtil iconDataUtil = new IconDataUtil();
        iconDataUtil.setEddieData(iconData);
        System.out.println("Made here");
        window = new DataWrapper(iconData, iconDataUtil);
    }

    public void loginButton(ActionEvent event) {
        System.out.println("Login");

        IconData userData = new IconData();

        if (window.getAllData()
                .getUserData(username.getText(), password.getText(), userData).isOk()) {
            System.out.print("User Approved\nUser data: ");
            System.out.print(window.getUserData().toString());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("menu/menu.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                // TODO(Edd1e234): Error message.
            }
            Menu menu = loader.getController();
            menu.setData(this.window);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(loader.getRoot()));
            stage.show();
        } else {
            System.out.print("User Denied");
        }
    }

    public void signUpButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("signUp.fxml"));

        loader.load();

        SignUp signUp = loader.getController();
        signUp.setData(window);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

    // TODO(Edd1e234): This needs
    public Status saveData(DataWrapper dataWrapper) {
        this.window = dataWrapper;
        return StatusMessage.okStatus();
    }
}
