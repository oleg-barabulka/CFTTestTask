package org.example;

import org.example.exceptions.BufferEndException;
import org.example.fileWork.FileManager;
import org.example.sortTypes.Value;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Sorter {

    ArrayList<Value> valueArrayList;
    BufferedWriter output;

    InputParams inputParams;

    public Sorter(InputParams inputParams){
        this.inputParams = inputParams;
        FileManager fileManager = new FileManager();
        BufferedReader[] inputs = fileManager.getInput(inputParams.getInputFilesParam());
        output = fileManager.getOutput(inputParams.getOutputFileParam());
        ArrayList<Value> values = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++){
            values.add(Value.of(inputParams.getTypeParam()));
            values.get(i).setInputStream(inputs[i]);
        }
        valueArrayList = values;
    }
    public void sort(){
        Value outputValue;
        int deletedCount = 0;
        for (int i = 0; i < valueArrayList.size() + deletedCount; i++){
            try {
                valueArrayList.get(i - deletedCount).nextValue();
            } catch (BufferEndException e) {
                valueArrayList.remove(valueArrayList.get(i - deletedCount));
                deletedCount++;
            }
        }
        while (!valueArrayList.isEmpty()){
            if ( inputParams.orderParam == InputParams.ASCENDING){
                outputValue = Collections.min(valueArrayList);
            }else {
                outputValue = Collections.max(valueArrayList);
            }
            try {
                output.write(outputValue.toString());
            } catch (IOException e) {
                System.err.println("Writing to file failed");
                throw new RuntimeException(e);
            }
            try {
                outputValue.nextValue(outputValue, inputParams.orderParam);
            } catch (BufferEndException e) {
                valueArrayList.remove(outputValue);
            }
        }
        try {
            output.close();
        } catch (IOException e) {
            System.err.println("Failed to close file");
            throw new RuntimeException(e);
        }
    }
}
