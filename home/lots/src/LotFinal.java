public class LotFinal {
    // Actual address of lot.
    private String address;
    private final double LOT_ID = Math.random();
    private LotField lotField;

    public void setLotField(LotField field) {
        lotField = field;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LotField getLotField() {
        return lotField;
    }

    public String getAddress() {
        return address;
    }

    public double getLOT_ID() {
        return LOT_ID; 
    }

}
