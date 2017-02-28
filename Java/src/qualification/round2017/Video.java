package qualification.round2017;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Video {
    private int size;
    private int id;

    public Video(int size, int id) {
        this.size = size;
        this.id = id;
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
