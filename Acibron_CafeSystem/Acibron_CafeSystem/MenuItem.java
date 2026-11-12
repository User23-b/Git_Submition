/**
 * Represents an abstract menu item sold at the cafe.
 * 
 * @author Lars Acibron
 * @version 1.3
 */
  
 //Declares the abstract method:  
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * constructor for MenuItem. (by hard code input)
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor for MenuItem.
     * 
     * @param name      the name of the item
     * @param basePrice the base price
     * @param itemCode  the item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of the menu item.
     * 
     * @return computed price
     */
    public abstract double computePrice();

    /**
     * Returns description string of the menu item.
     * 
     * @return description string
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
