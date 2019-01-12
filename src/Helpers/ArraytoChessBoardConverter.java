package Helpers;

import java.util.HashMap;

public class ArraytoChessBoardConverter {

    //converts ie 0,0 to A8 (seen from white's perspective)

    public static String convertToChessBoardNotation(int horizontal, int vertical){

        HashMap<Integer, String> horizontalMap = new HashMap<>();

        horizontalMap.put(0,"a");
        horizontalMap.put(1,"b");
        horizontalMap.put(2,"c");
        horizontalMap.put(3,"d");
        horizontalMap.put(4,"e");
        horizontalMap.put(5,"f");
        horizontalMap.put(6,"g");
        horizontalMap.put(7,"h");

        HashMap<Integer, Integer> verticalMap = new HashMap<>();

        for(int i =0; i<=7; i++){
            verticalMap.put(i,8-i);
        }

        String xCoordinate = horizontalMap.get(horizontal);
        String yCoordinate = verticalMap.get(vertical).toString();

        return xCoordinate + yCoordinate;

    }
}
