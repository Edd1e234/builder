package builder;

import builder.Backend.EstimateLot;
import builder.Backend.LotField;
import builder.util.Status;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Works");

        LotField lotField = new LotField();

        EstimateLot lot = new EstimateLot();
        Status status = lot.setField(0, "afasdf", 0);
        System.out.println(status.isOk() + " " + status.getMessage());

        System.out.println(lotField.toString());

        StringBuilder stringBuilder = new StringBuilder();
    }
}