package org.example.sortTypes;

import org.example.InputParams;
import org.example.exceptions.BufferEndException;


import java.io.IOException;

public class StrValue extends AbstractValue<String> {

    @Override
    public void nextValue() throws BufferEndException {
        String newValue;
        try {
            if ((newValue = valueStream.readLine()) != null) {
                if (newValue.split(" ").length != 1) {
                    nextValue();
                }else {
                    innerValue = newValue;
                }
            } else throw new BufferEndException();
        } catch (IOException e) {
            System.err.println("File read failed");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void nextValue(char order) throws BufferEndException {
        nextValue();
        if (order == InputParams.ASCENDING){
            if (innerValue.compareTo(prevInnerValue) < 0){
                nextValue(order);
            }
        } else if (order == InputParams.DESCENDING){
            if (innerValue.compareTo(prevInnerValue) > 0){
                nextValue(order);
            }
        }
    }

    @Override
    public int compareTo(Value o) {
        String other = (String) o.getValue();
        return innerValue.compareTo(other);
    }


}
