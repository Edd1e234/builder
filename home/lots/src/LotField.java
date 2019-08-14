/**
 * Field type for Lot.
 *
 * @author Owner Edd1e234
 * @Version 1.0
 * @since 2019-8-13
 */

import java.util.*;
import java.lang.*;

public class LotField {

    // General size of the lot.
    public enum Size {
        LARGE, MEDIUM, SMALL, SUPER_LARGE, SUPER_SMALL
    }
    Size Size;
    private String fieldName;
    private final double fieldID = Math.random();
    private int sqf;
    private int averageValuePerSqf;
    private int sqfPrice;
    private int superSmall;
    private int small;
    private int medium;
    private int large;
    private int superLarge;

    // The amount of money the lot would cost.
    private int ActualValue;

    // Default Constructor.
    public LotField () {
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

    /**
     * Meant as a util function, will set a default value to map when using either 'SuperSmall', 'Small',
     * 'medium', etc...
     * @param size Which size is the user is specifying, can be any of them.
     * @param price The price this user plans to use.
     * @return Will return true if the new price has been set, else will return false if the string
     * value did not match. This is also true if price is a negative number.
     */
    public Status setSizePrice(String size, int price) {
        if (price < 0) {
            return StatusMessage.InvalidArgumentError("Price is negative.");
        }
        if (price == 0) {
            return StatusMessage.InvalidArgumentError("Price cannot be 0.");
        }
        if (size.equalsIgnoreCase("super small")) {
            this.superSmall = price;

        } else if (size.equalsIgnoreCase("small")) {
            this.small = price;
        } else if (size.equalsIgnoreCase("medium")) {
            this.medium = price;
        } else if (size.equalsIgnoreCase("large")) {
            this.large = price;
        } else if (size.equalsIgnoreCase("super large")) {
            this.superLarge = price;
        }else {
            return StatusMessage.InvalidArgumentError("Not a valid string");
        }
        return StatusMessage.okStatus();
    }

    /**
     * Meant as a util function, will set a default value to map when using either 'SuperSmall', 'Small',
     * 'medium', etc...
     * @param size Which size is the user is specifying, can be any of them.
     * @param price The price this user plans to use.
     * @return Will return true if the new price has been set, else will return false if the string
     * value did not match. This is also true if price is a negative number.
     */
    public Status setSizePrice(Size size, int price){
        return setSizePrice(LotUtil.StringToSize(size), price);
    }

    /**
     * Gets the desired price.
     * @param size based of class enum, desired size.
     * @return
     */
    public int getSizePrice(Size size) {
        return getSizePrice(LotUtil.StringToSize(size));
    }

    /**
     * Gets the desired price of the given price.
     * @param size the desired price.
     * @return the price.
     */
    public int getSizePrice(String size) {
        if (size.equalsIgnoreCase("super small")) {
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
        if (size.equalsIgnoreCase("super Large")) {
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
    public String getFieldName() {return fieldName;}
    public void write() {
        System.out.println("This Works");
    }
}
