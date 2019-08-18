package builder.frontend;


import builder.client.DataWrapper;
import builder.frontend.estimates.EstimatePage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class Menu {
    static Scene displayMenu(DataWrapper window) {
        window.getWindow().setTitle("Menu");
        // Buttons used for Main Menu.
        Button backButton = new Button("Back");
        backButton.setOnAction(actionEvent -> window.getWindow().setScene(SignIn.displaySignIn(window)));
        backButton.setAlignment(Pos.TOP_LEFT);

        Button estimate = new Button("Set Estimate");
        estimate.setOnAction(actionEvent -> {
            System.out.print("Estimate button clicked");

            // New page.
            EstimatePage estimatePage = new EstimatePage();
            window.getWindow().setScene(estimatePage.displayEstimatePage(window));
        });
        estimate.setAlignment(Pos.CENTER);
        Button house = new Button("Build House");
        house.setOnAction(actionEvent -> {
            System.out.print("House button clicked");
            window.getWindow().close();
        });
        house.setAlignment(Pos.CENTER);


        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(estimate, house, backButton);
        return new Scene(menuLayout, 600, 600);
    }
}
