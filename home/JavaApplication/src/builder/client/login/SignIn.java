package builder.client.login;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import builder.client.DataWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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

    public void signUpButton() {
        System.out.println("Sign Up");
        System.out.println(window);
    }
}
