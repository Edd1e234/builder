package builder.client.menu;

import builder.client.DataWrapper;
import builder.client.estimate.Estimate;
import builder.client.house.House;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    private DataWrapper dataWrapper;


    public Status setData(DataWrapper dataWrapper) {
        this.dataWrapper = dataWrapper;
        return StatusMessage.okStatus();
    }

    /**
     * Fill this out.
     * @param event ...
     */
    public void house(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(House.class.getResource("house.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Loader failed to load");
            // TODO(Edd1e234): Theres nothing stopping me.
        }
        House house = loader.getController();
        house.saveData(this.dataWrapper);
        house.loadData();

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }

    public void estimate(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(Estimate.class.getResource("estimate.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            // TODO(Edd1e234): Add an error code here.
        }
        Estimate estimate = loader.getController();
        estimate.saveData(this.dataWrapper);
        estimate.initializeLot();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }
}
