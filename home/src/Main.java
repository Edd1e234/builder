public class Main {
    public static void main(String[] args) {
        System.out.print("Hello");

        LotField lotField = new LotField();
        lotField.write();

        if (lotField.setSizePrice("This is the price", 45)) {
            System.out.println("Super small");
        }
    }

    Lot lot = new Lot();

}
