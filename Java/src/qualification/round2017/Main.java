package qualification.round2017;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by kyle.mcallister on 2/23/2017.
 */
public class Main {
    public static void main(String[] args){

        Gson gson = new Gson();
        ProblemDescription problemDescription = null;

        File inputFile = new File("data/videos_worth_spreading.in");

        problemDescription = new ProblemDescription(gson, inputFile);


        Video[] videos = problemDescription.getVideos();
        Endpoint[] endpoints = problemDescription.getEndpoints();
        CacheServer[] configuration = problemDescription.getCaches();
        Request[] requests = problemDescription.getRequests();

        Optimiser optimiser = new Optimiser(videos, endpoints, configuration, requests);

        double score;
        CacheServer[] config = null;
        double oldScore = 0;

        optimiser.optomise();
        score = optimiser.score();
        config = optimiser.getConfiguration();

        do{
            oldScore = score;
            optimiser.optomise();
            score = optimiser.score();
            config = optimiser.getConfiguration();
            System.out.println("current score: " + score);
            System.out.println("optimising");
        }while(score > oldScore);

        System.out.println("Final Score: " + score);
        System.out.println("..done..");

        optimiser.optomise();
        double newScore = optimiser.score();
        CacheServer[] newConfig = optimiser.getConfiguration();

        System.out.println("");

        File outputFile = new File("Output.json");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(outputFile);
            int cacheServersInUse = 0;
            for (CacheServer server: configuration) {
                if(server.getStoredVideos().size() > 0){
                    cacheServersInUse++;
                }
            }
            printWriter.println(cacheServersInUse);
            System.out.println(cacheServersInUse);
            for (CacheServer cacheServer:configuration) {
                StringBuilder sb = new StringBuilder();
                for (Video video: cacheServer.getStoredVideos()) {

                    sb.append(video.getId() + " ");
                }
                if(sb.length() > 1){
                    sb.deleteCharAt(sb.length()-1);
                }
                printWriter.println(cacheServer.getId() + " " + sb);
                System.out.println(cacheServer.getId() + " " + sb);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(printWriter != null){
                printWriter.close();
            }
        }


    }
}
