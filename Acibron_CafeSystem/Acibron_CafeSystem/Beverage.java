/**
 * Represents a beverage sold at the campus cafe.
 * 
 * @author Lars Acibron
 * @version 1.5
 */
  
 //atts
public class Beverage extends MenuItem {
    private String size;

    /**
     * Default constructor for Beverage.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Parameterized constructor for Beverage.
     * 
     * @param name      the beverage name
     * @param basePrice the base price
     * @param itemCode  the item code
     * @param size      the size ("S", "M", or "L")
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        setSize(size);
    }
//Overrides it to calculate price based on size ("S", "M", "L"):  
    @Override
    public double computePrice() {
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public String getSize() {
        return size;
    }
//Size will got go beyond the 3 sizes; if else it will keep its default size
    public void setSize(String size) {
        if (size.equals("S") || size.equals("M") || size.equals("L")) {
            this.size = size;
        } else {
            System.out.println("Error: Invalid size. Keeping previous size.");
        }
    }
}
