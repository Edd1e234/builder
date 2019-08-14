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
    // Size of the lot in general, size could be super small,
    // small, medium, large, super large.
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

    /**
     * Meant as a util function, will set a default value to map when using either 'SuperSmall', 'Small',
     * 'medium', etc...
     * @param size Which size is the user is specifying, can be any of them.
     * @param price The price this user plans to use.
     * @return Will return true if the new price has been set, else will return false if the string
     * value did not match. This is also true if price is a negative number.
     */
    public boolean setSizePrice(String size, int price) {
        if (price < 0) {
            System.out.println("Cannot be a negative value.");
        }
        if (price == 0) {
            System.out.println("Cannot be 0.");
        }
        if (size.equalsIgnoreCase("super small")) {
            this.superSmall = price;
            return true;
        }
        if (size.equalsIgnoreCase("small")) {
            this.small = price;
            return true;
        }
        if (size.equalsIgnoreCase("medium")) {
            this.medium = price;
            return true;
        }
        if (size.equalsIgnoreCase("large")) {
            this.large = price;
            return true;
        }
        if (size.equalsIgnoreCase("super large")) {
            this.superLarge = price;
            return true;
        }
        System.out.println("Error, no matching string");
        return false;
    }
    /**
     * Meant as a util function, will set a default value to map when using either 'SuperSmall', 'Small',
     * 'medium', etc...
     * @param size Which size is the user is specifying, can be any of them.
     * @param price The price this user plans to use.
     * @return Will return true if the new price has been set, else will return false if the string
     * value did not match. This is also true if price is a negative number.
     */
    public boolean setSizePrice(Size size, int price){
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
                return false;
        }
    }
    public int GetSizePrice(Size size) {
        switch (size){
            case SUPER_SMALL:
                return GetSizePrice("super small");
            case SMALL:
                return GetSizePrice("small");
            case MEDIUM:
                return GetSizePrice("medium");
            case LARGE:
                return GetSizePrice("large");
            case SUPER_LARGE:
                return GetSizePrice("super large");
            default:
                return 0;
        }
    }

    // (TODO/Edd1e234): Refactor these methods.
    public int GetSizePrice(String size) {
        if (size.equalsIgnoreCase("super small")) {
            ActualValue += superSmall;
        }
        if (size.equalsIgnoreCase("small")) {
            ActualValue += small;
        }
        if (size.equalsIgnoreCase("medium")) {
            ActualValue += medium;
        }
        if (size.equalsIgnoreCase("large")) {
            ActualValue += large;
        }
        if (size.equalsIgnoreCase("super Large")) {
            ActualValue += superLarge;
        } else {
            System.out.println("Incorrect input");
            return 0;
        }

        // Total value of the entire lot.
        return ActualValue;
    }
    public double getFieldID() {
        return fieldID;
    }
    public String
    public void write() {
        System.out.println("This Works");
    }
}
