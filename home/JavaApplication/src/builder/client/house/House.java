package builder.client.house;

import builder.Backend.LotField;
import builder.client.DataWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class House {

    // Lot fields.
    @FXML TextField sqfTextField;
    @FXML private ComboBox<String> lotFiledComboBox, lotSizeComboBox;
    private DataWrapper dataWrapper;

    public void saveData(DataWrapper dataWrapper) {
        this.dataWrapper = dataWrapper;
    }

    public void loadData() {
        ObservableList<String> list = FXCollections.observableArrayList();

        for(LotField field : dataWrapper.getUserData().getEstimate().getLot().getLotFields()) {
            list.add(field.getFieldName());
        }

        lotFiledComboBox.getItems().addAll(list);

        // Filling out size combo box.
        lotSizeComboBox.getItems().add("Super-Small");
        lotSizeComboBox.getItems().add("Small");
        lotSizeComboBox.getItems().add("Medium");
        lotSizeComboBox.getItems().add("Large");
        lotSizeComboBox.getItems().add("Super-Large");
    }

    public void menu(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("menu.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            // Do something.
        }

        builder.client.menu.Menu menu = loader.getController();
        menu.setData(this.dataWrapper);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }
}
