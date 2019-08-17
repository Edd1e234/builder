package estimate.builder.frontend.estimates;

import estimate.builder.frontend.DataWrapper;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class EstimatePage {
    public static Scene displayEstimatePage(DataWrapper window) {
        window.getWindow().setTitle("Set Estimate");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(4);
        gridPane.setVgap(4);
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(5, 25, 25, 25));

        ArrayList<Label> labels = new ArrayList<>();

        labels.add(new Label("Lot"));
        GridPane.setConstraints(labels.get(0), 1, 1);

        labels.add(new Label("Type"));
        GridPane.setConstraints(labels.get(1), 2, 2);



        gridPane.getChildren().addAll(labels);
        return new Scene(gridPane, 800, 800);
    }
}
