package estimate.builder.util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Status {
    private  String message = "";
    private  boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public  boolean isOk () {
        return status;
    }
    public  String getMessage() {
        return message;
    }
}