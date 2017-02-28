package qualification.round2017;

import java.util.Random;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Optimiser {

    private Video[] videos;
    private Endpoint[] endpoints;
    private CacheServer[] configuration;
    private Request[] requests;

    private Random rand;

    public Optimiser(Video[] videos, Endpoint[] endpoints, CacheServer[] configuration, Request[] requests) {
        this.videos = videos;
        this.endpoints = endpoints;
        this.configuration = configuration;
        this.requests = requests;
        this.rand = new Random();
    }

    public void optomise(){
        Video video =  null;
        Endpoint endpoint = null;
        CacheServer cacheServer = null;
        int cacheID;
        for (Request request: requests) {
            endpoint = endpoints[request.getEndpointIndex()];
            //random cacheID:
            if(endpoint.getConnectedCache().length <= 0){
                continue;
            }
            cacheID = endpoint.getConnectedCache()[rand.nextInt(endpoint.getConnectedCache().length)].getId();
            cacheServer = configuration[cacheID];
            video = videos[request.getVideoIndex()];
            cacheServer.addVideo(video);
        }
    }

    public double score(){
        double ret = 0;
        ret = Scorer.scoreConfig(videos, endpoints, configuration, requests);
        return ret;
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

    public CacheServer[] getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CacheServer[] configuration) {
        this.configuration = configuration;
    }

    public Request[] getRequests() {
        return requests;
    }

    public void setRequests(Request[] requests) {
        this.requests = requests;
    }
}
