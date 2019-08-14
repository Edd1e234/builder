public class LotUtil {
    public static String StringToSize(LotField.Size size) {
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
}
