package qualification.round2017;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Scorer {

    public static double scoreConfig(Video[] videos, Endpoint[] endpoints, CacheServer[] configuration, Request[] requests) {
        double ret = 0;

        int[] requestsScores = new int[requests.length];

        Request request = null;
        Video video =  null;
        Endpoint endpoint = null;
        for (int i = 0; i < requests.length; i++) {
            request = requests[i];
            video = videos[request.getVideoIndex()];
            endpoint = endpoints[request.getEndpointIndex()];
            requestsScores[i] = scoreRequest(configuration, request, video, endpoint);
        }

        for (int rScore: requestsScores) {
            ret +=rScore;
        }

        ret = ret/requestsScores.length;

        return ret;
    }

    private static int scoreRequest(CacheServer[] configuration, Request request, Video video, Endpoint endpoint) {
        int ret = 0;

        int timeFromDC = endpoint.getLatencyFromDC();
        int actualTime = -1;
        int lowestActualTime = timeFromDC;

        CacheServer cacheServer = null;
        for (Cache connectedCache: endpoint.getConnectedCache()) {
            cacheServer = configuration[connectedCache.getId()];
            for (Video storedVideo:cacheServer.getStoredVideos()) {
                if(storedVideo.getId() == video.getId()){
                    actualTime = connectedCache.getLatencyFromEndpoint();
                    if( actualTime < lowestActualTime){
                        lowestActualTime = actualTime;
                    }
                }
            }
        }

        ret = timeFromDC - lowestActualTime;

        return ret;
    }
}
