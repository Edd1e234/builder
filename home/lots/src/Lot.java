/**
 * This will calculate everything when it comes to lots.
 * Should do everything when it comes to lots.
 *
 * @author Owner Edd1e234
 * @Version 1.0
 * @since 2019-8-13
 */

import java.util.*;
import java.lang.*;

public class Lot {
    // Size of the lot in general, size could be super small,
    // small, medium, large, super large.
    public enum Size {
        LARGE, MEDIUM, SMALL, SUPER_LARGE, SUPER_SMALL
    }
    Size Size;
    private int Sqf;
    private int averageValuePerSqf = 20;
    private int SqfPrice = 0;
    private int SuperSmall = 50;
    private int Small = 50;
    private int Medium = 50;
    private int Large = 50;
    private int SuperLarge = 50;

    // The amount of money the lot would cost.
    private int ActualValue;

    // Default Constructor.
    public Lot () {}

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
            this.SuperSmall = price;
            return true;
        }
        if (size.equalsIgnoreCase("small")) {
            this.Small = price;
            return true;
        }
        if (size.equalsIgnoreCase("medium")) {
            this.Medium = price;
            return true;
        }
        if (size.equalsIgnoreCase("large")) {
            this.Large = price;
            return true;
        }
        if (size.equalsIgnoreCase("super large")) {
            this.SuperLarge = price;
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
    public int GetValue(Size size) {
        switch (size){
            case SUPER_SMALL:
                return GetValue("super small");
            case SMALL:
                return GetValue("small");
            case MEDIUM:
                return GetValue("medium");
            case LARGE:
                return GetValue("large");
            case SUPER_LARGE:
                return GetValue("super large");
            default:
                return 0;
        }
    }
    public int GetValue(String size) {
        if (size.equalsIgnoreCase("super small")) {
            ActualValue += SuperSmall;
        }
        if (size.equalsIgnoreCase("small")) {
            ActualValue += Small;
        }
        if (size.equalsIgnoreCase("medium")) {
            ActualValue += Medium;
        }
        if (size.equalsIgnoreCase("large")) {
            ActualValue += Large;
        }
        if (size.equalsIgnoreCase("super Large")) {
            ActualValue += SuperLarge;
        } else {
            System.out.println("Incorrect input");
            return 0;
        }

        // Total value of the entire lot.
        return ActualValue;
    }
    public void write() {
        System.out.println("Lots");
    }
}
