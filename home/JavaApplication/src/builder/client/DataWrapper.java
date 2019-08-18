package builder.client;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class DataWrapper {
    private Parent root;
    private Stage window;
    private IconData userData;
    // This cannot be in production.
    private IconDataUtil allData;

    public DataWrapper(Stage window, IconData userData, IconDataUtil allData) {
        this.window = window;
        this.userData = userData;
        this.allData = allData;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public IconData getUserData() {
        return userData;
    }

    public void setUserData(IconData userData) {
        this.userData = userData;
    }

    public IconDataUtil getAllData() {
        System.out.println("Got Into this method");
        return allData;
    }

    public void setAllData(IconDataUtil allData) {
        this.allData = allData;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }
}
