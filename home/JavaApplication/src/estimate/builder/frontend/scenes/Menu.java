package estimate.builder.frontend.scenes;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class Menu {
    static Scene getMenu(Stage window) {

        // Buttons used for Main Menu.
        Button backButton = new Button("Back");
        Button estimate = new Button("New Button");
        estimate.setOnAction(actionEvent -> {
            System.out.print("Estimate but clicked");
        });
        Button house = new Button("Build House");
        house.setOnAction(actionEvent -> {
            System.out.print("House button clicked");
            window.close();
        });

        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(estimate, house);
        Scene menuScene = new Scene(menuLayout, 200, 200);
        return menuScene;
    }
}
