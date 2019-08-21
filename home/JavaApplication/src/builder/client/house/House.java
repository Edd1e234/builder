package builder.client.house;

import builder.Backend.LotField;
import builder.client.DataWrapper;
import builder.client.menu.Menu;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class House {
    @FXML private TextField fullPriceTextField;
    private DataWrapper dataWrapper;

    // Global fields.
    private ArrayList<TextField> prices = new ArrayList<>();

    // Lot fields.
    @FXML private TextField sqfTextField, lotPriceTextField;
    @FXML private ComboBox<String> lotFieldComboBox, lotSizeComboBox;

    public void saveData(DataWrapper dataWrapper) {
        this.dataWrapper = dataWrapper;
    }

    /**
     * Fill this out.
     */
    public void loadData() {
        Status status = loadLotData();

        if (status.isOk()) {
            System.out.print("Data loaded...");
        }
    }

    /**
     * Fill this out.
     * @return ...
     */
    private Status loadLotData() {
        sqfTextField.setText("");
        prices.add(lotPriceTextField);
        ObservableList<String> list = FXCollections.observableArrayList();

        for(LotField field : dataWrapper.getUserData().getEstimate().getLot().getLotFields()) {
            list.add(field.getFieldName());
        }

        lotFieldComboBox.getItems().addAll(list);

        // Filling out size combo box.
        lotSizeComboBox.getItems().add("Super-Small");
        lotSizeComboBox.getItems().add("Small");
        lotSizeComboBox.getItems().add("Medium");
        lotSizeComboBox.getItems().add("Large");
        lotSizeComboBox.getItems().add("Super-Large");
        return StatusMessage.okStatus();
    }

    // Prints out the value of lotSizeComboBox.
    public void lotSizeComboBoxAction() {
        System.out.println(lotSizeComboBox.getValue());
    }

    // Prints out the value of lotFieldComboBox.
    public void lotFieldComboBoxAction() {
        System.out.println("\n"+lotFieldComboBox.getValue());
    }

    /**
     * Fill this out...
     */
    public void setLotButtonAction() {
        // Gets the field....
        LotField field = dataWrapper.getUserData().getEstimate().getLot().getField(
                lotFieldComboBox.getValue());

        System.out.println("Field Selected is: " + field.toString());
        String price = "";
            if (!sqfTextField.getText().equalsIgnoreCase("")) {
                System.out.println("Setting sqf price...");
                try {
                    price = Double.toString(
                            field.getFullLotPrice(Integer.parseInt(sqfTextField.getText())));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Argument Error: " + sqfTextField.getText());
                }
            } else {
                System.out.println("Setting size price...");
                price = Double.toString(field.getSizePrice(lotSizeComboBox.getValue()));
            }
            lotPriceTextField.setText(price);
            calculateTotalPrice();
    }

    /**
     * Fill this out...
     */
    private void calculateTotalPrice() {
        double fullPrice = 0;
        for (TextField textField : prices) {
            fullPrice += Double.parseDouble(textField.getText());
        }
        fullPriceTextField.setText(Double.toString(fullPrice));
    }

    /**
     * Fill this out...
     * Goes back to menu.
     * @param event ...
     */
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
