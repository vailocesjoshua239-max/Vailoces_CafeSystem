/**
 * Main class of the Campus Cafe Ordering System.
 *
 * @author Manlosa, John lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public class CafeApp {

    /**
     * Runs the program.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Two customers made with different constructors
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // Order 1001: items made with parameterized constructors
        Beverage icedLatte = new Beverage("Iced Latte", 95.00, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.00, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110.00, "M-01", true, 1);

        // Cookie made with the default constructor, then filled in with setters
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setItemCode("P-02");
        cookie.setBasePrice(35.00);

        Order order1 = new Order("1001", ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);
        order1.addItem(cookie); // fourth item: rejected by the limit check
        order1.printReceipt();

        System.out.println();

        // Order 1002: items made with default constructors, then setters
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setBasePrice(-5); // invalid: shows the error message
        hotChocolate.setBasePrice(80); // valid
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setItemCode("M-02");
        beefTapa.setBasePrice(130.00);

        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.printReceipt(20.00); // with a 20-peso voucher
    }
}
