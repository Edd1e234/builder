package builder.Backend;

/**
 * Place holder for all lot types. Basic, Lower Valley, etc... Will be used to communicate with
 * frontend.
 *
 * @author Owner Edd1e234
 * @Version 1.0
 * @since 2019-8-14
 */

import builder.util.Status;
import builder.util.StatusMessage;

import java.util.ArrayList;

public class EstimateLot {
    private ArrayList<LotField> lotFields = new ArrayList<LotField>();

    // Will make a basic lot for the user to set.
    public EstimateLot() {
        LotField basicLot = new LotField("Basic");
        lotFields.add(basicLot);
    }

    // Returns entire Array list. Should not be used.
    public ArrayList<LotField> getLotFields() {
        return lotFields;
    }

    /**
     * Will set fields of an already existing lot field type.
     *
     * @param index Which lot field to be edited.
     * @param size  Should only be 'super small' to 'super Large'.
     * @param price The price to set.
     * @return Status on the success of the operation.
     */
    public Status setField(int index, String size, int price) {
        if (index > lotFields.size()) {

            return StatusMessage.InvalidArgumentError("Index is greater than array size.");
        }
        return lotFields.get(index).setSizePrice(size, price);
    }

    /**
     * Gets the desired LotField.
     *
     * @param index Where the field is located.
     * @param field Used as an output parameter. Once LotField is located, the data will be copied
     *              over to 'field'.
     * @return State of the function, 'InvalidArgumentError' if index does not exist.
     */
    public Status getField(int index, LotField field) {
        if (lotFields.size() <= index) {
            return StatusMessage.InvalidArgumentError("Index is too great");
        }
        field = lotFields.get(index);
        return StatusMessage.okStatus();
    }

    /**
     * Gets the desired LotField.
     *
     * @param fieldName Name of the desired field.
     * @param field     Used as an output parameter. Once LotField is located, the data will be
     *                  copied over to 'field'.
     * @return Status of the function, if the LotField is not found then a 'NotFoundError' will be
     * thrown.
     */
    public Status getField(String fieldName, LotField field) {
        for (LotField field_ : lotFields) {
            if (fieldName.equals(field_.getFieldName())) {
                field = field_;
                return StatusMessage.okStatus();
            }
        }
        return StatusMessage.NotFoundError("Field ID not found");
    }

    /**
     * Adds new LotFields.
     *
     * @return Status.
     */
    public Status addField() {
        LotField lot = new LotField("New Field", lotFields.size());
        lotFields.add(lot);
        return StatusMessage.okStatus();
    }

    /**
     * Adds new LotFields.
     *
     * @param fieldName Lot name.
     * @return
     */
    public Status addField(String fieldName) {
        LotField lot = new LotField(fieldName, lotFields.size());
        lotFields.add(lot);
        return StatusMessage.okStatus();
    }

    /**
     * @param lot
     * @return
     */
    public Status addField(LotField lot) {
        lotFields.add(lot);
        return StatusMessage.okStatus();
    }

    /**
     * Creates String of all LotFields.
     *
     * @return
     */
    public String toString() {
        StringBuilder fullStringList = new StringBuilder();
        for (LotField lot : lotFields) {
            fullStringList.append(lot.toString());
        }
        return fullStringList.toString();
    }

    public void write() {
        System.out.println(lotFields.get(0).getFieldName());
    }
}
