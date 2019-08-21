package builder.client.estimate;

import builder.Backend.LotField;
import builder.client.DataWrapper;
import builder.client.containers.LotContainer;
import builder.client.menu.Menu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Estimate implements Initializable {
    private DataWrapper dataWrapper;

    // Lot variables.
    @FXML private TableView<LotContainer> lotTableView = new TableView<>();
    @FXML private TableColumn<LotContainer, String> typeCol, superSmallCol, smallCol, mediumCol,
                                                    largeCol, superLargeCol, sqfPrice;
    @FXML private TextField typeField, superSmallField, smallField, mediumField, largeField,
                            superLargeField, sqfPriceField;
    @FXML public Button addLotField, saveLotFields;


    /**
     * TODO(Edd1e234): Please fill this out.
     * @param location ...
     * @param resources ...
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.print("Initializing....");
    }

    public void backButton(ActionEvent event) {
        System.out.println("Going back");

        FXMLLoader loader = new FXMLLoader(Menu.class.getResource("menu.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            // TODO(Edd1e234): Error message.
        }

        Menu menu = loader.getController();
        menu.setData(this.dataWrapper);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

    /**
     * TODO(Edd1e234): Fix the table height bug, make it more dynamic.
     *TODO(Edd1e234): Fill these comments out.
     * There should also be another method that handles checks, makes sure the type is correct.
     * Once more fields are added make a handler function that will do all of this.
     * @return Status.
     */
    public void initializeLot() {
        System.out.println("Building Table");
        lotTableView.setEditable(true);

        // Setting columns.
        typeCol.setCellValueFactory(new PropertyValueFactory<LotContainer, String>("type"));
        superSmallCol.setCellValueFactory(
                new PropertyValueFactory<LotContainer, String>("superSmall"));
        smallCol.setCellValueFactory(new PropertyValueFactory<LotContainer, String>("small"));
        mediumCol.setCellValueFactory(new PropertyValueFactory<LotContainer, String>("medium"));
        largeCol.setCellValueFactory(new PropertyValueFactory<LotContainer, String>("large"));
        superLargeCol.setCellValueFactory(
                new PropertyValueFactory<LotContainer, String>("superLarge"));
        sqfPrice.setCellValueFactory(new PropertyValueFactory<LotContainer, String>("sqfPrice"));

        // Setting data.
        lotTableView.setItems(getLotFields());

        // Setting textfield.
        typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        superSmallCol.setCellFactory(TextFieldTableCell.forTableColumn());
        smallCol.setCellFactory(TextFieldTableCell.forTableColumn());
        mediumCol.setCellFactory(TextFieldTableCell.forTableColumn());
        largeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        superLargeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        sqfPrice.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    /**
     * TODO(Edd1e234): Fill these out.
     * @return ...
     */
    private ObservableList<LotContainer> getLotFields() {
        ObservableList<LotContainer> lotContainers = FXCollections.observableArrayList();

        // Basic if the user has no data.
        if (dataWrapper.getUserData().getEstimate().getLot().getLotFields().size() == 0 ) {

            lotContainers.add(new LotContainer(
                    "Basic", "50", "50", "50", "50",
                    "50", "50"));
            return lotContainers;
        }
        for (LotField field : dataWrapper.getUserData().getEstimate().getLot().getLotFields()) {
            lotContainers.add(new LotContainer(field));
        }
        return lotContainers;
    }

    /**
     * Will add lot field to the lot table.
     */
    public void addLotField() {
        LotContainer lotContainer = new LotContainer(
                typeField.getText(), superSmallField.getText(), smallField.getText(),
                mediumField.getText(), largeField.getText(), superLargeField.getText(),
                sqfPriceField.getText());
        lotTableView.getItems().add(lotContainer);
    }

    /**
     * Will Save table to users profile.
     */
    public void saveLotFields() {
        dataWrapper.getUserData().getEstimate().getLot().clearFields();
        // Saves data.
        for (LotContainer containers: lotTableView.getItems()) {
            // Saves lot fields.
            dataWrapper.getUserData().getEstimate().getLot().addField(new LotField(containers));
        }
    }

    /**
     * TODO(Edd1e234): Fill this out.
     * @param dataWrapper ...
     */
    public void saveData(DataWrapper dataWrapper) {
        this.dataWrapper = dataWrapper;
    }
}
