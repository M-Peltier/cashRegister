package cashRegister;


/**
 * This class tests the CashRegister class.
 */
public class CashRegisterApp {
    public static void main(String[] args) {
        // First register
        CashRegister register = new CashRegister();
        register.recordPurchase(0.75);
        register.recordPurchase(1.50);
        register.receivePayment(2, 0, 5, 0, 0);
        System.out.println("Change: " + register.giveChange());
        System.out.println("Expected: 0.25");
        
        // Second register
        CashRegister register_1 = new CashRegister();
        register_1.recordPurchase(2.25);
        register_1.recordPurchase(19.25);
        register_1.receivePayment(23, 2, 0, 0, 0);
        System.out.println("Change: " + register_1.giveChange());
        System.out.println("Expected: 2.0");
    }
}

class CashRegister {
    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.10;
    public static final double NICKEL_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;

    private double purchase;
    private double payment;

    // Constructs a cash register with no money in it
    public CashRegister() {
        purchase = 0;
        payment = 0;
    }

    /**
     * Records the purchase of an item.
     * @param amount the price of the purchased item
     */
    public void recordPurchase(double amount) {
        purchase += amount;
    }

    /**
     * Processes the payment received from the customer.
     * @param dollars number of dollars in the payment
     * @param quarters number of quarters in the payment
     * @param dimes number of dimes in the payment
     * @param nickels number of nickels in the payment
     * @param pennies number of pennies in the payment
     */
    public void receivePayment(int dollars, int quarters, int dimes, int nickels, int pennies) {
        payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
    }

    /**
     * Computes the change due and resets the machine for the next customer.
     * @return the change due to the customer
     */
    public double giveChange() {
        double change = payment - purchase;
        purchase = 0;
        payment = 0;
        return change;
    }
}



