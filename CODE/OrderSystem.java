package PartielSoftwareCraftmanshipMARGAGEFLORIAN.CODE;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderSystem {
    private Map<Integer, List<String>> orderList; // Liste des commandes

    /*
     * en programmation, on commente son code si nécessaire et le code doit être le
     * plus lisible possible
     * ici, on peut voir que la fonction addNewOrder comprend en argument customerID
     * et itemName
     * On peut aussi voir qu'on a "items" qui comme itemName ne signifie rien
     * customerID : on comprend que c'est l'id d'un customer, donc l'identifiant
     * d'un client
     * itemName : la ca pose problème car ca pourrait être tout et rien
     * on va donc changer le nom "itemName" par "newOrder" qui est plus approprié
     * items : la aussi ca pose problème car ça ne signifie rien, on va donc le
     * changer par quelque chose de plus approprié, par exemple "newOrderList"
     */
    public void addNewOrder(Integer customerID, String newOrder) {
        List<String> newOrderList = orderList.getOrDefault(customerID, new ArrayList<>());
        newOrderList.add(newOrder);
        orderList.put(customerID, newOrderList);
    }

    /*
     * On va faire pareil
     */
    public void modifyOrder(Integer customerID, Integer orderID, String newOrder) {
        List<String> newOrderList = orderList.get(customerID);
        if (newOrderList != null && orderID < newOrderList.size()) {
            newOrderList.set(orderID, newOrder);
        }
    }

    /*
     * Ici aussi
     */
    public void removeOrder(Integer customerID, Integer OrderID) {
        List<String> newOrderList = orderList.get(customerID);
        if (newOrderList != null && OrderID < newOrderList.size()) {
            newOrderList.remove(OrderID);
        }
    }

    /*
     * Ici on voit une répétition de la fonction System.out.println(), on pourrait
     * simplement utiliser '\n' pour le retour à la ligne, donc :
     */
    public void printOrders() {
        for (Map.Entry<Integer, List<String>> entry : orderList.entrySet()) {
            System.out.println(
                    "Customer ID: " + entry.getKey() + "\nItems: " + String.join(", ", entry.getValue()) + "\n");
        }
    }
}
