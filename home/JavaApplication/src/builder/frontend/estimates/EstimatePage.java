package builder.frontend.estimates;

import builder.Backend.LotField;
import builder.client.DataWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class EstimatePage<Strings> {
    public Scene displayEstimatePage(DataWrapper window) {
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

        // Builds new combo box.
        ComboBox<String> comboBox = new ComboBox<>(lotComboBox(window));

        // Gets all children.
        gridPane.getChildren().addAll(labels);
        return new Scene(gridPane, 800, 800);
    }

    /**
     * TODO(Edd1e234) This would need to read from a database rather then window; however, window
     * can store reference to database.
     * <p>
     * Returns strings for Combo box.
     *
     * @param window Contains data.
     * @return List of strings containing field names for LotFields.
     */
    private ObservableList<String> lotComboBox(DataWrapper window) {
        ObservableList<String> fieldNames = FXCollections.observableArrayList();

        fieldNames.add("New Field");
        for (LotField fields : window.getUserData().getEstimate().getLot().getLotFields()) {
            fieldNames.add(fields.getFieldName());
        }
        return fieldNames;
    }
}
