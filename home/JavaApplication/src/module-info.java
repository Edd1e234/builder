module JavaApplication {
    requires javafx.fxml;
    requires javafx.controls;
    opens builder.client;
    opens builder.client.menu;
    opens builder.client.estimate;
    opens builder.client.containers;
    opens builder.client.house;
}