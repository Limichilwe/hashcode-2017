package qualification.round2016;

import com.google.gson.Gson;
import javafx.util.Pair;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Warehouse {
    private transient Gson gson;
    private Location location;
    private int numberOfProducts;
    private int[] availabilityOfEachProduct;


    public Warehouse(Gson gson, Location location, int numberOfProducts, int[] availabilityOfEachProduct) {
        this.gson = gson;
        this.location = location;
        this.numberOfProducts = numberOfProducts;
        this.availabilityOfEachProduct = availabilityOfEachProduct;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int[] getAvailabilityOfEachProduct() {
        return availabilityOfEachProduct;
    }

    public void setAvailabilityOfEachProduct(int index, int availability) {
        this.availabilityOfEachProduct[index] = availability;
    }
}
