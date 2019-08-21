package builder.client;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // TODO(Edd1e234): Program should try to open database here.
        IconData iconData = new IconData();
        IconDataUtil iconDataUtil = new IconDataUtil();
        iconDataUtil.setEddieData(iconData);
        System.out.println("Made here");
        DataWrapper dataWrapper = new DataWrapper(iconData, iconDataUtil);

        FXMLLoader loader = new FXMLLoader(SignIn.class.getResource("signIn.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            // Do something here...
        }

        SignIn signIn = loader.getController();
        signIn.saveData(dataWrapper);

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }
}
