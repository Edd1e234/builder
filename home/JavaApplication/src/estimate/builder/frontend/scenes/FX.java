package estimate.builder.frontend.scenes;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Button button1, button2;
    Scene primaryScene, scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        button1 = new Button("Got to to scene 2");
        button1.setOnAction(this);
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(button1);

        primaryScene = new Scene(layout1, 200, 200);

        button2 = new Button("This scene sucks");
        button2.setOnAction(actionEvent -> window.setScene(primaryScene));
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene = new Scene(layout2, 600, 300);

        System.out.println("Got here");

        window.setScene(SignIn.getSignInPage(window));
        window.setTitle("Title here");
        window.show();

    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button1) {
            window.setScene(scene);
        }
    }
}
