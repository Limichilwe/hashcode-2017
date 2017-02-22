/**
 * Created by kyle.mcallister on 2/20/2017.
 */
public class Parameters {

    private int rows;
    private int columns;
    private int numberOfDrones;
    private int numberOfTurns;
    private int maxPayload;

    public Parameters(int rows, int columns, int numberOfDrones, int numberOfTurns, int maxPayload) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfDrones = numberOfDrones;
        this.numberOfTurns = numberOfTurns;
        this.maxPayload = maxPayload;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        ret.append("Rows: " + rows + "|");
        ret.append("Columns: " + columns + "|");
        ret.append("Number Of Drones: " + numberOfDrones + "|");
        ret.append("Number Of Turns: " + numberOfTurns + "|");
        ret.append("Max Payload: " + maxPayload);

        return ret.toString();
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
