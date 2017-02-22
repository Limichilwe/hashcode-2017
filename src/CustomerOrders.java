/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class CustomerOrders {
    private int numberOfOrders;
    private Order[] orders;

    public CustomerOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
        this.orders = new Order[numberOfOrders];
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Number of Orders: " + numberOfOrders + "|");
        ret.append("Customer Orders [");
        for (int i = 0; i < numberOfOrders; i ++){
            ret.append("\r\n\t" + orders[i]);
        }
        ret.append("]");
        return ret.toString();
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
