package qualification.round2016;

import com.google.gson.Gson;

/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Parameters {

    private transient Gson gson;
    private int rows;
    private int columns;
    private int numberOfDrones;
    private int numberOfTurns;
    private int maxPayload;

    public Parameters(Gson gson, int rows, int columns, int numberOfDrones, int numberOfTurns, int maxPayload) {
        this.gson = gson;
        this.rows = rows;
        this.columns = columns;
        this.numberOfDrones = numberOfDrones;
        this.numberOfTurns = numberOfTurns;
        this.maxPayload = maxPayload;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getNumberOfDrones() {
        return numberOfDrones;
    }

    public void setNumberOfDrones(int numberOfDrones) {
        this.numberOfDrones = numberOfDrones;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }
}
