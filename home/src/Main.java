import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main Works");

        LotField lotField = new LotField();

        Lot lot = new Lot();
        Status status = lot.setField(0, "afasdf", 0);
        System.out.println(status.isok() + " " + status.getMessage());
    }
}
