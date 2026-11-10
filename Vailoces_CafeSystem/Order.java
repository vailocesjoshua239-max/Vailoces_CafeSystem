/**
 * An order that connects a Customer to up to three MenuItem objects.
 * Items are kept in separate fields (no arrays or collections).
 *
 * @author Manlosa, John Lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public class Order {

    /** The discount rate for students (10%). */
    private static final double STUDENT_DISCOUNT_RATE = 0.10;

    /** The customer who placed the order. */
    private Customer customer;

    /** The first item. */
    private MenuItem item1;

    /** The second item. */
    private MenuItem item2;

    /** The third item. */
    private MenuItem item3;

    /** The number of items in the order. */
    private int itemCount;

    /** The order number. */
    private String orderId;

    /**
     * Creates an empty order.
     *
     * @param orderId  the order number
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    /**
     * Adds an item to the first empty slot.
     *
     * @param item the item to add
     * @return true if added, false if the order already has three items
     */
    public boolean addItem(MenuItem item) {
        // Use the first empty slot, or report that the order is full
        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        }
        itemCount++;
        return true;
    }

    /**
     * Adds up the price of every item in the order.
     *
     * @return the subtotal in pesos
     */
    public double computeSubtotal() {
        double subtotal = 0;
        // Add only the slots that have an item
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the total after the student discount.
     *
     * @return the total in pesos
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Students get 10% off; everyone else pays the subtotal
        if (customer.isStudent()) {
            return subtotal - subtotal * STUDENT_DISCOUNT_RATE;
        } else {
            return subtotal;
        }
    }

    /**
     * Computes the total after the student discount and a voucher.
     * The total never goes below 0.
     *
     * @param voucher the voucher amount in pesos
     * @return the total in pesos
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;
        // The total may never be negative
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    /**
     * Prints the receipt without a voucher.
     */
    public void printReceipt() {
        printReceipt(0);
    }

    /**
     * Prints the receipt with a voucher, then adds loyalty points to the customer.
     *
     * @param voucher the voucher amount in pesos (0 for none)
     */
    public void printReceipt(double voucher) {
        String tag = "";
        // Mark students in the header
        if (customer.isStudent()) {
            tag = " (Student)";
        }
        System.out.println("Order #" + orderId + " - " + customer.getName() + tag);

        // Print each item that is in the order
        if (item1 != null) {
            System.out.printf("%s ............ %.2f%n", item1.getDescription(), item1.computePrice());
        }
        if (item2 != null) {
            System.out.printf("%s ............ %.2f%n", item2.getDescription(), item2.computePrice());
        }
        if (item3 != null) {
            System.out.printf("%s ............ %.2f%n", item3.getDescription(), item3.computePrice());
        }

        System.out.printf("Subtotal: %.2f%n", computeSubtotal());
        // Show the student discount only for students
        if (customer.isStudent()) {
            System.out.printf("Student discount (10%%): -%.2f%n", computeSubtotal() * STUDENT_DISCOUNT_RATE);
        }
        // Show the voucher only when one is used
        if (voucher > 0) {
            System.out.printf("Voucher: -%.2f%n", voucher);
        }
        double total = computeTotal(voucher);
        System.out.printf("TOTAL: %.2f%n", total);

        customer.addPoints(total);
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
    }

    /**
     * Gets the customer.
     *
     * @return the customer of this order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the order number.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the number of items.
     *
     * @return the item count
     */
    public int getItemCount() {
        return itemCount;
    }
}