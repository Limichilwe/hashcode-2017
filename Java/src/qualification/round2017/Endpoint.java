package qualification.round2017;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Endpoint {
    private Cache[] connectedCache;
    private int latencyFromDC;
    private int id;

    public Endpoint(Cache[] connectedCache, int latencyFromDC, int id) {
        this.connectedCache = connectedCache;
        this.latencyFromDC = latencyFromDC;
        this.id = id;
    }

    public Cache[] getConnectedCache() {
        return connectedCache;
    }

    public void setConnectedCache(Cache[] connectedCache) {
        this.connectedCache = connectedCache;
    }

    public int getLatencyFromDC() {
        return latencyFromDC;
    }

    public void setLatencyFromDC(int latencyFromDC) {
        this.latencyFromDC = latencyFromDC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
