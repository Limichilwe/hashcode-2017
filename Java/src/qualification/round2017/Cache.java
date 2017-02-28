package qualification.round2017;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Cache {

    private int size;
    private int latencyFromEndpoint;
    private int id;


    public Cache(int size, int latencytoCache, int id) {
        this.latencyFromEndpoint = latencytoCache;
        this.size = size;
        this.id = id;

    }

    public int getLatencyFromEndpoint() {
        return latencyFromEndpoint;
    }

    public void setLatencyFromEndpoint(int latencytoCache) {
        this.latencyFromEndpoint = latencytoCache;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
