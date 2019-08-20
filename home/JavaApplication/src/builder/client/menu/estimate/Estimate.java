package builder.client.menu.estimate;

import builder.client.DataWrapper;
import builder.client.containers.LotContainer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Estimate implements Initializable {
    private DataWrapper dataWrapper;
    @FXML
    AnchorPane lotAnchorPane;
    @FXML TableView<LotContainer> lotTableView = new TableView<>();
    @FXML private TableColumn<LotContainer, String> typeCol, superSmallCol, smallCol, mediumCol, largeCol, superLargeCol;

    /**
     * TODO(Edd1e234): Please fill this out.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

        ObservableList<LotContainer> list = getTextFields();
        lotTableView.setItems(list);

        System.out.print("\nCell height is: " + lotTableView.getFixedCellSize());
        lotTableView.setPrefHeight(lotTableView.getFixedCellSize());
        System.out.println("LotTableView PrefHeight  is " + lotTableView.getPrefHeight());
        lotAnchorPane.setPrefHeight(lotTableView.getPrefHeight());
    }

    public ObservableList<LotContainer> getTextFields() {
        ObservableList<LotContainer> fields = FXCollections.observableArrayList();
        fields.add(new LotContainer("Basic", "50", "50", "50",
                                        "50", "50", "50"));
        fields.add(new LotContainer("Basic", "50", "50", "50",
                "50", "50", "50"));
        fields.add(new LotContainer("Basic", "50", "50", "50",
                "50", "50", "50"));
        fields.add(new LotContainer("Basic", "50", "50", "50",
                "50", "50", "50"));
        return fields;
    }

    public void saveData(DataWrapper dataWrapper) {
        this.dataWrapper = dataWrapper;
    }
}
