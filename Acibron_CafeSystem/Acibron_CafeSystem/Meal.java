/**
 * Represents a rice meal sold at the campus cafe.
 * 
 * @author Lars Acibron
 * @version 1.2
 */
  
 //Atts
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor for Meal.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor for Meal.
     * 
     * @param name       the meal name
     * @param basePrice  the base price
     * @param itemCode   the item code
     * @param upsized    true if upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        setExtraSides(extraSides);
    }
    //Overrides it to add upsize and extra side fees:  
    @Override
    public double computePrice() {
        double price = basePrice;
        if (upsized) {
            price += 20;
        }
        price += (12 * extraSides);
        return price;
    }

    @Override
    public String getDescription() {
        String status = upsized ? "Upsized" : "Regular";
        return super.getDescription() + " " + status + ", " + extraSides + " side(s)";
    }

    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
        if (extraSides < 0) {
            System.out.println("Error: Extra sides cannot be negative. Setting to 0.");
            this.extraSides = 0;
        } else {
            this.extraSides = extraSides;
        }
    }
}
