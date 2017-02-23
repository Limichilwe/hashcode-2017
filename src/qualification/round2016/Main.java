package qualification.round2016;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            Gson gson = new Gson();
            SimulationDescription simulationParameters = new SimulationDescription(gson, jfc.getSelectedFile());

            File outputFile = new File("Output.json");
            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(outputFile);
                printWriter.println(simulationParameters);
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
}
