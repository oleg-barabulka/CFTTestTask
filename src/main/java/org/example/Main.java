package org.example;

public class Main {
    public static void main(String[] args) {
        InputParams inputParams = new InputParams(args);
        Sorter sorter = new Sorter(inputParams);
        sorter.sort();
    }
}