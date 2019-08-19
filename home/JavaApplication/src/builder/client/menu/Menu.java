package builder.client.menu;

import builder.client.DataWrapper;
import builder.client.menu.estimate.Estimate;
import builder.util.Status;
import builder.util.StatusMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {
    private DataWrapper dataWrapper;


    public Status setData(DataWrapper dataWrapper) {
        this.dataWrapper = dataWrapper;
        return StatusMessage.okStatus();
    }

    public void estimate(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("estimate/estimate.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            // TODO(Edd1e234): Add an error code here.
        }

        Estimate estimate = loader.getController();
        estimate.saveData(this.dataWrapper);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(loader.getRoot()));
        stage.show();
    }
}
