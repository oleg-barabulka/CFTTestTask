package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class InputParams {
    public static final char ASCENDING = 'a';
    public static final char DESCENDING = 'd';
    public static final char STRING_TYPE = 's';
    public static final char INTEGER_TYPE = 'i';
    private static final char FLAG_MARK = '-';
    private static final int FLAG_MARK_POS = 0;
    private static final int FLAG_POS = 1;
    private static final int OUTPUT_FILE_COUNT = 1;
    public char orderParam = ASCENDING;
    public char typeParam;
    public String[] inputFilesParam;
    public String outputFileParam;

    public InputParams(String[] inputArgs){
        ArrayList<String> flagList = new ArrayList<>();
        for (String inputArg : inputArgs) {
            if (inputArg.charAt(FLAG_MARK_POS) == FLAG_MARK) {
                flagList.add(inputArg);
            }
        }
        flagProcessing(flagList);
        outputFileParam = inputArgs[flagList.size()];
        inputFilesParam = Arrays.copyOfRange(inputArgs, flagList.size() + OUTPUT_FILE_COUNT, inputArgs.length);
    }
    private void flagProcessing(ArrayList<String> flagList){
        if (flagList.size() > 2){
            System.err.println("Too many args");
            System.exit(1);
        } else if (flagList.isEmpty()) {
            System.err.println("Too few args");
            System.exit(1);
        }

        if (flagList.get(0).charAt(FLAG_POS) == ASCENDING || flagList.get(0).charAt(FLAG_POS) == DESCENDING){
            switch (flagList.get(0).charAt(FLAG_POS)){
                case ASCENDING -> orderParam = ASCENDING;
                case DESCENDING -> orderParam = DESCENDING;
            }
        } else if (flagList.get(0).charAt(FLAG_POS) == INTEGER_TYPE || flagList.get(0).charAt(FLAG_POS) == STRING_TYPE) {
            switch (flagList.get(0).charAt(FLAG_POS)){
                case INTEGER_TYPE -> typeParam = INTEGER_TYPE;
                case STRING_TYPE -> typeParam = STRING_TYPE;
            }
        } else {
            System.err.println("Unknown arg");
            System.exit(1);
        }
        if ( flagList.size() > 1) {
            if (flagList.get(1).charAt(FLAG_POS) == ASCENDING || flagList.get(1).charAt(FLAG_POS) == DESCENDING) {
                switch (flagList.get(1).charAt(FLAG_POS)) {
                    case ASCENDING -> orderParam = ASCENDING;
                    case DESCENDING -> orderParam = DESCENDING;
                }
            } else if (flagList.get(1).charAt(FLAG_POS) == INTEGER_TYPE || flagList.get(1).charAt(FLAG_POS) == STRING_TYPE) {
                switch (flagList.get(1).charAt(FLAG_POS)) {
                    case INTEGER_TYPE -> typeParam = INTEGER_TYPE;
                    case STRING_TYPE -> typeParam = STRING_TYPE;
                }
            } else {
                System.err.println("Unknown arg");
                System.exit(1);
            }
        }
    }
}
