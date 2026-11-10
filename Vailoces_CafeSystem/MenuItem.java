/**
 * Abstract parent of all menu items in the campus cafe.
 * It cannot be instantiated directly.
 *
 * @author Manlosa, John Lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public abstract class MenuItem {

    /** The name of the item. */
    protected String name;

    /** The base price in pesos. */
    protected double basePrice;

    /** The menu code of the item. */
    private String itemCode;

    /**
     * Creates a menu item with default values.
     */
    public MenuItem() {
        name = "Unnamed Item";
        basePrice = 0.0;
        itemCode = "N/A";
    }

    /**
     * Creates a menu item with the given values.
     *
     * @param name      the name of the item
     * @param basePrice the base price in pesos
     * @param itemCode  the menu code of the item
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Computes the final price. Each subclass defines its own pricing.
     *
     * @return the final price in pesos
     */
    public abstract double computePrice();

    /**
     * Returns the name and item code.
     *
     * @return the description of the item
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the name.
     *
     * @return the name
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
     * Gets the base price.
     *
     * @return the base price in pesos
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price. Negative prices are rejected.
     *
     * @param basePrice the new base price in pesos
     */
    public void setBasePrice(double basePrice) {
        // Reject a negative price and keep the old value
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets the item code.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code. Empty codes are rejected.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        // Accept the code only if it is not empty
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode.trim();
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}