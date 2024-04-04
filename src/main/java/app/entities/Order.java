package app.entities;

/**
 * @author Daniel Rouvillain
 */

public class Order {


    private int orderId;

    private int userId;

    private int orderlineId;

    private int finalPrice;

    public Order(int orderId, int userId, int orderlineId, int finalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderlineId = orderlineId;
        this.finalPrice = finalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrderlineId() {
        return orderlineId;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }
}
