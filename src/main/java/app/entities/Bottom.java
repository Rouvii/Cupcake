package app.entities;

/**
 * @author Daniel Rouvillain
 */

public class Bottom {

    private int bottomId;
    private String bottom;
    private int bottomPrice;

    public Bottom(int bottomId, String bottom, int bottomPrice) {
        this.bottomId = bottomId;
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
    }
    public Bottom(String bottom, int bottomPrice) {
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
    }

    public int calculateBottomPrice(int quantity) {
        return this.bottomPrice * quantity;
    }

    public int getBottomId() {
        return bottomId;
    }

    public String getBottom() {
        return bottom;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }




}
