/**
 * Place holder for all lot types. Basic, Lower Valley, etc...
 * Will be used to communicate with frontend.
 *
 * @author Owner Edd1e234
 * @Version 1.0
 * @since 2019-8-14
 */

import java.util.ArrayList;


public class Lot {
    private ArrayList<LotField> lotFields = new ArrayList<LotField>();

    // Will make a basic lot for the user to set.
    public Lot() {
        LotField basicLot = new LotField();
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
     * @param size Should only be 'super small' to 'super Large'.
     * @param price The price to set.
     * @return Status on the success of the operation.
     */
    public Status setField(int index, String size, int price) {
        if (index > lotFields.size()) {

            return StatusMessage.InvalidArgumentError("Index is greater than array size.");
        }
        return lotFields.get(index).setSizePrice(size, price);
    }

    public Status AddField() {
        LotField lot = new LotField("New Field",  lotFields.size());
        lotFields.add(lot);
        return StatusMessage.okStatus();
    }

    public Status AddField(String fieldName) {
        LotField lot = new LotField(fieldName);
        lotFields.add(lot);
        return StatusMessage.okStatus();
    }

    public void write() {
        System.out.println(lotFields.get(0).getFieldName());
    }
}
