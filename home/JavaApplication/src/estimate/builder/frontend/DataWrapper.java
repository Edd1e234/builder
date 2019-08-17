package estimate.builder.frontend;

import estimate.builder.Backend.data.IconData;
import estimate.builder.Backend.data.IconDataUtil;
import javafx.stage.Stage;

public class DataWrapper {
    private Stage window;
    private IconData userData;
    // This cannot be in production.
    private IconDataUtil allData;

    public DataWrapper(Stage window, IconData userData, IconDataUtil allData) {
        this.window = window;
        this.userData = userData;
        this.allData = allData;
    }

    public IconData getUserData() {
        return userData;
    }

    public void setUserData(IconData userData) {
        this.userData = userData;
    }

    public IconDataUtil getAllData() {
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
