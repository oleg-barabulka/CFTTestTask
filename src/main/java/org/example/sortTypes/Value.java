package org.example.sortTypes;

import org.example.InputParams;
import org.example.exceptions.BufferEndException;

import java.io.BufferedReader;

public interface Value extends Comparable<Value> {
    void setInputStream(BufferedReader reader);
    void nextValue() throws BufferEndException;
    void nextValue(Value value, char param) throws BufferEndException;
    void nextValue(char param)throws BufferEndException;
    Object getValue();

    static Value of(char valueType){
        if (valueType == InputParams.INTEGER_TYPE){
            return new IntValue();
        }else{
            return new StrValue();
        }
    }
}
