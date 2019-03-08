package Fun.OOD;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RestaurantOrderSystem {
    class User {
        String name;
        String phoneNumber;
        String address;
        String email;
        String creditCard;
        public boolean charge(int cost) {return true;}
    }

    class OrderRequest {
        private User user;
        private Map<String, Integer> items;
        int cost;

        public void addItemToTheOrder(String item, int count) {
            items.put(item, items.getOrDefault(item, 0) + count);
            this.cost = calculateCost();
        }

        public void removeItemFromTheOrder(String item, int count) {
            int res = items.getOrDefault(item, 0) - count;
            items.put(item, res <= 0 ? 0: res);
            this.cost = calculateCost();
        }

        public boolean submitOrder () {
            return user.charge(cost);
        }

        private int calculateCost() {
            int result = 0;
            return result + deliverFee;
        }
    }

    class Rider {
        String name;
        List<OrderConfirmation> ordersInDelivery;
        public String getLocationUpdate(){return "";}
        public void receiveOrder(OrderConfirmation order) {}
    }

    class OrderConfirmation {
        OrderRequest request;
        Rider rider;
        public String getDeliveryUpdate() {return rider.getLocationUpdate();}
        public boolean completeOrder() {return true;}
    }

    abstract class OrderManager {
        public OrderConfirmation dispatchOrder(OrderRequest request) {
            Rider rider = findRider();
            OrderConfirmation confirmation = new OrderConfirmation();
            rider.receiveOrder(confirmation);
            return confirmation;
        }
        public String getOrderUpdate(OrderConfirmation order) {
            return order.getDeliveryUpdate();
        }
        public Boolean completeOrder(OrderConfirmation order) {
            return order.completeOrder();
        }
        private Rider findRider() {return null;}
    }

    public String restaurantName;
    public String phoneNumber;
    public String address;
    public Map<String, Integer> menu;
    private int deliverFee;
    private OrderManager orderManager;
    private List<Rider> riders;

    public OrderConfirmation dispatchOrder(OrderRequest request) {
        return orderManager.dispatchOrder(request);
    }
    public String getOrderUpdate(OrderConfirmation order) {
        return orderManager.getOrderUpdate(order);
    }
    public Boolean completeOrder(OrderConfirmation order) {
        return orderManager.completeOrder(order);
    }
}
