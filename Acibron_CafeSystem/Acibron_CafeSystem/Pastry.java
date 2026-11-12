/**
 * Represents a baked item sold at the campus cafe.
 * 
 * @author Lars Acibron
 * @version 1.5
 */
  
 //atts
public class Pastry extends MenuItem {
    private boolean warmed;

    /**
     * Default constructor for Pastry.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor for Pastry.
     * 
     * @param name      the pastry name
     * @param basePrice the base price
     * @param itemCode  the item code
     * @param warmed    true if warmed, false otherwise
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }
    //Overrides it to add a warming fee:  
    @Override
    public double computePrice() {
        if (warmed) {
            return basePrice + 10;
        }
        return basePrice;
    }
    /**
     * 
     *  Warm Fee at @Override
     * 
     * */
    
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription() + " (Regular)";
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
