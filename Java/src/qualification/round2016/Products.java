package qualification.round2016;

import com.google.gson.Gson;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Products {
    private transient Gson gson;
    private int numberOfProductTypes;
    private int[] productWeights;

    public Products(Gson gson, int numberOfProductTypes){
        this.gson = gson;
        this.numberOfProductTypes = numberOfProductTypes;
        this.productWeights = new int[numberOfProductTypes];
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public int getNumberOfProductTypes() {
        return numberOfProductTypes;
    }

    public void setNumberOfProductTypes(int numberOfProductTypes) {
        this.numberOfProductTypes = numberOfProductTypes;
    }

    public int[] getProductWeights() {
        return productWeights;
    }

    public void setProductWeights(int index, int weight) {
        this.productWeights[index] = weight;
    }
}
