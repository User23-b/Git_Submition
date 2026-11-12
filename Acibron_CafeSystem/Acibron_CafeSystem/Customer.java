/**
 * Represents a customer placing an order.
 * 
 * @author Lars Acibron
 * @version 1.2
 */
  
     //attributes
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor for Customer.
     */
    public Customer() {
        this.name = "Guest";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Overloaded constructor taking name.
     * 
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Overloaded constructor taking name and student status.
     * 
     * @param name    customer name
     * @param student student flag
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }
    //Main Point System or Default
    public void addPoints(int points) {
        if (points > 0) {
            this.loyaltyPoints += points;
        }
    }
    //adds points by amount spent which is divided by 50 as the default num for the loyalty points
    // checks which user has amount of points and divides by its set discount
    // Overloads the addPoints() / default
    public void addPoints(double amountSpent) {
        int earnedPoints = (int) (amountSpent / 50);
        this.loyaltyPoints += earnedPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            this.loyaltyPoints = 0;
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}
