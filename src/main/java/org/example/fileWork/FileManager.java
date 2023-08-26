package org.example.fileWork;

import java.io.*;

public class FileManager {
    public BufferedReader[] getInput(String[] fileNames){
        BufferedReader[] readerArray = new BufferedReader[fileNames.length];
        int brokenFiles = 0;
        for (int i = 0; i < fileNames.length; i++){
            try {
                readerArray[i - brokenFiles] = new BufferedReader(new FileReader(fileNames[i]));
            } catch (FileNotFoundException ignored) {
                brokenFiles++;
                BufferedReader[] newReaderArray = new BufferedReader[fileNames.length - brokenFiles];
                System.arraycopy(readerArray, 0 , newReaderArray, 0, newReaderArray.length);
                readerArray = newReaderArray;
            }
        }
        return readerArray;
    }

    public BufferedWriter getOutput(String outputFileName){
        File outputFile = new File(outputFileName);
        try {
            return new BufferedWriter(new FileWriter(outputFile));
        } catch (IOException e) {
            System.err.println("Failed to open file for writing");
            throw new RuntimeException(e);
        }
    }
}
