package qualification.round2017;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class ProblemDescription {
    private transient Gson gson;

    private Video[] videos;
    private Endpoint[] endpoints;
    private Request[] requests;
    private CacheServer[] cacheSet;

    public ProblemDescription(Gson gson, File inputFile) {

        this.gson = gson;

        ArrayList<String> lines = new ArrayList<>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
            do {
                lines.add(scanner.nextLine());
            } while (scanner.hasNext());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null){
                scanner.close();
            }

        }

        int lineIndex = 0;
        String[] lineSplit = null;

        //parameters:
        lineSplit = lines.get(lineIndex).split(" ");

        this.videos = new Video[Integer.parseInt(lineSplit[0])];
        this.endpoints = new Endpoint[Integer.parseInt(lineSplit[1])];
        this.requests = new Request[Integer.parseInt(lineSplit[2])];
        this.cacheSet = new CacheServer[Integer.parseInt(lineSplit[3])];
        int cacheSize = Integer.parseInt(lineSplit[4]);
        lineIndex++;

        //Videos:
        lineSplit = lines.get(lineIndex).split(" ");

        for (int i = 0; i < videos.length; i++) {
            videos[i] = new Video(Integer.parseInt(lineSplit[i]), i);
        }
        lineIndex++;
        //Endpoints:
        int lataencyFromDC;
        int numberOfConnectedCache;
        Cache[] connectedCache = null;
        for (int i = 0; i < endpoints.length; i++) {
            lineSplit = lines.get(lineIndex).split(" ");
            //endpoint i:
            lataencyFromDC = Integer.parseInt(lineSplit[0]);
            numberOfConnectedCache = Integer.parseInt(lineSplit[1]);
            connectedCache = new Cache[numberOfConnectedCache];
            this.endpoints[i] = new Endpoint(connectedCache, lataencyFromDC, i);
            lineIndex++;
            int cacheID;
            int latency;
            for (int j = 0; j < numberOfConnectedCache; j++) {
                lineSplit = lines.get(lineIndex).split(" ");
                cacheID = Integer.parseInt(lineSplit[0]);
                latency = Integer.parseInt(lineSplit[1]);
                this.cacheSet[cacheID] = new CacheServer(cacheSize, cacheID);
                this.endpoints[i].getConnectedCache()[j] = new Cache(cacheSize, latency, cacheID);
                lineIndex++;
            }
        }
        //Requests:
        int videoID;
        int endpointID;
        int numberOfRequests;
        for (int i = 0; i < this.requests.length; i++) {
            lineSplit = lines.get(lineIndex).split(" ");
            videoID = Integer.parseInt(lineSplit[0]);
            endpointID = Integer.parseInt(lineSplit[1]);
            numberOfRequests = Integer.parseInt(lineSplit[2]);
            this.requests[i] = new Request(numberOfRequests, videoID, endpointID);
            lineIndex++;
        }

    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

    public Video[] getVideos() {
        return videos;
    }

    public void setVideos(Video[] videos) {
        this.videos = videos;
    }

    public Endpoint[] getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Endpoint[] endpoints) {
        this.endpoints = endpoints;
    }

    public Request[] getRequests() {
        return requests;
    }

    public void setRequests(Request[] requests) {
        this.requests = requests;
    }

    public CacheServer[] getCaches() {
        return cacheSet;
    }

    public void setCaches(CacheServer[] caches) {
        this.cacheSet = caches;
    }
}
