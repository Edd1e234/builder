package builder.client;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import builder.client.login.SignIn;
import javafx.application.Application;
import javafx.stage.Stage;

public class FX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        IconData iconData = new IconData();
        IconDataUtil iconDataUtil = new IconDataUtil();
        DataWrapper dataWrapper = new DataWrapper(stage, iconData, iconDataUtil);
        dataWrapper.setWindow(stage);

        // This object contains sign in page.
        SignIn signIn = new SignIn();
        dataWrapper.getWindow().setScene(signIn.displayLogin(dataWrapper));
        dataWrapper.getWindow().show();
    }
}
