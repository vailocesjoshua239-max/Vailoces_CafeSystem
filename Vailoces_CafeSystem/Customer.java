/**
 * The customer placing an order. Students get a discount and every
 * customer earns loyalty points.
 *
 * @author Manlosa, John Lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public class Customer {

    /** Pesos needed to earn one loyalty point. */
    private static final int PESOS_PER_POINT = 50;

    /** The customer's name. */
    private String name;

    /** True if the customer is a student. */
    private boolean student;

    /** The loyalty points earned so far. */
    private int loyaltyPoints;

    /**
     * Creates a guest customer who is not a student.
     */
    public Customer() {
        name = "Guest";
        student = false;
        loyaltyPoints = 0;
    }

    /**
     * Creates a non-student customer with a name.
     *
     * @param name the customer's name
     */
    public Customer(String name) {
        this();
        setName(name);
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name    the customer's name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this(name);
        this.student = student;
    }

    /**
     * Adds loyalty points directly.
     *
     * @param points the points to add (negative values are rejected)
     */
    public void addPoints(int points) {
        // Points can only be added, not removed
        if (points < 0) {
            System.out.println("Error: points cannot be negative.");
        } else {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds 1 loyalty point for every 50 pesos spent.
     *
     * @param amountSpent the amount spent in pesos
     */
    public void addPoints(double amountSpent) {
        addPoints((int) (amountSpent / PESOS_PER_POINT));
    }

    /**
     * Gets the name.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name. Empty names are rejected.
     *
     * @param name the new name
     */
    public void setName(String name) {
        // Accept the name only if it is not empty
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    /**
     * Checks if the customer is a student.
     *
     * @return true if a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the student status.
     *
     * @param student true if the customer is a student
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the loyalty points.
     *
     * @return the loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the loyalty points. Negative values are rejected.
     *
     * @param loyaltyPoints the new points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Points may never be negative
        if (loyaltyPoints < 0) {
            System.out.println("Error: points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}
