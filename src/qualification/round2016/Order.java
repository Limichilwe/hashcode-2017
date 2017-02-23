package qualification.round2016;

import com.google.gson.Gson;
import javafx.util.Pair;

/**
 * Created by kyle.mcallister on 2/21/2017.
 */
public class Order {
    private transient Gson gson;
    private Location destination;
    private int numberOfProductsToBeDelivered;
    private int[] productTypesToDeliver;

    public Order(Gson gson, Location destination, int numberOfProductsToBeDelivered, int[] productTypesToDeliver) {
        this.gson = gson;
        this.destination = destination;
        this.numberOfProductsToBeDelivered = numberOfProductsToBeDelivered;
        this.productTypesToDeliver = productTypesToDeliver;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public int getNumberOfProductsToBeDelivered() {
        return numberOfProductsToBeDelivered;
    }

    public void setNumberOfProductsToBeDelivered(int numberOfProductsToBeDelivered) {
        this.numberOfProductsToBeDelivered = numberOfProductsToBeDelivered;
    }

    public int[] getProductTypesToDeliver() {
        return productTypesToDeliver;
    }

    public void setProductTypesToDeliver(int[] productTypesToDeliver) {
        this.productTypesToDeliver = productTypesToDeliver;
    }
}
