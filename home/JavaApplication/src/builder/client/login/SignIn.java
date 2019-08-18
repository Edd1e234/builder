package builder.client.login;

import builder.Backend.data.IconData;
import builder.client.DataWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {
    private DataWrapper window;
    @FXML
    private TextField username, password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Sign In Page");
    }

    private void setWindow(DataWrapper window) {
        this.window = window;
    }

    public Scene displayLogin(DataWrapper window) throws IOException {
        // Setting up the page.
        window.getWindow().setTitle("Login");
        window.setRoot(FXMLLoader.load(getClass().getResource("signIn.fxml")));

        // Copies over the data.
        setWindow(window);
        System.out.println("Load page");
        System.out.println(window.getAllData().toString());
        System.out.println(this.window.getAllData().toString());
        return new Scene(this.window.getRoot());
    }

    public void loginButton() {
        System.out.println(username.getText());
        System.out.println(password.getText());
        System.out.println("Login");

        IconData userData = new IconData();
        System.out.println("ERROR HERE");
        System.out.println(this.window.getAllData().toString());
        System.out.println("ERROR HERE");
//        if (this.window.getAllData()
//                .getUserData(username.getText(), password.getText(), userData).isOk()) {
//            System.out.print("User Approved");
//        } else {
//            System.out.print("User Denied");
//        }
    }

    public void signUpButton() {
        System.out.println("Sign Up");
    }

}
