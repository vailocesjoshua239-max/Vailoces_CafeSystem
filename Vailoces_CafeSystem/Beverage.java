/**
 * A drink whose price depends on its size.
 *
 * @author Manlosa, John Lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public class Beverage extends MenuItem {

    /** Extra price for a Medium drink. */
    private static final double MEDIUM_EXTRA = 15;

    /** Extra price for a Large drink. */
    private static final double LARGE_EXTRA = 25;

    /** The size: "S", "M" or "L". */
    private String size;

    /**
     * Creates a Small beverage with default values.
     */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Creates a beverage with the given values.
     *
     * @param name      the name of the drink
     * @param basePrice the Small-size price in pesos
     * @param itemCode  the menu code
     * @param size      the size: "S", "M" or "L"
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Computes the price based on size.
     *
     * @return the price in pesos
     */
    @Override
    public double computePrice() {
        // Large adds 25, Medium adds 15, Small uses the base price
        if (size.equals("L")) {
            return basePrice + LARGE_EXTRA;
        } else if (size.equals("M")) {
            return basePrice + MEDIUM_EXTRA;
        } else {
            return basePrice;
        }
    }

    /**
     * Returns the description with the size added.
     *
     * @return the name, item code and size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the size.
     *
     * @return "S", "M" or "L"
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size. Only S, M or L is accepted; otherwise the old size is kept.
     *
     * @param size the new size
     */
    public void setSize(String size) {
        // Accept only the three valid sizes
        if ("S".equals(size) || "M".equals(size) || "L".equals(size)) {
            this.size = size;
        } else {
            System.out.println("Error: size must be S, M or L.");
        }
    }
}
