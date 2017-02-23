package qualification.round2016;

import com.google.gson.Gson;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Warehouses {
    private transient Gson gson;
    private int numberOfWarehouses;
    private Warehouse[] warehouses;

    public Warehouses(Gson gson, int numberOfWarehouses){
        this.gson = gson;
        this.numberOfWarehouses = numberOfWarehouses;
        this.warehouses = new Warehouse[numberOfWarehouses];
    }

    @Override
    public String toString() {
        return gson.toJson(this);
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
