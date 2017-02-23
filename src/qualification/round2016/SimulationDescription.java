package qualification.round2016;

import com.google.gson.Gson;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class SimulationDescription {
    private transient Gson gson;
    private Parameters parameters;
    private Products products;
    private Warehouses warehouses;
    private CustomerOrders customerOrders;

    public SimulationDescription(Gson gson, File inputFile){

        this.gson = gson;
        ArrayList<String> lines = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
            do{
                lines.add(scanner.nextLine());
            }while(scanner.hasNext());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }

        int lineIndex = 0;
        String[] lineSplit = null;
        //parameters:
        lineSplit = lines.get(lineIndex).split(" ");
        int rows = Integer.parseInt(lineSplit[0]);
        int columns = Integer.parseInt(lineSplit[1]);
        int numberOfDrones = Integer.parseInt(lineSplit[2]);
        int numberOfTurns = Integer.parseInt(lineSplit[3]);
        int maxPayload = Integer.parseInt(lineSplit[4]);
        parameters = new Parameters(gson, rows, columns, numberOfDrones, numberOfTurns, maxPayload);
        lineIndex++;

        //number product types:
        lineSplit = lines.get(lineIndex).split(" ");
        int numberOfProducts = Integer.parseInt(lineSplit[0]);
        products = new Products(gson, numberOfProducts);
        lineIndex++;

        //weights of each product type
        lineSplit = lines.get(lineIndex).split(" ");
        for (int i = 0; i < products.getNumberOfProductTypes(); i++){
            products.setProductWeights(i, Integer.parseInt(lineSplit[i]));
        }
        lineIndex++;

        //number of warehouses
        lineSplit = lines.get(lineIndex).split(" ");
        int numberOfWarehouses = Integer.parseInt(lineSplit[0]);
        warehouses = new Warehouses(gson, numberOfWarehouses);
        lineIndex++;

        /*
            per warehouse:
                - location
                - product availability
         */
        int xCoordinate;
        int yCoordinate;
        Location location = null;
        int[] productAvailabilities = null;
        Warehouse warehouse = null;
        for (int i = 0; i < warehouses.getNumberOfWarehouses(); i++) {
            //location:
            lineSplit = lines.get(lineIndex).split(" ");
            xCoordinate = Integer.parseInt(lineSplit[0]);
            yCoordinate = Integer.parseInt(lineSplit[1]);
            location = new Location(xCoordinate, yCoordinate);
            //product availabilities:
            lineIndex++;
            lineSplit = lines.get(lineIndex).split(" ");
            productAvailabilities = new int[numberOfProducts];
            for(int j = 0; j < numberOfProducts; j++){
                productAvailabilities[j] = Integer.parseInt(lineSplit[j]);
            }
            warehouse = new Warehouse(gson, location, numberOfProducts, productAvailabilities);
            warehouses.setWarehouses(i, warehouse);
            lineIndex++;
        }

        //number of orders
        lineSplit = lines.get(lineIndex).split(" ");
        int numberOfOrders = Integer.parseInt(lineSplit[0]);
        customerOrders = new CustomerOrders(gson, numberOfOrders);
        lineIndex++;

        /*
            per order:
                - destination
                - number of items in order
                - types of products in order
                -
         */
        int numberOfProductsInOrder;
        int[] productTypesToDeliver = null;
        Order order = null;
        for(int i = 0; i < numberOfOrders; i ++){
            //destination:
            lineSplit = lines.get(lineIndex).split(" ");
            xCoordinate = Integer.parseInt(lineSplit[0]);
            yCoordinate = Integer.parseInt(lineSplit[1]);
            location = new Location(xCoordinate, yCoordinate);
            lineIndex++;
            //number of products in order:
            lineSplit = lines.get(lineIndex).split(" ");
            numberOfProductsInOrder = Integer.parseInt(lineSplit[0]);
            lineIndex++;
            //types of products in order:
            lineSplit = lines.get(lineIndex).split(" ");
            productTypesToDeliver = new int[numberOfProductsInOrder];
            for(int j = 0; j < numberOfProductsInOrder; j++){
                productTypesToDeliver[j] = Integer.parseInt(lineSplit[j]);
            }
            order = new Order(gson, location, numberOfProductsInOrder, productTypesToDeliver);
            customerOrders.setOrders(i, order);
            lineIndex++;
        }
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
