package com.cqs.common.utils

/**
 * Created by li on 2015/12/4.
 */
class Console {
    static def readline(){
        return getNextLine()
    }

    static def readInteger(){
        return getNextToken().toInteger();
    }

    def static readDouble(){
        return getNextToken().toDouble()
    }

    def static readBoolean(){
        return getNextToken() == "true"
    }

    private static String getNextToken() {
        if (null == inputLine) {
            readline()
        }
        while (inputIndex == numberOfTokens) {
            readInputLine()
        }
        return inputTokens[inputIndex++]
    }

    private static String getNextLine(){
        if (inputLine == null){
            readline()
        }
        while(inputIndex  == numberOfTokens ){
            readline()
        }

        def line = inputTokens[inputIndex..< numberOfTokens]
        inputIndex = numberOfTokens
        return line
    }


    private static void readInputLine(){
        inputLine = System.in.readLines()
        inputTokens = inputLine.tokenize()
        numberOfTokens = inputTokens.size()
        inputIndex = 0
    }

    private static String inputLine = null;
    private static List inputTokens = null;
    private static int numberOfTokens = 0;
    private static int inputIndex = -1;
}
