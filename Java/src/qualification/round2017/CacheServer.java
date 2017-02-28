package qualification.round2017;

import java.util.ArrayList;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class CacheServer {

    private int size;
    private int id;
    private ArrayList<Video> storedVideos;
    private int storageInUse;

    public CacheServer(int size, int id) {
        this.size = size;
        this.id = id;
        this.storedVideos = new ArrayList<>();
        this.storageInUse = 0;
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

    public ArrayList<Video> getStoredVideos() {
        return storedVideos;
    }

    public Video addVideo(Video video){
        Video ret = null;
        if((video.getSize() + storageInUse) < size){
            for (Video storedvideo:storedVideos) {
                if(storedvideo.getId() == video.getId()){
                    return null;
                }
            }
            this.storedVideos.add(video);
            storageInUse += video.getSize();
            ret = video;
        }

        return ret;
    }

    public Video removeVideo(Video video){
        Video ret = null;

        if(storedVideos.remove(video)){
            ret = video;
            storageInUse -= ret.getSize();
        }

        return ret;
    }
}
