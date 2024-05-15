package integration;

import model.RegisterObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements RegisterObserver {
    private PrintWriter logStream;

    public TotalRevenueFileOutput(){
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);

        }catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    public void onRevenueChange(float updatedRevenue){
        logStream.println(updatedRevenue);
    }
}
