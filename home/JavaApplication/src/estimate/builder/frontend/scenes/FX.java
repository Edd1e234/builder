package estimate.builder.frontend.scenes;


import estimate.builder.Backend.data.IconData;
import estimate.builder.Backend.data.IconDataUtil;
import javafx.application.Application;
import javafx.stage.Stage;

public class FX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This where the function runs.
     * @param stage Window.
     * @throws Exception Not really sure what this is for.
     */
    @Override
    public void start(Stage stage) throws Exception {
        IconData iconData = new IconData();
        IconDataUtil iconDataUtil = new IconDataUtil();
        DataWrapper dataWrapper = new DataWrapper(stage, iconData, iconDataUtil);
        stage.setScene(SignIn.displaySignIn(dataWrapper));
        stage.show();
    }
}
