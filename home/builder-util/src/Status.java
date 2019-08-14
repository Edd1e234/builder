public class Status {
    private  String message = "";
    private  boolean status = true;

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public  boolean isok () {
        return status;
    }
    public  String getMessage() {
        return message;
    }
}

