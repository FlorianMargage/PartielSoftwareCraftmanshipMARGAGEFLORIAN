/*
 * classe LoyalCustomerOrder mis dans un autre fichier (1 classe 1 fichier)
 */
public class LoyalCustomerOrder extends Order {
    @Override
    public void applyDiscount() {
        // Appliquer une remise de 10%
        setTotalPrice(getTotalPrice() * 0.9);
    }
}