package app.persistence;

/**
 * @author Daniel Rouvillain
 */

public class Orderline {

    private int orderlineId;
    private int topId;
    private int bottomId;
    private int quantity;
    private int totalPrice;


    public Orderline(int orderlineId, int topId, int bottomId, int quantity, int totalPrice) {
        this.orderlineId = orderlineId;
        this.topId = topId;
        this.bottomId = bottomId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getOrderlineId() {
        return orderlineId;
    }

    public int getTopId() {
        return topId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
