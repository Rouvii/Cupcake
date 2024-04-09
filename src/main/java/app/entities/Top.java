package app.entities;

/**
 * @author Daniel Rouvillain
 */

public class Top {

    private int topId;
    private String top;
    private int topPrice;

    public Top(int topId, String top, int topPrice) {
        this.topId = topId;
        this.top = top;
        this.topPrice = topPrice;
    }



    public Top(String top, int topPrice) {
        this.top = top;
        this.topPrice = topPrice;
    }

    public int getTopId() {
        return topId;
    }

    public String getTop() {
        return top;
    }

    public int getTopPrice() {
        return topPrice;
    }

    @Override
    public String toString() {
        return "Top{" +
                ", top='" + top + '\'' +
                ", topPrice=" + topPrice +
                '}';
    }
}
