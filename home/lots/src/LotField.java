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
    private String fieldName = "";
    private double fieldID;
    private int sqf;
    private int averageValuePerSqf = 20;
    private int sqfPrice = 0;
    private int superSmall = 50;
    private int small = 50;
    private int medium = 50;
    private int large = 50;
    private int superLarge = 50;

    // The amount of money the lot would cost.
    private int ActualValue;

    // Default Constructor.
    public LotField () {
        fieldID = Math.random();
        fieldName = "Basic";
    }

    // Adding a new field. The field name is meant to be as a placeholder.
    public LotField(String fieldName, int index) {
        fieldID = Math.random();
        this.fieldName = fieldName + index;
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
        switch (size){
            case SUPER_SMALL:
                return setSizePrice("super small", price);
            case SMALL:
                return setSizePrice("small", price);
            case MEDIUM:
                return setSizePrice("medium", price);
            case LARGE:
                return setSizePrice("large", price);
            case SUPER_LARGE:
                return setSizePrice("super large", price);
            default:
                return StatusMessage.InvalidArgumentError();
        }
    }
    public int getSizePrice(Size size) {
        switch (size){
            case SUPER_SMALL:
                return getSizePrice("super small");
            case SMALL:
                return getSizePrice("small");
            case MEDIUM:
                return getSizePrice("medium");
            case LARGE:
                return getSizePrice("large");
            case SUPER_LARGE:
                return getSizePrice("super large");
            default:
                return -1;
        }
    }

    // (TODO/Edd1e234): Refactor these methods.
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
    public double getFieldID() {
        return fieldID;
    }
    public String getFieldName() {return fieldName;}
    public void write() {
        System.out.println("This Works");
    }
}
