package app.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Rouvillain
 */

public class Cart {

    private List<Orderline> cartItems = new ArrayList<>();


    public void addToCart(Orderline orderline){
        cartItems.add(orderline);
    }

    public List<Orderline> getCartItems() {
        return cartItems;
    }

    public void deleteCartItems(Orderline orderline){

        cartItems.remove(orderline);
    }
    /*
    public double getTotalPrice(){

        double sum = 0;

        for (Orderline cartItem : cartItems) {
            sum = sum + cartItem.getQuantity() * (cartItem.getTops().getTop_price() + cartItem.getBottoms().getBottom_price());
        }

        return sum;
    }

    public Order createOrders(User user) {

        Order orders = new Order(user.getId(), orderDate, false, user.getId());
        return orders;
    }

    public List<Orderline> moveCartItemsToOrderlines(Order orders) {
        List<Orderline> orderlines = new ArrayList<>();
        for (Orderline item : cartItems) {
            item.setOrderid(orders.getId());
            orderlines.add(item);
        }
        cartItems.clear();
        return orderlines;
    }*/
}

