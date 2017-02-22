/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Products {
    private int numberOfProductTypes;
    private int[] productWeights;

    public Products(int numberOfProductTypes){
        this.numberOfProductTypes = numberOfProductTypes;
        this.productWeights = new int[numberOfProductTypes];
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Number of Product Types: " + numberOfProductTypes + "|");
        ret.append("Products Weights [");
        for (int i = 0; i < numberOfProductTypes; i ++){
            ret.append(productWeights[i]+ ",");
        }
        ret.deleteCharAt(ret.length()-1);
        ret.append("]");

        return ret.toString();
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
