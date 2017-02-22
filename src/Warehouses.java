/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Warehouses {
    private int numberOfWarehouses;
    private Warehouse[] warehouses;

    public Warehouses(int numberOfWarehouses){
        this.numberOfWarehouses = numberOfWarehouses;
        warehouses = new Warehouse[numberOfWarehouses];
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Number of Warehouses: " + numberOfWarehouses + "|");
        ret.append("Warehouses [");
        for (int i = 0; i < numberOfWarehouses; i++){
            ret.append("\r\n\t" + warehouses[i]);
        }
        ret.append("]");

        return ret.toString();
    }

    public int getNumberOfWarehouses() {
        return numberOfWarehouses;
    }

    public void setNumberOfWarehouses(int numberOfWarehouses) {
        this.numberOfWarehouses = numberOfWarehouses;
    }

    public Warehouse[] getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(int index, Warehouse warehouse) {
        this.warehouses[index] = warehouse;
    }
}
