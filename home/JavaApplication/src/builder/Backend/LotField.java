package builder.Backend;

/**
 * Field type for Lot. Will do all calculations pertaining to a lot field.
 *
 * @author Owner Edd1e234
 * @Version 1.0
 * @since 2019-8-13
 */

import builder.client.containers.LotContainer;
import builder.util.Status;
import builder.util.StatusMessage;

public class LotField {

    // General size of the lot.
    public enum Size {
        LARGE, MEDIUM, SMALL, SUPER_LARGE, SUPER_SMALL
    }
    Size Size;
    private int sqf;
    private String fieldName;
    private final double fieldID = Math.random();
    private double sqfPrice, sqfTotalPrice, superSmall,  small, medium, large, superLarge;

    // The amount of money the lot would cost.
    private double lotPrice;

    /**
     * TODO(Edd1e234): Fill this out.
     * @param container /...
     */
    public LotField(LotContainer container) {
        fieldName = container.getType();
        sqfPrice = Double.parseDouble(container.getSqfPrice());
        superSmall = Double.parseDouble(container.getSuperSmall());
        small = Double.parseDouble(container.getSmall());
        medium = Double.parseDouble(container.getMedium());
        large = Double.parseDouble(container.getLarge());
        superLarge = Double.parseDouble(container.getSuperLarge());
    }

    // Default Constructor.
    public LotField() {
        fieldName = "Basic";
    }

    // Adding a new field. The field name is meant to be as a placeholder.
    public LotField(String fieldName, int index) {
        this.fieldName = fieldName + index;
    }

    // Main Constructor.
    public LotField(String fieldName) {
        this.fieldName = fieldName;
    }

    // Used to reset fieldName, field name should be set upon initialization.
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Meant as a util function, will set a default value to map when using either 'SuperSmall',
     * 'Small', 'medium', etc...
     *
     * @param size  Which size is the user is specifying, can be any of them.
     * @param price The price this user plans to use.
     * @return Will return true if the new price has been set, else will return false if the string
     * value did not match. This is also true if price is a negative number.
     */
    public Status setSizePrice(String size, int price) {
        Status status = LotUtil.valueCheck(price);
        if (!status.isOk()) {
            return status;
        }
        if (size.equalsIgnoreCase("super small") ||
                size.equalsIgnoreCase("super-small")) {
            this.superSmall = price;
        } else if (size.equalsIgnoreCase("small")) {
            this.small = price;
        } else if (size.equalsIgnoreCase("medium")) {
            this.medium = price;
        } else if (size.equalsIgnoreCase("large")) {
            this.large = price;
        } else if (size.equalsIgnoreCase("super large") ||
                size.equalsIgnoreCase("super-large")) {
            this.superLarge = price;
        } else {
            return StatusMessage.InvalidArgumentError("Not a valid string");
        }
        return status;
    }

    /**
     * Meant as a util function, will set a default value to map when using either 'SuperSmall',
     * 'Small', 'medium', etc...
     *
     * @param size  Which size is the user is specifying, can be any of them.
     * @param price The price this user plans to use.
     * @return Will return true if the new price has been set, else will return false if the string
     * value did not match. This is also true if price is a negative number.
     */
    public Status setSizePrice(Size size, int price) {
        return setSizePrice(LotUtil.stringToSize(size), price);
    }

    /**
     * Sets sqf.
     *
     * @param sqf Desired Sqf.
     * @return Status.
     */
    public Status setSqf(int sqf) {
        Status status = LotUtil.valueCheck(sqf);
        if (!status.isOk()) {
            return status;
        }
        this.sqf = sqf;
        return status;
    }

    /**
     * Will set price of sqf.
     *
     * @param price the actual price.
     * @return Status.
     */
    public Status setSqfPrice(double price) {
        Status status = LotUtil.valueCheck(price);
        if (!status.isOk()) {
            this.sqfPrice = price;
        }
        return status;
    }

    public int getSqf() {
        return sqf;
    }

    public double getSqfPrice() {
        return sqfPrice;
    }

    /**
     * Gets the desired price.
     *
     * @param size based of class enum, desired size.
     * @return
     */
    public double getSizePrice(Size size) {
        return getSizePrice(LotUtil.stringToSize(size));
    }

    /**
     * Gets the desired price of the given price.
     *
     * @param size the desired price.
     * @return the price.
     */
    public double getSizePrice(String size) {
        if (size.equalsIgnoreCase("super small") ||
                size.equalsIgnoreCase("super-small")) {
            return superSmall;
        }
        if (size.equalsIgnoreCase("small")) {
            return small;
        }
        if (size.equalsIgnoreCase("medium")) {
            return medium;
        }
        if (size.equalsIgnoreCase("large")) {
            return large;
        }
        if (size.equalsIgnoreCase("super Large") ||
                size.equalsIgnoreCase("super-large")) {
            return superLarge;
        } else {
            System.out.println("Incorrect input");
            return 0;
        }
    }

    /**
     * @return Field ID.
     */
    public double getFieldID() {
        return fieldID;
    }

    /**
     * @return FieldName of class.
     */
    public String getFieldName() {
        return fieldName;
    }

    public void write() {
        System.out.println("This Works");
    }

    public String toString() {
        return "Field Name: " + fieldName + "\n" + "ID: " + fieldID + "\n" + "SQF: " + sqf + "\n" + "SQF Price: " +
                sqfTotalPrice + "\n" + "Price per SQF: " + sqfPrice + "\n" + "Super Small: " + superSmall + "\n" +
                "Small: " + small + "\n" + "Medium: " + medium + "\n" + "Large: " + large + "\n" +
                "Super Large: " + superLarge + "\nNote: If some values are 0 then it may have not been" +
                " initialized.\n";
    }

    /**
     * TODO(Edd1e234): Look into refactoring this function to use StatusOr<Int>.
     * <p>
     * Functions below all do the same thing. Each will use result as an output parameter. 'result'
     * contains the full price.
     *
     * @param result
     * @return
     */
    public double getFullLotPrice() {
        if (sqf != 0 && sqfPrice != 0) {
            sqfTotalPrice = ((double) sqf) * sqfPrice;
            return sqfTotalPrice;
        }
        return 0;
    }

    public double getFullLotPrice(int sqf) {
        Status status = setSqf(sqf);
        return getFullLotPrice();
    }

    /**
     * REfactor this, Java doesn't like output parameters.
     * @param size
     * @param result
     * @return
     */
    public Status getFullLotPrice(String size, double result) {
        double sizePrice = getSizePrice(size);
        Status status = LotUtil.valueCheck(sizePrice);

        if (!status.isOk()) {
            return status;
        }
        result = sizePrice;
        return status;
    }
}
