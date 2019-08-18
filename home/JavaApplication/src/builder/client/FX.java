package builder.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Main page.
    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Main Works");
        Parent root = FXMLLoader.load(getClass().getResource("login/signIn.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
