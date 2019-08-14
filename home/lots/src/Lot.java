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

    public boolean setField(int index, String size, int price) {
        if (index > lotFields.size()) {
            return false;
        }

        return true;
    }

    public void write() {
        System.out.println(lotFields.get(0).getFieldName());
    }
}
