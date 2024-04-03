package app.persistence;

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
