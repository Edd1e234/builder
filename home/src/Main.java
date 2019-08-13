public class Main {
    public static void main(String[] args) {
        System.out.print("Hello");

        Lot lots = new Lot();
        lots.write();

        if (lots.setSizePrice("This is the price", 45)) {
            System.out.println("Super small");
        }
    }
}
