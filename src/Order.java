import javafx.util.Pair;

/**
 * Created by kyle.mcallister on 2/21/2017.
 */
public class Order {
    private Pair<Integer, Integer> destination;
    private int numberOfProductsToBeDelivered;
    private int[] productTypesToDeliver;

    public Order(Pair<Integer, Integer> destination, int numberOfProductsToBeDelivered, int[] productTypesToDeliver) {
        this.destination = destination;
        this.numberOfProductsToBeDelivered = numberOfProductsToBeDelivered;
        this.productTypesToDeliver = productTypesToDeliver;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Destination: " + destination + "|");
        ret.append("Number of Products to be Delivered: " + numberOfProductsToBeDelivered + "|");
        ret.append("Product Types to be Delivered [");
        for (int i = 0; i < numberOfProductsToBeDelivered; i++){
            ret.append(productTypesToDeliver[i] + ",");
        }
        ret.deleteCharAt(ret.length()-1);
        ret.append("]");

        return ret.toString();
    }

    public Pair<Integer, Integer> getDestination() {
        return destination;
    }

    public void setDestination(Pair<Integer, Integer> destination) {
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
