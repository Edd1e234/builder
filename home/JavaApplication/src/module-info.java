module JavaApplication {
    requires javafx.fxml;
    requires javafx.controls;
    opens builder.client;
    opens builder.client.login;
}