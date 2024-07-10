package PartielSoftwareCraftmanshipMARGAGEFLORIAN.CODE;

public class OrderProcessor {
    private Database database;
    private EmailService emailService;
    private InventorySystem inventorySystem;

    public OrderProcessor() {
        this.database = new Database();
        this.emailService = new EmailService();
        this.inventorySystem = new InventorySystem();
    }

    /*
     * changement de "items" par "orderList" pour comprendre que c'est une liste de
     * "order"
     */
    public void processOrder(Order order) {
        // Vérifier la disponibilité des articles en stock
        List<Item> orderList = order.getItems();
        for (Item item : orderList) {
            if (!inventorySystem.isItemAvailable(item)) {
                throw new RuntimeException("Item not available in inventory");
            }
        }
        // Enregistrer la commande dans la base de données
        database.saveOrder(order);
        // Envoyer un e-mail de confirmation au client
        String message = "Your order has been received and is being processed.";
        emailService.sendEmail(order.getCustomerEmail(), "Order Confirmation", message);
        // Mettre à jour l'inventaire
        for (Item item : orderList) {
            inventorySystem.updateInventory(item, item.getQuantity() * -1);
        }
        // Appliquer une remise pour les clients fidèles
        if (order instanceof LoyalCustomerOrder) {
            LoyalCustomerOrder loyalCustomerOrder = (LoyalCustomerOrder) order;
            loyalCustomerOrder.applyDiscount();
        }
    }
}
