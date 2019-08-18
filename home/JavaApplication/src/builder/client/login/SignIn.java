package builder.client.login;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import builder.client.DataWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {
    private DataWrapper window;
    @FXML
    private TextField username, password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IconData iconData = new IconData();
        IconDataUtil iconDataUtil = new IconDataUtil();
        iconDataUtil.setEddieData(iconData);
        window = new DataWrapper(iconData, iconDataUtil);
    }

    public void loginButton() {

        System.out.println(username.getText());
        System.out.println(password.getText());
        System.out.println("Login");

        IconData userData = new IconData();
        System.out.println("ERROR HERE");
        System.out.println(window);
        System.out.println("ERROR HERE");
        if (window.getAllData()
                .getUserData(username.getText(), password.getText(), userData).isOk()) {
            System.out.print("User Approved");
        } else {
            System.out.print("User Denied");
        }
    }

    public void signUpButton(ActionEvent event) throws IOException {
        Parent signUpPage = FXMLLoader.load(getClass().getResource("signUp.fxml"));

        Stage signUpWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        signUpWindow.setScene(new Scene(signUpPage));

        signUpWindow.show();
    }
}
