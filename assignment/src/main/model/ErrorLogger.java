package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorLogger {
    private PrintWriter logStream;

    public ErrorLogger(){
        try {
            logStream = new PrintWriter(new FileWriter("error-log.txt", true), true);

        }catch (IOException ioe) {
            System.out.println("CAN INIT ERROR LOG.");
            ioe.printStackTrace();
        }
    }

    public <T extends Exception> void log(T ex){
        this.logStream.println(ex.toString());
    }
}


