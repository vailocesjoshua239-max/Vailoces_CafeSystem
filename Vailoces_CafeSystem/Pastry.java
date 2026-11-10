/**
 * A baked item that can be warmed for an extra fee.
 *
 * @author Manlosa, John Lloyd
 * @author Vailoces, Joshua Paul
 * @version 1.0
 */
public class Pastry extends MenuItem {

    /** Extra price for warming the pastry. */
    private static final double WARMING_FEE = 10;

    /** True if the pastry is warmed. */
    private boolean warmed;

    /**
     * Creates a pastry that is not warmed, with default values.
     */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry with the given values.
     *
     * @param name      the name of the pastry
     * @param basePrice the price in pesos before the warming fee
     * @param itemCode  the menu code
     * @param warmed    true if the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the price. Warming adds a fee.
     *
     * @return the price in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add the warming fee only if the pastry is warmed
        if (warmed) {
            price += WARMING_FEE;
        }
        return price;
    }

    /**
     * Returns the description with "(Warmed)" when applicable.
     *
     * @return the name, item code and warming status
     */
    @Override
    public String getDescription() {
        String text = super.getDescription();
        // Mention warming only when it applies
        if (warmed) {
            text += " (Warmed)";
        }
        return text;
    }

    /**
     * Checks if the pastry is warmed.
     *
     * @return true if warmed
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets whether the pastry is warmed.
     *
     * @param warmed true to warm the pastry
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}