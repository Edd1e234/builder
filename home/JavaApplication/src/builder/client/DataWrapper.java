package builder.client;

import builder.Backend.data.IconData;
import builder.Backend.data.IconDataUtil;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class DataWrapper {
    private IconData userData;
    // This cannot be in production.
    private IconDataUtil allData;

    public DataWrapper() {}

    public DataWrapper(IconData userData, IconDataUtil allData) {
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
}
