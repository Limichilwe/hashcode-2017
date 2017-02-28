package qualification.round2017;

import com.google.gson.Gson;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Request {

    private int numberOfRequests;
    private int videoIndex;
    private int endpointIndex;

    public Request(int numberOfRequests, int videoIndex, int endpointIndex) {
        this.numberOfRequests = numberOfRequests;
        this.videoIndex = videoIndex;
        this.endpointIndex = endpointIndex;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public int getVideoIndex() {
        return videoIndex;
    }

    public void setVideoIndex(int videoIndex) {
        this.videoIndex = videoIndex;
    }

    public int getEndpointIndex() {
        return endpointIndex;
    }

    public void setEndpointIndex(int endpointIndex) {
        this.endpointIndex = endpointIndex;
    }
}
