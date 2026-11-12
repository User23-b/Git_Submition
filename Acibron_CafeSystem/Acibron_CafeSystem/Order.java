/**
 * Connects a Customer to up to three MenuItem objects.
 * 
 * @author Lars Acibron
 * @version 1.3
 */
public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Parameterized constructor for Order.
     * 
     * @param orderId  unique order ID
     * @param customer the customer
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.item1 = null;
        this.item2 = null;
        this.item3 = null;
        this.itemCount = 0;
    }

    //max item(s) limit
    
    public boolean addItem(MenuItem item) {
        if (itemCount == 0) {
            item1 = item;
            itemCount++;
            return true;
        } else if (itemCount == 1) {
            item2 = item;
            itemCount++;
            return true;
        } else if (itemCount == 2) {
            item3 = item;
            itemCount++;
            return true;
        } else {
            System.out.println("Order is full. Cannot add " + item.getName() + " [" + item.getItemCode() + "].");
            return false;
        }
    }

    public double computeSubtotal() {
        double subtotal = 0.0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    // discount for if student is true
    
    public double computeTotal() {
        double subtotal = computeSubtotal();
        if (customer.isStudent()) {
            return subtotal * 0.90;
        } else {
            return subtotal;
        }
    }

    // final total where voucher is being applied to the recipt output
    //deducts a voucher value from the total
    public double computeTotal(double voucher) {
        double total = computeTotal();
        double finalTotal = total - voucher;
        if (finalTotal < 0) {
            return 0.0;
        }
        return finalTotal;
    }
//checker
    public void printReceipt() {
        System.out.println("Order #" + orderId + " — " + customer.getName() + (customer.isStudent() ? " (Student)" : ""));
        
        if (item1 != null) {
            System.out.printf("%s ............ %.2f\n", item1.getDescription(), item1.computePrice());
        }
        if (item2 != null) {
            System.out.printf("%s ............ %.2f\n", item2.getDescription(), item2.computePrice());
        }
        if (item3 != null) {
            System.out.printf("%s ............ %.2f\n", item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();
        System.out.printf("Subtotal: %.2f\n", subtotal);

        if (customer.isStudent()) {
            double discount = subtotal * 0.10;
            System.out.printf("Student discount (10%%): -%.2f\n", discount);
            System.out.printf("TOTAL: %.2f\n", computeTotal());
        } else {
            System.out.printf("TOTAL: %.2f\n", computeTotal());
        }

        double finalSpent = computeTotal();
        customer.addPoints(finalSpent);
        System.out.println("Loyalty points: " + (int)(finalSpent / 50));
        System.out.println();
    }
}
