package estimate.builder.frontend.scenes;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class Menu {
    static Scene displayMenu(DataWrapper window) {
        window.getWindow().setTitle("Menu");
        // Buttons used for Main Menu.
        Button backButton = new Button("Back");
        backButton.setOnAction(actionEvent -> window.getWindow().setScene(SignIn.displaySignIn(window)));
        Button estimate = new Button("New Button");
        estimate.setOnAction(actionEvent -> {
            System.out.print("Estimate but clicked");
        });
        Button house = new Button("Build House");
        house.setOnAction(actionEvent -> {
            System.out.print("House button clicked");
            window.getWindow().close();
        });

        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(estimate, house, backButton);
        return new Scene(menuLayout, 200, 200);
    }
}
