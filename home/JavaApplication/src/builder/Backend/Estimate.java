package builder.Backend;

public class Estimate {
    private EstimateLot lot;

    public Estimate() {
    }

    // Setters and getters.
    public EstimateLot getLot() {
        return lot;
    }

    public void setLot(EstimateLot lot) {
        this.lot = lot;
    }

    public String toString() {
        return "\n" + lot.toString();
    }
}
