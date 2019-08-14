/**
 * Messages for status, if desired operation is successful then Return OkStatus .
 *
 * @author Owner Edd1e234
 * @Version 1.0
 * @since 2019-8-14
 */
public class StatusMessage {

    // If desired operation worked then this would be used as the message.
    public static Status okStatus() {
        Status status = new Status();
        status.setMessage("All Good");
        status.setStatus(true);

        return status;
    }

    /**
     * Status message if the desired operation failed, like value not found.
     * @return Status message.
     */
    public static Status NotFoundError() {
        return NotFoundError("Not found");
    }

    /**
     * Status message if the desired operation failed, like value not found.
     * @param message specific message.
     * @return Status message.
     */
    public static Status NotFoundError(String message) {
        Status status = new Status();
        status.setStatus(false);
        status.setMessage(message);

        return status;
    }
    public static Status InvalidArgumentError() {
        return InvalidArgumentError("Invalid Argument");
    }
    public static Status InvalidArgumentError(String message) {
        Status status = new Status();
        status.setStatus(false);
        status.setMessage(message);
        return status;
    }
}
