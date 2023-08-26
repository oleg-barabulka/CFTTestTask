package org.example.sortTypes;

import org.example.exceptions.BufferEndException;

import java.io.BufferedReader;

public abstract class AbstractValue<T> implements Value{
    protected T innerValue;
    protected T prevInnerValue;
    protected BufferedReader valueStream;

    @Override
    public void nextValue(Value prevValue, char order) throws BufferEndException {
        prevInnerValue = (T) prevValue.getValue();
        nextValue(order);
    }
    @Override
    public void setInputStream(BufferedReader reader) {
        valueStream = reader;
    }

    @Override
    public Object getValue() {
        return innerValue;
    }

    @Override
    public String toString() {
        return innerValue + "\n";
    }

    @Override
    public int compareTo(Value o) {
        return 0;
    }
}
