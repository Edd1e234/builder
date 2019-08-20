package builder.client.containers;

import builder.Backend.LotField;
import javafx.beans.property.SimpleStringProperty;

/**
 * TODO(Edd1e234): Someone please define this.
 */
public class LotContainer {
    private SimpleStringProperty type, superSmall, small, medium, large, superLarge;
    private SimpleStringProperty sqf = new SimpleStringProperty("");
    private SimpleStringProperty sqfPrice = new SimpleStringProperty("");

    /**
     * Fill this out @Edd1e234.
     * @param field ...
     */
    public LotContainer(LotField field) {
        this.type = new SimpleStringProperty(field.getFieldName());
        this.superSmall = new SimpleStringProperty(
                Double.toString(field.getSizePrice("super small")));
        this.small = new SimpleStringProperty(Double.toString(field.getSizePrice("small")));
        this.medium = new SimpleStringProperty(Double.toString(field.getSizePrice("medium")));
        this.large = new SimpleStringProperty(Double.toString(field.getSizePrice("large")));
        this.superLarge = new SimpleStringProperty(
                Double.toString(field.getSizePrice("super large")));
        this.sqfPrice = new SimpleStringProperty(Double.toString(field.getSqfPrice()));
        this.superSmall = new SimpleStringProperty(Double.toString(field.getSqf()));
    }

    // Contains all class variables except sqfPrice.
    public LotContainer(String type, String superSmall, String small, String medium, String large,
                        String superLarge, String sqfPrice, String sqf) {
        this.type = new SimpleStringProperty(type);
        this.superSmall = new SimpleStringProperty(superSmall);
        this.small = new SimpleStringProperty(small);
        this.medium = new SimpleStringProperty(medium);
        this.large = new SimpleStringProperty(large);
        this.superLarge = new SimpleStringProperty(superLarge);
        this.sqfPrice = new SimpleStringProperty(sqfPrice);
        this.sqf = new SimpleStringProperty(sqf);
    }

    public LotContainer(String type, String superSmall, String small, String medium, String large,
                        String superLarge, String sqfPrice) {
        this.type = new SimpleStringProperty(type);
        this.superSmall = new SimpleStringProperty(superSmall);
        this.small = new SimpleStringProperty(small);
        this.medium = new SimpleStringProperty(medium);
        this.large = new SimpleStringProperty(large);
        this.superLarge = new SimpleStringProperty(superLarge);
        this.sqfPrice = new SimpleStringProperty(sqfPrice);
    }

    // Setters and Getters.
    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getSuperSmall() {
        return superSmall.get();
    }

    public SimpleStringProperty superSmallProperty() {
        return superSmall;
    }

    public void setSuperSmall(String superSmall) {
        this.superSmall.set(superSmall);
    }

    public String getSmall() {
        return small.get();
    }

    public SimpleStringProperty smallProperty() {
        return small;
    }

    public void setSmall(String small) {
        this.small.set(small);
    }

    public String getMedium() {
        return medium.get();
    }

    public SimpleStringProperty mediumProperty() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium.set(medium);
    }

    public String getLarge() {
        return large.get();
    }

    public SimpleStringProperty largeProperty() {
        return large;
    }

    public void setLarge(String large) {
        this.large.set(large);
    }

    public String getSuperLarge() {
        return superLarge.get();
    }

    public SimpleStringProperty superLargeProperty() {
        return superLarge;
    }

    public void setSuperLarge(String superLarge) {
        this.superLarge.set(superLarge);
    }

    public String getSqfPrice() {
        return sqfPrice.get();
    }

    public SimpleStringProperty sqfPriceProperty() {
        return sqfPrice;
    }

    public void setSqfPrice(String sqfPrice) {
        this.sqfPrice.set(sqfPrice);
    }

    public String getSqf() {
        return sqf.get();
    }

    public SimpleStringProperty sqfProperty() {
        return sqf;
    }

    public void setSqf(String sqf) {
        this.sqf.set(sqf);
    }
}
