import javafx.util.Pair;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Warehouse {
    private Pair<Integer, Integer> location;
    private int numberOfProducts;
    private int[] availabilityOfEachProduct;

    public Warehouse(Pair<Integer, Integer> location, int numberOfProducts, int[] availabilityOfEachProduct) {
        this.location = location;
        this.numberOfProducts = numberOfProducts;
        this.availabilityOfEachProduct = availabilityOfEachProduct;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Location: " + location + "|");
        ret.append("Number of Products: " + numberOfProducts + "|");
        ret.append("Product Availabilities [");
        for (int i = 0; i < numberOfProducts; i++){
            ret.append(availabilityOfEachProduct[i] + ",");
        }
        ret.deleteCharAt(ret.length()-1);
        ret.append("]");

        return ret.toString();
    }

    public Pair<Integer, Integer> getLocation() {
        return location;
    }

    public void setLocation(Pair<Integer, Integer> location) {
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
