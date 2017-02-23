package qualification.round2016;

import com.google.gson.Gson;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class CustomerOrders {
    private transient Gson gson;
    private int numberOfOrders;
    private Order[] orders;

    public CustomerOrders(Gson gson, int numberOfOrders) {
        this.gson = gson;
        this.numberOfOrders = numberOfOrders;
        this.orders = new Order[numberOfOrders];
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(int index, Order order) {
        this.orders[index] = order;
    }
}
