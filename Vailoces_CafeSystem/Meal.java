/**
 * A rice meal that can be upsized and given extra sides.
 *
 * @author Manlosa, John Lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public class Meal extends MenuItem {

    /** Extra price for an upsized meal. */
    private static final double UPSIZE_FEE = 20;

    /** Price of each extra side. */
    private static final double SIDE_PRICE = 12;

    /** True if the meal is upsized. */
    private boolean upsized;

    /** The number of extra sides. */
    private int extraSides;

    /**
     * Creates a regular meal with no extra sides, with default values.
     */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with the given values.
     *
     * @param name       the name of the meal
     * @param basePrice  the regular price in pesos
     * @param itemCode   the menu code
     * @param upsized    true if the meal is upsized
     * @param extraSides the number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Computes the price: base price, plus 20 if upsized, plus 12 per extra side.
     *
     * @return the price in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds a flat fee
        if (upsized) {
            price += UPSIZE_FEE;
        }
        return price + SIDE_PRICE * extraSides;
    }

    /**
     * Returns the description with the upsize status and number of extra sides.
     *
     * @return the name, item code, size status and sides
     */
    @Override
    public String getDescription() {
        String sizeText = "Regular";
        // Show Upsized when the meal is upsized
        if (upsized) {
            sizeText = "Upsized";
        }
        String sideText = extraSides + " sides";
        // Use the singular word for one side
        if (extraSides == 1) {
            sideText = "1 side";
        }
        return super.getDescription() + " " + sizeText + ", " + sideText;
    }

    /**
     * Checks if the meal is upsized.
     *
     * @return true if upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets whether the meal is upsized.
     *
     * @param upsized true to upsize the meal
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides. Negative values are rejected.
     *
     * @param extraSides the new number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Reject a negative number and keep the old value
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}