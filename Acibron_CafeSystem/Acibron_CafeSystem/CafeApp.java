/**
 * Main driver class for the Campus Cafe Ordering System.
 * 
 * @author Lars Acibron
 * @version 1.2
 */
public class CafeApp {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Ana Reyes", true);
        Customer customer2 = new Customer("Ben Cruz");
        
      /**
       * order 1 Ana
       * 
       */  
       
        Beverage bev1 = new Beverage("Iced Latte", 95.0, "B-01", "L");
        Pastry pastry1 = new Pastry("Ensaymada", 45.0, "P-01", true);
        Meal meal1 = new Meal("Chicken Adobo", 110.0, "M-01", true, 1);
        
        Order order1 = new Order("1001", customer1);
        order1.addItem(bev1);
        order1.addItem(pastry1);
        order1.addItem(meal1);
        
        Pastry extraCookie = new Pastry("Cookie", 30.0, "P-02", false);
        order1.addItem(extraCookie);
        
        order1.printReceipt();
        
        //Setup Order 2 : Ben
        
        Beverage bev2 = new Beverage();
        bev2.setName("Hot Chocolate");
        bev2.setItemCode("B-02");
        
        //Note: Order #1002's Hot Chocolate was created with the default Beverage() constructor
        //and then filled in with setters. The negative-price error appears because
        //setBasePrice(-5) was tried before setBasePrice(80).
        
        bev2.setBasePrice(-5);
        bev2.setBasePrice(80);
        bev2.setSize("M");

        Meal meal2 = new Meal("Beef Tapa", 130.0, "M-02", false, 0);
       
        Order order2 = new Order("1002", customer2);
        order2.addItem(bev2);
        order2.addItem(meal2);

        System.out.println("Order #1002 — Ben Cruz");
        System.out.printf("%s ............ %.2f\n", bev2.getDescription(), bev2.computePrice());
        System.out.printf("%s ............ %.2f\n", meal2.getDescription(), meal2.computePrice());
        double sub2 = order2.computeSubtotal();
        System.out.printf("Subtotal: %.2f\n", sub2);
        System.out.printf("Voucher: -20.00\n");
        double final2 = order2.computeTotal(20.0);
        System.out.printf("TOTAL: %.2f\n", final2);
        customer2.addPoints(final2);
        System.out.println("Loyalty points: " + (int) (sub2 / 50));
    }
}
