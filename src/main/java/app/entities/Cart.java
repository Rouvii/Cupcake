package app.entities;

import app.persistence.BottomMapper;
import app.persistence.TopMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public static int calculateTotalPrice(List<Orderline> cartItems, ConnectionPool connectionPool) {
        int totalPrice = 0;

        for (Orderline cartItem : cartItems) {
            int topPrice = TopMapper.getTopPriceFromDatabase(cartItem.getTopId(), connectionPool);
            int bottomPrice = BottomMapper.getBottomPriceFromDatabase(cartItem.getBottomId(), connectionPool);
            totalPrice += (topPrice + bottomPrice) * cartItem.getQuantity();
        }


        return totalPrice;
    }
}

