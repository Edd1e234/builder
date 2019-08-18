package builder.Backend;

import builder.util.Status;
import builder.util.StatusMessage;

public class LotUtil {
    /**
     * Converts LotField enum 'Size' to string.
     *
     * @param size Desired Size to be converted.
     * @return String of desired size.
     */
    public static String stringToSize(LotField.Size size) {
        switch (size) {
            case SUPER_SMALL:
                return "Super Small";
            case SMALL:
                return "Small";
            case MEDIUM:
                return "Medium";
            case LARGE:
                return "Large";
            case SUPER_LARGE:
                return "Super Large";
            default:
                return "Not Found";
        }
    }

    /**
     * Checks if the price is valid.
     *
     * @param price given price. Most cases this will be a price.
     * @return Status of the message.
     */
    public static Status valueCheck(double price) {
        if (price < 0) {
            return StatusMessage.InvalidArgumentError("Price is negative.");
        }
        if (price == 0) {
            return StatusMessage.InvalidArgumentError("Price is 0.");
        }
        return StatusMessage.okStatus();
    }

    /**
     * Checks if the int is valid.
     *
     * @param value given price.
     * @return Status of the message.
     */
    public static Status valueCheck(int value) {
        if (value < 0) {
            return StatusMessage.InvalidArgumentError("Value is negative.");
        }
        if (value == 0) {
            return StatusMessage.InvalidArgumentError("Value is 0.");
        }
        return StatusMessage.okStatus();
    }
}
