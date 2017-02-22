import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            SimulationDescription simulationParameters = new SimulationDescription(jfc.getSelectedFile());
            System.out.println(simulationParameters);
        }

    }
}
